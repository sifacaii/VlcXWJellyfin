// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.util.Log;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.Principal;
import java.security.PrivateKey;
import java.util.List;

import org.chromium.base.ThreadUtils;

//TODO(iotto) : @XWalkAPI(impl = ClientCertRequestInternal.class, createInternally = true)
public class ClientCertRequestHandler implements ClientCertRequest {
    private static final String TAG = "ClientCertRequestHandler";
    private XWalkContentsClientBridge mContentsClient;
    private int mId;
    private String[] mKeyTypes = {};
    private Principal[] mPrincipals = {};
    private String mHost;
    private int mPort;
    private boolean mIsCalled;

    ClientCertRequestHandler(XWalkContentsClientBridge contentsClient, int id,
                             String[] keyTypes, Principal[] principals, String host, int port) {
        mId = id;
        mKeyTypes = keyTypes;
        mPrincipals = principals;
        mHost = host;
        mPort = port;
        mContentsClient = contentsClient;
    }

    // Never use this constructor.
    // It is only used in ClientCertRequestHandlerBridge.
    ClientCertRequestHandler() {
        mId = -1;
        mHost = "";
        mPort = -1;
        mContentsClient = null;
    }

    @Override
    public void proceed(final PrivateKey privateKey, final List<X509Certificate> chain) {
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                X509Certificate[] chains = null;
                if (chain != null) {
                    chains = chain.toArray(new X509Certificate[chain.size()]);
                }
                proceedOnUiThread(privateKey, chains);
            }
        });
    }

    @Override
    public void ignore() {
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ignoreOnUiThread();
            }
        });
    }

    @Override
    public void cancel() {
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cancelOnUiThread();
            }
        });
    }

    @Override
    public String getHost() {
        return mHost;
    }

    @Override
    public int getPort() {
        return mPort;
    }

    @Override
    public String[] getKeyTypes() {
        return mKeyTypes;
    }

    @Override
    public Principal[] getPrincipals() {
        return mPrincipals;
    }

    private void proceedOnUiThread(PrivateKey privateKey, X509Certificate[] chain) {
        checkIfCalled();

        if ((privateKey == null) || (chain == null) || (chain.length == 0)) {
            Log.w(TAG, "Empty client certificate chain?");
            provideResponse(null, null);

            return;
        }

        // Encode the certificate chain.
        byte[][] encodedChain = new byte[chain.length][];

        try {
            for (int i = 0; i < chain.length; ++i) {
                encodedChain[i] = chain[i].getEncoded();
            }
        } catch (CertificateEncodingException e) {
            Log.w(TAG, "Could not retrieve encoded certificate chain: " + e);
            provideResponse(null, null);

            return;
        }

        mContentsClient.mLookupTable.allow(mHost, mPort, privateKey, encodedChain);
        provideResponse(privateKey, encodedChain);
    }

    private void ignoreOnUiThread() {
        checkIfCalled();
        provideResponse(null, null);
    }

    private void cancelOnUiThread() {
        checkIfCalled();
        mContentsClient.mLookupTable.deny(mHost, mPort);
        provideResponse(null, null);
    }

    private void checkIfCalled() {
        if (mIsCalled) {
            throw new IllegalStateException("The callback was already called.");
        }

        mIsCalled = true;
    }

    private void provideResponse(PrivateKey privateKey, byte[][] certChain) {
        mContentsClient.provideClientCertificateResponse(mId, certChain, privateKey);
    }
}