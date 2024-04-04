package org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/HttpNegotiateAuthenticator.class */
public class HttpNegotiateAuthenticator {
    private static final String TAG = "net_auth";
    private Bundle mSpnegoContext;
    private final String mAccountType;
    static final /* synthetic */ boolean $assertionsDisabled;

    @VisibleForTesting
    native void nativeSetResult(long j, int i, String str);

    static {
        $assertionsDisabled = !HttpNegotiateAuthenticator.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/HttpNegotiateAuthenticator$RequestData.class */
    public static class RequestData {
        public long nativeResultObject;
        public AccountManager accountManager;
        public Bundle options;
        public String authTokenType;
        public Account account;

        RequestData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/HttpNegotiateAuthenticator$GetAccountsCallback.class */
    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;

        public GetAccountsCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> future) {
            try {
                Account[] accounts = future.getResult();
                if (accounts.length == 0) {
                    Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                } else if (accounts.length > 1) {
                    Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", Integer.valueOf(accounts.length));
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                } else if (HttpNegotiateAuthenticator.this.lacksPermission(ContextUtils.getApplicationContext(), "android.permission.USE_CREDENTIALS", true)) {
                    Log.e(HttpNegotiateAuthenticator.TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
                    HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
                } else {
                    this.mRequestData.account = accounts[0];
                    this.mRequestData.accountManager.getAuthToken(this.mRequestData.account, this.mRequestData.authTokenType, this.mRequestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(this.mRequestData), new Handler(ThreadUtils.getUiThreadLooper()));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/HttpNegotiateAuthenticator$GetTokenCallback.class */
    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;

        public GetTokenCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> future) {
            try {
                Bundle result = future.getResult();
                if (!result.containsKey("intent")) {
                    HttpNegotiateAuthenticator.this.processResult(result, this.mRequestData);
                    return;
                }
                final Context appContext = ContextUtils.getApplicationContext();
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: org.chromium.net.HttpNegotiateAuthenticator.GetTokenCallback.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        appContext.unregisterReceiver(this);
                        GetTokenCallback.this.mRequestData.accountManager.getAuthToken(GetTokenCallback.this.mRequestData.account, GetTokenCallback.this.mRequestData.authTokenType, GetTokenCallback.this.mRequestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(GetTokenCallback.this.mRequestData), (Handler) null);
                    }
                };
                appContext.registerReceiver(broadcastReceiver, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", e);
                HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
            }
        }
    }

    protected HttpNegotiateAuthenticator(String accountType) {
        if (!$assertionsDisabled && TextUtils.isEmpty(accountType)) {
            throw new AssertionError();
        }
        this.mAccountType = accountType;
    }

    @VisibleForTesting
    @CalledByNative
    static HttpNegotiateAuthenticator create(String accountType) {
        return new HttpNegotiateAuthenticator(accountType);
    }

    @VisibleForTesting
    @CalledByNative
    void getNextAuthToken(long nativeResultObject, String principal, String authToken, boolean canDelegate) {
        if (!$assertionsDisabled && principal == null) {
            throw new AssertionError();
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        RequestData requestData = new RequestData();
        requestData.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + principal;
        requestData.accountManager = AccountManager.get(applicationContext);
        requestData.nativeResultObject = nativeResultObject;
        String[] features = {HttpNegotiateConstants.SPNEGO_FEATURE};
        requestData.options = new Bundle();
        if (authToken != null) {
            requestData.options.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, authToken);
        }
        if (this.mSpnegoContext != null) {
            requestData.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, this.mSpnegoContext);
        }
        requestData.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, canDelegate);
        Activity activity = ApplicationStatus.getLastTrackedFocusedActivity();
        if (activity == null) {
            requestTokenWithoutActivity(applicationContext, requestData, features);
        } else {
            requestTokenWithActivity(applicationContext, activity, requestData, features);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResult(Bundle result, RequestData requestData) {
        int status;
        this.mSpnegoContext = result.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        switch (result.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0:
                status = 0;
                break;
            case 1:
                status = -9;
                break;
            case 2:
                status = -3;
                break;
            case 3:
                status = -342;
                break;
            case 4:
                status = -320;
                break;
            case 5:
                status = -338;
                break;
            case 6:
                status = -339;
                break;
            case 7:
                status = -341;
                break;
            case 8:
                status = -344;
                break;
            case 9:
                status = -329;
                break;
            default:
                status = -9;
                break;
        }
        nativeSetResult(requestData.nativeResultObject, status, result.getString("authtoken"));
    }

    private void requestTokenWithoutActivity(Context ctx, RequestData requestData, String[] features) {
        if (lacksPermission(ctx, "android.permission.GET_ACCOUNTS", true)) {
            Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
            nativeSetResult(requestData.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        }
        requestData.accountManager.getAccountsByTypeAndFeatures(this.mAccountType, features, new GetAccountsCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    private void requestTokenWithActivity(Context ctx, Activity activity, RequestData requestData, String[] features) {
        String str;
        boolean isPreM = Build.VERSION.SDK_INT < 23;
        if (isPreM) {
            str = "android.permission.MANAGE_ACCOUNTS";
        } else {
            str = "android.permission.GET_ACCOUNTS";
        }
        String permission = str;
        if (lacksPermission(ctx, permission, isPreM)) {
            Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", permission);
            nativeSetResult(requestData.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        }
        requestData.accountManager.getAuthTokenByFeatures(this.mAccountType, requestData.authTokenType, features, activity, null, requestData.options, new GetTokenCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    @VisibleForTesting
    boolean lacksPermission(Context context, String permission, boolean onlyPreM) {
        if (!onlyPreM || Build.VERSION.SDK_INT < 23) {
            int permissionResult = context.checkPermission(permission, Process.myPid(), Process.myUid());
            return permissionResult != 0;
        }
        return false;
    }
}
