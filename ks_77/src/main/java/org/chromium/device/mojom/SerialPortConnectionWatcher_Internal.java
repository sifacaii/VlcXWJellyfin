package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

class SerialPortConnectionWatcher_Internal {
    public static final Interface.Manager<SerialPortConnectionWatcher, SerialPortConnectionWatcher.Proxy> MANAGER = new Interface.Manager<SerialPortConnectionWatcher, SerialPortConnectionWatcher.Proxy>() {
        public String getName() {
            return "device.mojom.SerialPortConnectionWatcher";
        }

        public int getVersion() {
            return 0;
        }

        public SerialPortConnectionWatcher_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SerialPortConnectionWatcher_Internal.Proxy(core, messageReceiver);
        }

        public SerialPortConnectionWatcher_Internal.Stub buildStub(Core core, SerialPortConnectionWatcher impl) {
            return new SerialPortConnectionWatcher_Internal.Stub(core, impl);
        }

        public SerialPortConnectionWatcher[] buildArray(int size) {
            return new SerialPortConnectionWatcher[size];
        }
    };

    static final class Proxy extends Interface.AbstractProxy implements SerialPortConnectionWatcher.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }
    }

    static final class Stub extends Interface.Stub<SerialPortConnectionWatcher> {
        Stub(Core core, SerialPortConnectionWatcher impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SerialPortConnectionWatcher_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), SerialPortConnectionWatcher_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }
}
