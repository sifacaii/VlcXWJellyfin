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

class PauseSubresourceLoadingHandle_Internal {
    public static final Interface.Manager<PauseSubresourceLoadingHandle, PauseSubresourceLoadingHandle.Proxy> MANAGER = new Interface.Manager<PauseSubresourceLoadingHandle, PauseSubresourceLoadingHandle.Proxy>() {
        public String getName() {
            return "blink.mojom.PauseSubresourceLoadingHandle";
        }

        public int getVersion() {
            return 0;
        }

        public PauseSubresourceLoadingHandle_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PauseSubresourceLoadingHandle_Internal.Proxy(core, messageReceiver);
        }

        public PauseSubresourceLoadingHandle_Internal.Stub buildStub(Core core, PauseSubresourceLoadingHandle impl) {
            return new PauseSubresourceLoadingHandle_Internal.Stub(core, impl);
        }

        public PauseSubresourceLoadingHandle[] buildArray(int size) {
            return new PauseSubresourceLoadingHandle[size];
        }
    };

    static final class Proxy extends Interface.AbstractProxy implements PauseSubresourceLoadingHandle.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }
    }

    static final class Stub extends Interface.Stub<PauseSubresourceLoadingHandle> {
        Stub(Core core, PauseSubresourceLoadingHandle impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PauseSubresourceLoadingHandle_Internal.MANAGER, messageWithHeader);
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
                                getCore(), PauseSubresourceLoadingHandle_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }
}
