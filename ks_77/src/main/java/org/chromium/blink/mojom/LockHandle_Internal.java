package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

class LockHandle_Internal {
    public static final Interface.Manager<LockHandle, LockHandle.Proxy> MANAGER = new Interface.Manager<LockHandle, LockHandle.Proxy>() {
        public String getName() {
            return "blink.mojom.LockHandle";
        }

        public int getVersion() {
            return 0;
        }

        public LockHandle_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new LockHandle_Internal.Proxy(core, messageReceiver);
        }

        public LockHandle_Internal.Stub buildStub(Core core, LockHandle impl) {
            return new LockHandle_Internal.Stub(core, impl);
        }

        public LockHandle[] buildArray(int size) {
            return new LockHandle[size];
        }
    };

    static final class Proxy extends Interface.AbstractProxy implements LockHandle.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }
    }

    static final class Stub extends Interface.Stub<LockHandle> {
        Stub(Core core, LockHandle impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(LockHandle_Internal.MANAGER, messageWithHeader);
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
                                getCore(), LockHandle_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }
}
