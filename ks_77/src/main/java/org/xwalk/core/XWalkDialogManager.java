package org.xwalk.core;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkDialogManager.class */
public class XWalkDialogManager {
    public static final int DIALOG_NOT_FOUND = 1;
    public static final int DIALOG_OLDER_VERSION = 2;
    public static final int DIALOG_NEWER_VERSION = 3;
    public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
    public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
    public static final int DIALOG_DOWNLOAD_ERROR = 6;
    public static final int DIALOG_SELECT_STORE = 7;
    public static final int DIALOG_UNSUPPORTED_STORE = 8;
    public static final int DIALOG_DECOMPRESSING = 11;
    public static final int DIALOG_DOWNLOADING = 12;
    private static final String TAG = "XWalkDialogManager";
    private Context mContext;
    private Dialog mActiveDialog;
    private AlertDialog mNotFoundDialog;
    private AlertDialog mOlderVersionDialog;
    private AlertDialog mNewerVersionDialog;
    private AlertDialog mArchitectureMismatchDialog;
    private AlertDialog mSignatureCheckErrorDialog;
    private AlertDialog mDownloadErrorDialog;
    private AlertDialog mSelectStoreDialog;
    private AlertDialog mUnsupportedStoreDialog;
    private ProgressDialog mDecompressingDialog;
    private ProgressDialog mDownloadingDialog;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkDialogManager$ButtonAction.class */
    private static class ButtonAction {
        int mWhich;
        Runnable mClickAction;
        boolean mMandatory;

        ButtonAction(int which, Runnable command, boolean mandatory) {
            this.mWhich = which;
            this.mClickAction = command;
            this.mMandatory = mandatory;
        }
    }

    public XWalkDialogManager(Context context) {
        this.mContext = context;
    }

