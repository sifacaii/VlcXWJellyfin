package com.pakdata.xwalk.refactor;

import org.chromium.net.NetError;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/ErrorCodeConversionHelper.class */
class ErrorCodeConversionHelper {
    ErrorCodeConversionHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int convertErrorCode(int netError) {
        switch (netError) {
            case NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT /* -343 */:
            case NetError.ERR_MISSING_AUTH_CREDENTIALS /* -341 */:
            case NetError.ERR_INVALID_AUTH_CREDENTIALS /* -338 */:
                return -4;
            case NetError.ERR_UNSUPPORTED_AUTH_SCHEME /* -339 */:
                return -3;
            case NetError.ERR_NETWORK_IO_SUSPENDED /* -331 */:
            case -1:
                return -7;
            case NetError.ERR_UNEXPECTED_PROXY_AUTH /* -323 */:
            case NetError.ERR_PROXY_CONNECTION_FAILED /* -130 */:
            case NetError.ERR_PROXY_AUTH_REQUESTED /* -127 */:
            case NetError.ERR_PROXY_AUTH_UNSUPPORTED /* -115 */:
                return -5;
            case NetError.ERR_TOO_MANY_REDIRECTS /* -310 */:
                return -9;
            case NetError.ERR_UNKNOWN_URL_SCHEME /* -302 */:
            case NetError.ERR_DISALLOWED_URL_SCHEME /* -301 */:
                return -10;
            case NetError.ERR_INVALID_URL /* -300 */:
                return -12;
            case NetError.ERR_CERT_NON_UNIQUE_NAME /* -210 */:
            case NetError.ERR_CERT_WEAK_SIGNATURE_ALGORITHM /* -208 */:
            case NetError.ERR_CERT_INVALID /* -207 */:
            case NetError.ERR_CERT_REVOKED /* -206 */:
            case NetError.ERR_CERT_UNABLE_TO_CHECK_REVOCATION /* -205 */:
            case NetError.ERR_CERT_NO_REVOCATION_MECHANISM /* -204 */:
            case NetError.ERR_CERT_CONTAINS_ERRORS /* -203 */:
            case NetError.ERR_CERT_AUTHORITY_INVALID /* -202 */:
            case NetError.ERR_CERT_DATE_INVALID /* -201 */:
            case NetError.ERR_CERT_COMMON_NAME_INVALID /* -200 */:
                return 0;
            case NetError.ERR_NAME_RESOLUTION_FAILED /* -137 */:
            case NetError.ERR_ADDRESS_UNREACHABLE /* -109 */:
            case NetError.ERR_ADDRESS_INVALID /* -108 */:
            case NetError.ERR_INTERNET_DISCONNECTED /* -106 */:
            case NetError.ERR_NAME_NOT_RESOLVED /* -105 */:
                return -2;
            case NetError.ERR_SSL_CLIENT_AUTH_CERT_NO_PRIVATE_KEY /* -135 */:
            case NetError.ERR_SSL_CLIENT_AUTH_PRIVATE_KEY_ACCESS_DENIED /* -134 */:
            case NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY /* -129 */:
            case NetError.ERR_SSL_BAD_RECORD_MAC_ALERT /* -126 */:
            case NetError.ERR_SSL_DECOMPRESSION_FAILURE_ALERT /* -125 */:
            case NetError.ERR_SSL_NO_RENEGOTIATION /* -123 */:
            case NetError.ERR_BAD_SSL_CLIENT_AUTH_CERT /* -117 */:
            case NetError.ERR_CERT_ERROR_IN_SSL_RENEGOTIATION /* -116 */:
            case NetError.ERR_SSL_RENEGOTIATION_REQUESTED /* -114 */:
            case NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH /* -113 */:
            case NetError.ERR_NO_SSL_VERSIONS_ENABLED /* -112 */:
            case NetError.ERR_TUNNEL_CONNECTION_FAILED /* -111 */:
            case -110:
            case NetError.ERR_SSL_PROTOCOL_ERROR /* -107 */:
                return -11;
            case NetError.ERR_HOST_RESOLVER_QUEUE_TOO_LARGE /* -119 */:
            case -13:
            case -12:
                return -15;
            case NetError.ERR_CONNECTION_TIMED_OUT /* -118 */:
            case -7:
                return -8;
            case NetError.ERR_CONNECTION_FAILED /* -104 */:
            case NetError.ERR_CONNECTION_ABORTED /* -103 */:
            case NetError.ERR_CONNECTION_REFUSED /* -102 */:
            case NetError.ERR_CONNECTION_RESET /* -101 */:
            case NetError.ERR_CONNECTION_CLOSED /* -100 */:
            case -15:
                return -6;
            case -14:
                return -14;
            case -8:
                return -13;
            default:
                return -1;
        }
    }
}
