package org.chromium.content.app;

/**
 * Sandboxed Services inherit from this class. We enforce the privileged/sandboxed
 * distinction by type-checking objects against this parent class.
 */
public class SandboxedProcessService extends ContentChildProcessService{
}
