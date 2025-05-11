package org.chromium.device.nfc;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.TagTechnology;
import java.io.IOException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcTagHandler.class */
public class NfcTagHandler {
    private final int mCompatibility;
    private final TagTechnology mTech;
    private final TagTechnologyHandler mTechHandler;
    private boolean mWasConnected;
    private final String mSerialNumber;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcTagHandler$TagTechnologyHandler.class */
    private interface TagTechnologyHandler {
        void write(NdefMessage ndefMessage) throws IOException, TagLostException, FormatException, IllegalStateException;

        NdefMessage read() throws IOException, TagLostException, FormatException, IllegalStateException;
    }

    public static NfcTagHandler create(Tag tag) {
        if (tag == null) {
            return null;
        }
        Ndef ndef = Ndef.get(tag);
        if (ndef != null) {
            int compatibility = 1;
            String type = ndef.getType();
            if (type.equals("org.nfcforum.ndef.type1") || type.equals("org.nfcforum.ndef.type2") || type.equals("org.nfcforum.ndef.type3") || type.equals("org.nfcforum.ndef.type4")) {
                compatibility = 0;
            }
            return new NfcTagHandler(compatibility, ndef, new NdefHandler(ndef), tag.getId());
        }
        NdefFormatable formattable = NdefFormatable.get(tag);
        if (formattable != null) {
            return new NfcTagHandler(1, formattable, new NdefFormattableHandler(formattable), tag.getId());
        }
        return null;
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcTagHandler$NdefHandler.class */
    private static class NdefHandler implements TagTechnologyHandler {
        private final Ndef mNdef;

        NdefHandler(Ndef ndef) {
            this.mNdef = ndef;
        }

        @Override // org.chromium.device.nfc.NfcTagHandler.TagTechnologyHandler
        public void write(NdefMessage message) throws IOException, TagLostException, FormatException, IllegalStateException {
            this.mNdef.writeNdefMessage(message);
        }

        @Override // org.chromium.device.nfc.NfcTagHandler.TagTechnologyHandler
        public NdefMessage read() throws IOException, TagLostException, FormatException, IllegalStateException {
            return this.mNdef.getNdefMessage();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NfcTagHandler$NdefFormattableHandler.class */
    private static class NdefFormattableHandler implements TagTechnologyHandler {
        private final NdefFormatable mNdefFormattable;

        NdefFormattableHandler(NdefFormatable ndefFormattable) {
            this.mNdefFormattable = ndefFormattable;
        }

        @Override // org.chromium.device.nfc.NfcTagHandler.TagTechnologyHandler
        public void write(NdefMessage message) throws IOException, TagLostException, FormatException, IllegalStateException {
            this.mNdefFormattable.format(message);
        }

        @Override // org.chromium.device.nfc.NfcTagHandler.TagTechnologyHandler
        public NdefMessage read() throws FormatException {
            return NfcTypeConverter.emptyNdefMessage();
        }
    }

    protected NfcTagHandler(int compatibility, TagTechnology tech, TagTechnologyHandler handler, byte[] id) {
        this.mCompatibility = compatibility;
        this.mTech = tech;
        this.mTechHandler = handler;
        this.mSerialNumber = bytesToSerialNumber(id);
    }

    private static String bytesToSerialNumber(byte[] octets) {
        if (octets.length < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(octets.length * 3);
        for (byte b : octets) {
            if (sb.length() > 0) {
                sb.append(":");
            }
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    public String serialNumber() {
        return this.mSerialNumber;
    }

    public void connect() throws IOException, TagLostException {
        if (!this.mTech.isConnected()) {
            this.mTech.connect();
            this.mWasConnected = true;
        }
    }

    public boolean isConnected() {
        return this.mTech.isConnected();
    }

    public void close() throws IOException {
        this.mTech.close();
    }

    public void write(NdefMessage message) throws IOException, TagLostException, FormatException, IllegalStateException {
        this.mTechHandler.write(message);
    }

    public NdefMessage read() throws IOException, TagLostException, FormatException, IllegalStateException {
        return this.mTechHandler.read();
    }

    public boolean isTagOutOfRange() {
        try {
            connect();
            return false;
        } catch (IOException e) {
            return this.mWasConnected;
        }
    }

    public int compatibility() {
        return this.mCompatibility;
    }
}
