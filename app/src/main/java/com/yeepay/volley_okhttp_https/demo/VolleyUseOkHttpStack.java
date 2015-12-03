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
    public VolleyUseOkHttpStack() {
        this(new OkHttpClient());
    }

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
