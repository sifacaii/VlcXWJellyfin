package org.chromium.ui.modaldialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.SparseArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.base.Callback;
import org.chromium.base.CommandLine;
import org.chromium.base.ObserverList;
import org.chromium.base.VisibleForTesting;
import org.chromium.ui.UiSwitches;
import org.chromium.ui.modaldialog.ModalDialogProperties;
import org.chromium.ui.modelutil.PropertyModel;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogManager.class */
public class ModalDialogManager {
    private final Presenter mDefaultPresenter;
    private Presenter mCurrentPresenter;
    private int mCurrentType;
    private boolean mDismissingCurrentDialog;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final SparseArray<Presenter> mPresenters = new SparseArray<>();
    private final SparseArray<List<PropertyModel>> mPendingDialogs = new SparseArray<>();
    private final Set<Integer> mSuspendedTypes = new HashSet();
    private final ObserverList<ModalDialogManagerObserver> mObserverList = new ObserverList<>();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogManager$ModalDialogManagerObserver.class */
    public interface ModalDialogManagerObserver {
        void onDialogShown(PropertyModel propertyModel);

        void onDialogHidden(PropertyModel propertyModel);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogManager$ModalDialogType.class */
    public @interface ModalDialogType {
        public static final int APP = 0;
        public static final int TAB = 1;
    }

