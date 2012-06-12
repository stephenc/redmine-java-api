package org.redmine.ta.internal.comm;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

class FakeSSLSocketFactory extends SSLSocketFactory {
    private final javax.net.ssl.SSLSocketFactory delegate;

    public FakeSSLSocketFactory(KeyStore keystore)
            throws NoSuchAlgorithmException, KeyManagementException,
            KeyStoreException, UnrecoverableKeyException {
        super(keystore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
				// Check always succeed
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
				// Check always succeed
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        delegate = sslContext.getSocketFactory();
    }

    @Override
    public Socket createSocket(Socket socket, String host, int port,
                               boolean autoClose) throws IOException {
        return delegate.createSocket(socket, host, port,
                autoClose);
    }

    @Override
    public Socket createSocket() throws IOException {
        return delegate.createSocket();
    }

    @Override
    public Socket createSocket(HttpParams params) throws IOException {
        return delegate.createSocket();
    }

    @Override
    public Socket createLayeredSocket(Socket socket, String host, int port, boolean autoClose)
            throws IOException, UnknownHostException {
        return delegate.createSocket(socket, host, port, autoClose);
    }
}
