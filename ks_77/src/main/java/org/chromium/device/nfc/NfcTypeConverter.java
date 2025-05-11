package org.chromium.device.nfc;

import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Build;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Log;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcTypeConverter.class */
public final class NfcTypeConverter {
    private static final String TAG = "NfcTypeConverter";
    private static final String DOMAIN = "w3.org";
    private static final String TYPE = "webnfc";
    private static final String WEBNFC_URN = "w3.org:webnfc";
    private static final String TEXT_MIME = "text/plain";
    private static final String JSON_MIME = "application/json";
    private static final String CHARSET_UTF8 = ";charset=UTF-8";
    private static final String CHARSET_UTF16 = ";charset=UTF-16";

    public static NdefMessage toNdefMessage(org.chromium.device.mojom.NdefMessage message) throws InvalidNdefMessageException {
        try {
            List<NdefRecord> records = new ArrayList<>();
            for (int i = 0; i < message.data.length; i++) {
                records.add(toNdefRecord(message.data[i]));
            }
            records.add(NdefRecord.createExternal(DOMAIN, TYPE, ApiCompatibilityUtils.getBytesUtf8(message.url)));
            NdefRecord[] ndefRecords = new NdefRecord[records.size()];
            records.toArray(ndefRecords);
            return new NdefMessage(ndefRecords);
        } catch (UnsupportedEncodingException | IllegalArgumentException | InvalidNdefMessageException e) {
            throw new InvalidNdefMessageException();
        }
    }

    public static org.chromium.device.mojom.NdefMessage toNdefMessage(NdefMessage ndefMessage) throws UnsupportedEncodingException {
        NdefRecord[] ndefRecords = ndefMessage.getRecords();
        org.chromium.device.mojom.NdefMessage webNdefMessage = new org.chromium.device.mojom.NdefMessage();
        List<org.chromium.device.mojom.NdefRecord> nfcRecords = new ArrayList<>();
        for (int i = 0; i < ndefRecords.length; i++) {
            if (ndefRecords[i].getTnf() == 4 && Arrays.equals(ndefRecords[i].getType(), ApiCompatibilityUtils.getBytesUtf8(WEBNFC_URN))) {
                webNdefMessage.url = new String(ndefRecords[i].getPayload(), "UTF-8");
            } else {
                org.chromium.device.mojom.NdefRecord nfcRecord = toNdefRecord(ndefRecords[i]);
                if (nfcRecord != null) {
                    nfcRecords.add(nfcRecord);
                }
            }
        }
        webNdefMessage.data = new org.chromium.device.mojom.NdefRecord[nfcRecords.size()];
        nfcRecords.toArray(webNdefMessage.data);
        return webNdefMessage;
    }

    private static String getCharset(org.chromium.device.mojom.NdefRecord record) {
        if (record.mediaType.endsWith(CHARSET_UTF8)) {
            return "UTF-8";
        }
        if (record.mediaType.endsWith(CHARSET_UTF16)) {
            return "UTF-16LE";
        }
        Log.w(TAG, "Unknown charset, defaulting to UTF-8.", new Object[0]);
        return "UTF-8";
    }

    private static NdefRecord toNdefRecord(org.chromium.device.mojom.NdefRecord record) throws InvalidNdefMessageException, IllegalArgumentException, UnsupportedEncodingException {
        switch (record.recordType) {
            case 0:
                return new NdefRecord((short) 0, null, null, null);
            case 1:
                if (Build.VERSION.SDK_INT >= 21) {
                    return NdefRecord.createTextRecord("en-US", new String(record.data, getCharset(record)));
                }
                return NdefRecord.createMime(TEXT_MIME, record.data);
            case 2:
                return NdefRecord.createUri(new String(record.data, getCharset(record)));
            case 3:
            case 4:
                return NdefRecord.createMime(record.mediaType, record.data);
            default:
                throw new InvalidNdefMessageException();
        }
    }

    private static org.chromium.device.mojom.NdefRecord toNdefRecord(NdefRecord ndefRecord) throws UnsupportedEncodingException {
        switch (ndefRecord.getTnf()) {
            case 0:
                return createEmptyRecord();
            case 1:
                return createWellKnownRecord(ndefRecord);
            case 2:
                return createMIMERecord(new String(ndefRecord.getType(), "UTF-8"), ndefRecord.getPayload());
            case 3:
                return createURLRecord(ndefRecord.toUri());
            default:
                return null;
        }
    }

    public static NdefMessage emptyNdefMessage() {
        return new NdefMessage(new NdefRecord((short) 0, null, null, null), new NdefRecord[0]);
    }

    private static org.chromium.device.mojom.NdefRecord createEmptyRecord() {
        org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
        nfcRecord.recordType = 0;
        nfcRecord.mediaType = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        nfcRecord.data = new byte[0];
        return nfcRecord;
    }

    private static org.chromium.device.mojom.NdefRecord createURLRecord(Uri uri) {
        if (uri == null) {
            return null;
        }
        org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
        nfcRecord.recordType = 2;
        nfcRecord.mediaType = TEXT_MIME;
        nfcRecord.data = ApiCompatibilityUtils.getBytesUtf8(uri.toString());
        return nfcRecord;
    }

    private static org.chromium.device.mojom.NdefRecord createMIMERecord(String mediaType, byte[] payload) {
        org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
        if (mediaType.equals(JSON_MIME)) {
            nfcRecord.recordType = 3;
        } else {
            nfcRecord.recordType = 4;
        }
        nfcRecord.mediaType = mediaType;
        nfcRecord.data = payload;
        return nfcRecord;
    }

    private static org.chromium.device.mojom.NdefRecord createTextRecord(byte[] text) {
        if (text.length == 0) {
            return null;
        }
        org.chromium.device.mojom.NdefRecord nfcRecord = new org.chromium.device.mojom.NdefRecord();
        nfcRecord.recordType = 1;
        nfcRecord.mediaType = TEXT_MIME;
        int langCodeLength = text[0] & 63;
        int textBodyStartPos = langCodeLength + 1;
        if (textBodyStartPos > text.length) {
            return null;
        }
        nfcRecord.data = Arrays.copyOfRange(text, textBodyStartPos, text.length);
        return nfcRecord;
    }

    private static org.chromium.device.mojom.NdefRecord createWellKnownRecord(NdefRecord record) {
        if (Arrays.equals(record.getType(), NdefRecord.RTD_URI)) {
            return createURLRecord(record.toUri());
        }
        if (Arrays.equals(record.getType(), NdefRecord.RTD_TEXT)) {
            return createTextRecord(record.getPayload());
        }
        return null;
    }
}
