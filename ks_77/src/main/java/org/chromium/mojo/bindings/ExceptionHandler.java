package org.chromium.mojo.bindings;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ExceptionHandler.class */
public interface ExceptionHandler {
    boolean handleException(RuntimeException runtimeException);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ExceptionHandler$DefaultExceptionHandler.class */
    public static class DefaultExceptionHandler implements ExceptionHandler {
        private ExceptionHandler mDelegate;

        @Override // org.chromium.mojo.bindings.ExceptionHandler
        public boolean handleException(RuntimeException e) {
            if (this.mDelegate != null) {
                return this.mDelegate.handleException(e);
            }
            throw e;
        }

        private DefaultExceptionHandler() {
        }

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ExceptionHandler$DefaultExceptionHandler$LazyHolder.class */
        private static class LazyHolder {
            static final DefaultExceptionHandler INSTANCE = new DefaultExceptionHandler();

            private LazyHolder() {
            }
        }

        public static DefaultExceptionHandler getInstance() {
            return LazyHolder.INSTANCE;
        }

        public void setDelegate(ExceptionHandler exceptionHandler) {
            this.mDelegate = exceptionHandler;
        }
    }
}
