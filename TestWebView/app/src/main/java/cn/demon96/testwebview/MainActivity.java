package cn.demon96.testwebview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadUrl("file:///android_asset/AndoidAnd.html");
        webView.addJavascriptInterface(this,"android");

    }

    @JavascriptInterface
    public void goToLogin() {
        Toast.makeText(this, "showWebContentActivity类中的goToLogin方法被调用", Toast.LENGTH_LONG).show();
    }
}
