package org.chromium.base.task;

import android.os.Process;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.BuildConfig;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.task.AsyncTask;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/ChromeThreadPoolExecutor.class */
class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: org.chromium.base.task.ChromeThreadPoolExecutor.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(() -> {
                Process.setThreadPriority(10);
                r.run();
            }, "CrAsyncTask #" + this.mCount.getAndIncrement());
            return t;
        }
    };
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new ArrayBlockingQueue(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    @VisibleForTesting
    ChromeThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    private static String getClassName(Runnable runnable) {
        Class blamedClass = runnable.getClass();
        try {
            if (blamedClass == AsyncTask.NamedFutureTask.class) {
                blamedClass = ((AsyncTask.NamedFutureTask) runnable).getBlamedClass();
            } else if (blamedClass.getEnclosingClass() == android.os.AsyncTask.class) {
                Field field = blamedClass.getDeclaredField("this$0");
                field.setAccessible(true);
                blamedClass = field.get(runnable).getClass();
            }
        } catch (IllegalAccessException e) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e2) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e2);
            }
        }
        return blamedClass.getName();
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        Map<String, Integer> counts = new HashMap<>();
        Runnable[] copiedQueue = (Runnable[]) getQueue().toArray(new Runnable[0]);
        for (Runnable runnable : copiedQueue) {
            String className = getClassName(runnable);
            int count = counts.containsKey(className) ? counts.get(className).intValue() : 0;
            counts.put(className, Integer.valueOf(count + 1));
        }
        return counts;
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> counts) {
        StringBuilder classesWithTooManyRunnables = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue().intValue() > 32) {
                classesWithTooManyRunnables.append(entry.getKey()).append(' ');
            }
        }
        if (classesWithTooManyRunnables.length() == 0) {
            return "NO CLASSES FOUND";
        }
        return classesWithTooManyRunnables.toString();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r) {
        try {
            super.execute(r);
        } catch (RejectedExecutionException e) {
            Map<String, Integer> counts = getNumberOfClassNameOccurrencesInQueue();
            throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(counts), e);
        }
    }
}