    static {
        $assertionsDisabled = !ModalDialogManager.class.desiredAssertionStatus();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/modaldialog/ModalDialogManager$Presenter.class */
    public static abstract class Presenter {
        private Callback<Integer> mDismissCallback;
        private PropertyModel mDialogModel;
        static final /* synthetic */ boolean $assertionsDisabled;

        protected abstract void addDialogView(PropertyModel propertyModel);

        protected abstract void removeDialogView(PropertyModel propertyModel);

        static {
            $assertionsDisabled = !ModalDialogManager.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDialogModel(@Nullable PropertyModel model, @Nullable Callback<Integer> dismissCallback) {
            if (model == null) {
                removeDialogView(this.mDialogModel);
                this.mDialogModel = null;
                this.mDismissCallback = null;
            } else if (!$assertionsDisabled && this.mDialogModel != null) {
                throw new AssertionError("Should call setDialogModel(null) before setting a dialog model.");
            } else {
                this.mDialogModel = model;
                this.mDismissCallback = dismissCallback;
                addDialogView(model);
            }
        }

        public final void dismissCurrentDialog(int dismissalCause) {
            if (this.mDismissCallback == null) {
                return;
            }
            Callback<Integer> callback = this.mDismissCallback;
            this.mDismissCallback = null;
            callback.onResult(Integer.valueOf(dismissalCause));
        }

        public final PropertyModel getDialogModel() {
            return this.mDialogModel;
        }

        protected static String getContentDescription(PropertyModel model) {
            String description = (String) model.get(ModalDialogProperties.CONTENT_DESCRIPTION);
            if (description == null) {
                description = (String) model.get(ModalDialogProperties.TITLE);
            }
            return description;
        }
    }

    public ModalDialogManager(@NonNull Presenter defaultPresenter, int defaultType) {
        this.mDefaultPresenter = defaultPresenter;
        registerPresenter(defaultPresenter, defaultType);
    }

    public void destroy() {
        dismissAllDialogs(8);
        this.mObserverList.clear();
    }

    public void addObserver(ModalDialogManagerObserver observer) {
        this.mObserverList.addObserver(observer);
    }

    public void removeObserver(ModalDialogManagerObserver observer) {
        this.mObserverList.removeObserver(observer);
    }

    public void registerPresenter(Presenter presenter, int dialogType) {
        if (!$assertionsDisabled && this.mPresenters.get(dialogType) != null) {
            throw new AssertionError("Only one presenter can be registered for each type.");
        }
        this.mPresenters.put(dialogType, presenter);
    }

    public boolean isShowing() {
        return this.mCurrentPresenter != null;
    }

    public void showDialog(PropertyModel model, int dialogType) {
        showDialog(model, dialogType, false);
    }

    public void showDialog(PropertyModel model, int dialogType, boolean showAsNext) {
        if (CommandLine.getInstance().hasSwitch(UiSwitches.ENABLE_SCREENSHOT_UI_MODE)) {
            return;
        }
        List<PropertyModel> dialogs = this.mPendingDialogs.get(dialogType);
        if (dialogs == null) {
            SparseArray<List<PropertyModel>> sparseArray = this.mPendingDialogs;
            List<PropertyModel> arrayList = new ArrayList<>();
            dialogs = arrayList;
            sparseArray.put(dialogType, arrayList);
        }
        if (this.mSuspendedTypes.contains(Integer.valueOf(dialogType)) || (isShowing() && this.mCurrentType <= dialogType)) {
            dialogs.add(showAsNext ? 0 : dialogs.size(), model);
            return;
        }
        if (isShowing()) {
            suspendCurrentDialog();
        }
        if (!$assertionsDisabled && isShowing()) {
            throw new AssertionError();
        }
        this.mCurrentType = dialogType;
        this.mCurrentPresenter = this.mPresenters.get(dialogType, this.mDefaultPresenter);
        this.mCurrentPresenter.setDialogModel(model, dismissalCause -> {
            dismissDialog(model, dismissalCause.intValue());
        });
        Iterator<ModalDialogManagerObserver> it = this.mObserverList.iterator();
        while (it.hasNext()) {
            ModalDialogManagerObserver o = it.next();
            o.onDialogShown(model);
        }
    }

    public void dismissDialog(PropertyModel model, int dismissalCause) {
        if (model == null) {
            return;
        }
        if (this.mCurrentPresenter == null || model != this.mCurrentPresenter.getDialogModel()) {
            for (int i = 0; i < this.mPendingDialogs.size(); i++) {
                List<PropertyModel> dialogs = this.mPendingDialogs.valueAt(i);
                for (int j = 0; j < dialogs.size(); j++) {
                    if (dialogs.get(j) == model) {
                        ((ModalDialogProperties.Controller) dialogs.remove(j).get(ModalDialogProperties.CONTROLLER)).onDismiss(model, dismissalCause);
                        return;
                    }
                }
            }
        } else if (isShowing()) {
            if (!$assertionsDisabled && model != this.mCurrentPresenter.getDialogModel()) {
                throw new AssertionError();
            }
            if (this.mDismissingCurrentDialog) {
                return;
            }
            this.mDismissingCurrentDialog = true;
            ((ModalDialogProperties.Controller) model.get(ModalDialogProperties.CONTROLLER)).onDismiss(model, dismissalCause);
            Iterator<ModalDialogManagerObserver> it = this.mObserverList.iterator();
            while (it.hasNext()) {
                ModalDialogManagerObserver o = it.next();
                o.onDialogHidden(model);
            }
            this.mCurrentPresenter.setDialogModel(null, null);
            this.mCurrentPresenter = null;
            this.mDismissingCurrentDialog = false;
            showNextDialog();
        }
    }

    public void dismissAllDialogs(int dismissalCause) {
        for (int i = 0; i < this.mPendingDialogs.size(); i++) {
            dismissPendingDialogsOfType(this.mPendingDialogs.keyAt(i), dismissalCause);
        }
        if (isShowing()) {
            dismissDialog(this.mCurrentPresenter.getDialogModel(), dismissalCause);
        }
    }

    public void dismissDialogsOfType(int dialogType, int dismissalCause) {
        dismissPendingDialogsOfType(dialogType, dismissalCause);
        if (isShowing() && dialogType == this.mCurrentType) {
            dismissDialog(this.mCurrentPresenter.getDialogModel(), dismissalCause);
        }
    }

    private void dismissPendingDialogsOfType(int dialogType, int dismissalCause) {
        List<PropertyModel> dialogs = this.mPendingDialogs.get(dialogType);
        if (dialogs == null) {
            return;
        }
        while (!dialogs.isEmpty()) {
            PropertyModel model = dialogs.remove(0);
            ModalDialogProperties.Controller controller = (ModalDialogProperties.Controller) model.get(ModalDialogProperties.CONTROLLER);
            controller.onDismiss(model, dismissalCause);
        }
    }

    public void suspendType(int dialogType) {
        this.mSuspendedTypes.add(Integer.valueOf(dialogType));
        if (isShowing() && dialogType == this.mCurrentType) {
            suspendCurrentDialog();
            showNextDialog();
        }
    }

    public void resumeType(int dialogType) {
        this.mSuspendedTypes.remove(Integer.valueOf(dialogType));
        if (!isShowing()) {
            showNextDialog();
        }
    }

    private void suspendCurrentDialog() {
        if (!$assertionsDisabled && !isShowing()) {
            throw new AssertionError();
        }
        PropertyModel dialogView = this.mCurrentPresenter.getDialogModel();
        this.mCurrentPresenter.setDialogModel(null, null);
        this.mCurrentPresenter = null;
        this.mPendingDialogs.get(this.mCurrentType).add(0, dialogView);
    }

    private void showNextDialog() {
        if (!$assertionsDisabled && isShowing()) {
            throw new AssertionError();
        }
        for (int i = 0; i < this.mPendingDialogs.size(); i++) {
            int dialogType = this.mPendingDialogs.keyAt(i);
            if (!this.mSuspendedTypes.contains(Integer.valueOf(dialogType))) {
                List<PropertyModel> dialogs = this.mPendingDialogs.valueAt(i);
                if (!dialogs.isEmpty()) {
                    showDialog(dialogs.remove(0), dialogType);
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public PropertyModel getCurrentDialogForTest() {
        if (this.mCurrentPresenter == null) {
            return null;
        }
        return this.mCurrentPresenter.getDialogModel();
    }

    @VisibleForTesting
    public List<PropertyModel> getPendingDialogsForTest(int dialogType) {
        return this.mPendingDialogs.get(dialogType);
    }

    @VisibleForTesting
    public Presenter getPresenterForTest(int dialogType) {
        return this.mPresenters.get(dialogType);
    }

    @VisibleForTesting
    public Presenter getCurrentPresenterForTest() {
        return this.mCurrentPresenter;
    }
}