    public void setAlertDialog(int id, AlertDialog dialog) {
        if ((dialog instanceof ProgressDialog) || (dialog instanceof DatePickerDialog) || (dialog instanceof TimePickerDialog)) {
            throw new IllegalArgumentException("The type of dialog must be AlertDialog");
        }
        if (id == 1) {
            this.mNotFoundDialog = dialog;
        } else if (id == 2) {
            this.mOlderVersionDialog = dialog;
        } else if (id == 3) {
            this.mNewerVersionDialog = dialog;
        } else if (id == 4) {
            this.mArchitectureMismatchDialog = dialog;
        } else if (id == 5) {
            this.mSignatureCheckErrorDialog = dialog;
        } else if (id == 6) {
            this.mDownloadErrorDialog = dialog;
        } else if (id == 7) {
            this.mSelectStoreDialog = dialog;
        } else if (id == 8) {
            this.mUnsupportedStoreDialog = dialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + id);
        }
    }

    public void setProgressDialog(int id, ProgressDialog dialog) {
        if (id == 11) {
            this.mDecompressingDialog = dialog;
        } else if (id == 12) {
            this.mDownloadingDialog = dialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + id);
        }
    }

    public AlertDialog getAlertDialog(int id) {
        if (id == 1) {
            if (this.mNotFoundDialog == null) {
                this.mNotFoundDialog = buildAlertDialog();
                setTitle(this.mNotFoundDialog, R.string.startup_not_found_title);
                setMessage(this.mNotFoundDialog, R.string.startup_not_found_message);
                setPositiveButton(this.mNotFoundDialog, R.string.xwalk_get_crosswalk);
                setNegativeButton(this.mNotFoundDialog, R.string.xwalk_close);
            }
            return this.mNotFoundDialog;
        } else if (id == 2) {
            if (this.mOlderVersionDialog == null) {
                this.mOlderVersionDialog = buildAlertDialog();
                setTitle(this.mOlderVersionDialog, R.string.startup_older_version_title);
                setMessage(this.mOlderVersionDialog, R.string.startup_older_version_message);
                setPositiveButton(this.mOlderVersionDialog, R.string.xwalk_get_crosswalk);
                setNegativeButton(this.mOlderVersionDialog, R.string.xwalk_close);
            }
            return this.mOlderVersionDialog;
        } else if (id == 3) {
            if (this.mNewerVersionDialog == null) {
                this.mNewerVersionDialog = buildAlertDialog();
                setTitle(this.mNewerVersionDialog, R.string.startup_newer_version_title);
                setMessage(this.mNewerVersionDialog, R.string.startup_newer_version_message);
                setNegativeButton(this.mNewerVersionDialog, R.string.xwalk_close);
            }
            return this.mNewerVersionDialog;
        } else if (id == 4) {
            if (this.mArchitectureMismatchDialog == null) {
                this.mArchitectureMismatchDialog = buildAlertDialog();
                setTitle(this.mArchitectureMismatchDialog, R.string.startup_architecture_mismatch_title);
                setMessage(this.mArchitectureMismatchDialog, R.string.startup_architecture_mismatch_message);
                setPositiveButton(this.mArchitectureMismatchDialog, R.string.xwalk_get_crosswalk);
                setNegativeButton(this.mArchitectureMismatchDialog, R.string.xwalk_close);
            }
            return this.mArchitectureMismatchDialog;
        } else if (id == 5) {
            if (this.mSignatureCheckErrorDialog == null) {
                this.mSignatureCheckErrorDialog = buildAlertDialog();
                setTitle(this.mSignatureCheckErrorDialog, R.string.startup_signature_check_error_title);
                setMessage(this.mSignatureCheckErrorDialog, R.string.startup_signature_check_error_message);
                setNegativeButton(this.mSignatureCheckErrorDialog, R.string.xwalk_close);
            }
            return this.mSignatureCheckErrorDialog;
        } else if (id == 6) {
            if (this.mDownloadErrorDialog == null) {
                this.mDownloadErrorDialog = buildAlertDialog();
                setTitle(this.mDownloadErrorDialog, R.string.crosswalk_install_title);
                setMessage(this.mDownloadErrorDialog, R.string.download_failed_message);
                setPositiveButton(this.mDownloadErrorDialog, R.string.xwalk_retry);
                setNegativeButton(this.mDownloadErrorDialog, R.string.xwalk_cancel);
            }
            return this.mDownloadErrorDialog;
        } else if (id == 7) {
            if (this.mSelectStoreDialog == null) {
                this.mSelectStoreDialog = buildAlertDialog();
                setTitle(this.mSelectStoreDialog, R.string.crosswalk_install_title);
                setPositiveButton(this.mSelectStoreDialog, R.string.xwalk_continue);
            }
            return this.mSelectStoreDialog;
        } else if (id == 8) {
            if (this.mUnsupportedStoreDialog == null) {
                this.mUnsupportedStoreDialog = buildAlertDialog();
                setTitle(this.mUnsupportedStoreDialog, R.string.crosswalk_install_title);
                setMessage(this.mUnsupportedStoreDialog, R.string.unsupported_store_message);
                setNegativeButton(this.mUnsupportedStoreDialog, R.string.xwalk_close);
            }
            return this.mUnsupportedStoreDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + id);
        }
    }

    public ProgressDialog getProgressDialog(int id) {
        if (id == 11) {
            if (this.mDecompressingDialog == null) {
                this.mDecompressingDialog = buildProgressDialog();
                setTitle(this.mDecompressingDialog, R.string.crosswalk_install_title);
                setMessage(this.mDecompressingDialog, R.string.decompression_progress_message);
                setNegativeButton(this.mDecompressingDialog, R.string.xwalk_cancel);
                this.mDecompressingDialog.setProgressStyle(0);
            }
            return this.mDecompressingDialog;
        } else if (id == 12) {
            if (this.mDownloadingDialog == null) {
                this.mDownloadingDialog = buildProgressDialog();
                setTitle(this.mDownloadingDialog, R.string.crosswalk_install_title);
                setMessage(this.mDownloadingDialog, R.string.download_progress_message);
                setNegativeButton(this.mDownloadingDialog, R.string.xwalk_cancel);
                this.mDownloadingDialog.setProgressStyle(1);
            }
            return this.mDownloadingDialog;
        } else {
            throw new IllegalArgumentException("Invalid dialog id " + id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showInitializationError(int status, Runnable cancelCommand, Runnable downloadCommand) {
        AlertDialog dialog;
        ArrayList<ButtonAction> actions = new ArrayList<>();
        if (status == 2) {
            dialog = getAlertDialog(1);
            actions.add(new ButtonAction(-1, downloadCommand, true));
            actions.add(new ButtonAction(-2, cancelCommand, false));
        } else if (status == 3) {
            dialog = getAlertDialog(2);
            actions.add(new ButtonAction(-1, downloadCommand, true));
            actions.add(new ButtonAction(-2, cancelCommand, false));
        } else if (status == 4) {
            dialog = getAlertDialog(3);
            actions.add(new ButtonAction(-2, cancelCommand, true));
        } else if (status == 6) {
            dialog = getAlertDialog(4);
            actions.add(new ButtonAction(-1, downloadCommand, true));
            actions.add(new ButtonAction(-2, cancelCommand, false));
        } else if (status == 7) {
            dialog = getAlertDialog(5);
            actions.add(new ButtonAction(-2, cancelCommand, true));
        } else {
            throw new IllegalArgumentException("Invalid status " + status);
        }
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showDownloadError(Runnable cancelCommand, Runnable downloadCommand) {
        AlertDialog dialog = getAlertDialog(6);
        ArrayList<ButtonAction> actions = new ArrayList<>();
        actions.add(new ButtonAction(-1, downloadCommand, true));
        actions.add(new ButtonAction(-2, cancelCommand, false));
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showSelectStore(Runnable downloadCommand, String storeName) {
        AlertDialog dialog = getAlertDialog(7);
        String message = this.mContext.getString(R.string.select_store_message);
        setMessage(dialog, message.replace("STORE_NAME", storeName));
        ArrayList<ButtonAction> actions = new ArrayList<>();
        actions.add(new ButtonAction(-1, downloadCommand, true));
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showUnsupportedStore(Runnable cancelCommand) {
        AlertDialog dialog = getAlertDialog(8);
        ArrayList<ButtonAction> actions = new ArrayList<>();
        actions.add(new ButtonAction(-2, cancelCommand, true));
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showDecompressProgress(Runnable cancelCommand) {
        ProgressDialog dialog = getProgressDialog(11);
        ArrayList<ButtonAction> actions = new ArrayList<>();
        actions.add(new ButtonAction(-2, cancelCommand, false));
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showDownloadProgress(Runnable cancelCommand) {
        ProgressDialog dialog = getProgressDialog(12);
        ArrayList<ButtonAction> actions = new ArrayList<>();
        actions.add(new ButtonAction(-2, cancelCommand, false));
        showDialog(dialog, actions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dismissDialog() {
        this.mActiveDialog.dismiss();
        this.mActiveDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(int progress, int max) {
        ProgressDialog dialog = (ProgressDialog) this.mActiveDialog;
        dialog.setIndeterminate(false);
        dialog.setMax(max);
        dialog.setProgress(progress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowingDialog() {
        return this.mActiveDialog != null && this.mActiveDialog.isShowing();
    }

    private AlertDialog buildAlertDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this.mContext).create();
        dialog.setIcon(17301543);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    private ProgressDialog buildProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(this.mContext);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    private void setTitle(AlertDialog dialog, int resourceId) {
        dialog.setTitle(this.mContext.getString(resourceId));
    }

    private void setMessage(AlertDialog dialog, int resourceId) {
        setMessage(dialog, this.mContext.getString(resourceId));
    }

    private void setMessage(AlertDialog dialog, String text) {
        String text2 = text.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
        if (text2.startsWith("this")) {
            text2 = text2.replaceFirst("this", "This");
        }
        dialog.setMessage(text2);
    }

    private void setPositiveButton(AlertDialog dialog, int resourceId) {
        dialog.setButton(-1, this.mContext.getString(resourceId), (DialogInterface.OnClickListener) null);
    }

    private void setNegativeButton(AlertDialog dialog, int resourceId) {
        dialog.setButton(-2, this.mContext.getString(resourceId), (DialogInterface.OnClickListener) null);
    }

    private void showDialog(final AlertDialog dialog, final ArrayList<ButtonAction> actions) {
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.xwalk.core.XWalkDialogManager.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface d) {
                Iterator it = actions.iterator();
                while (it.hasNext()) {
                    ButtonAction action = (ButtonAction) it.next();
                    Button button = dialog.getButton(action.mWhich);
                    if (button == null) {
                        if (action.mMandatory) {
                            throw new RuntimeException("Button " + action.mWhich + " is mandatory");
                        }
                    } else if (action.mClickAction != null) {
                        final Runnable command = action.mClickAction;
                        button.setOnClickListener(new View.OnClickListener() { // from class: org.xwalk.core.XWalkDialogManager.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                XWalkDialogManager.this.dismissDialog();
                                command.run();
                            }
                        });
                    }
                }
            }
        });
        this.mActiveDialog = dialog;
        this.mActiveDialog.show();
    }
}
