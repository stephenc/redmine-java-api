package org.redmine.ta.internal.comm;

import org.apache.http.conn.ssl.X509HostnameVerifier;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.security.cert.X509Certificate;

/**
 * Apache's {@link org.apache.http.conn.ssl.SSLSocketFactory#ALLOW_ALL_HOSTNAME_VERIFIER} is still strict and can cause
 * blow-ups.
 */
class RealAllowAllHostnameVerifier implements X509HostnameVerifier {
    @Override
    public void verify(String host, SSLSocket ssl) throws IOException {
    }

    @Override
    public void verify(String host, X509Certificate cert) throws SSLException {
    }

    @Override
    public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
    }

    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
