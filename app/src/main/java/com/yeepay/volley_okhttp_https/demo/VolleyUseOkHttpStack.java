package com.yeepay.volley_okhttp_https.demo;

import com.squareup.okhttp.OkHttpClient;
import com.yeepay.utils.http.toolbox.HTTPSTrustManager;
import com.yeepay.utils.http.toolbox.HurlStack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @user: zt
 * @describe:
 */

public class VolleyUseOkHttpStack extends HurlStack {
    private OkHttpClient okHttpClient;
    /**
     * Create a OkHttpStack with default OkHttpClient.
     */
    public VolleyUseOkHttpStack() {
        this(new OkHttpClient());
    }

    /**
     * Create a OkHttpStack with a custom OkHttpClient
     * @param okHttpClient Custom OkHttpClient, NonNull
     */
    public VolleyUseOkHttpStack(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    protected HttpURLConnection createConnection(URL url) throws IOException {
        if(url.toString().contains("https")) {
            HTTPSTrustManager.allowAllSSL();
        }
        return (HttpURLConnection)url.openConnection();
    }
}
