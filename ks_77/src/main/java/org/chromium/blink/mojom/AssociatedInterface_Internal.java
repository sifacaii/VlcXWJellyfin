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

class AssociatedInterface_Internal {
    public static final Interface.Manager<AssociatedInterface, AssociatedInterface.Proxy> MANAGER = new Interface.Manager<AssociatedInterface, AssociatedInterface.Proxy>() {
        public String getName() {
            return "blink.mojom.AssociatedInterface";
        }

        public int getVersion() {
            return 0;
        }

        public AssociatedInterface_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AssociatedInterface_Internal.Proxy(core, messageReceiver);
        }

        public AssociatedInterface_Internal.Stub buildStub(Core core, AssociatedInterface impl) {
            return new AssociatedInterface_Internal.Stub(core, impl);
        }

        public AssociatedInterface[] buildArray(int size) {
            return new AssociatedInterface[size];
        }
    };

    static final class Proxy extends Interface.AbstractProxy implements AssociatedInterface.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }
    }

    static final class Stub extends Interface.Stub<AssociatedInterface> {
        Stub(Core core, AssociatedInterface impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AssociatedInterface_Internal.MANAGER, messageWithHeader);
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
                                getCore(), AssociatedInterface_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }
}
