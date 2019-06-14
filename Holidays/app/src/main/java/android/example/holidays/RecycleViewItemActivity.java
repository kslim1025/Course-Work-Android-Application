package android.example.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class RecycleViewItemActivity extends AppCompatActivity {

    private TextView name;
    private String namee;
    private TextView date;
    private String datee;
    private TextView desc;
    private String descr;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_item);

        name = findViewById(R.id.textView_recycleViewItem_1);
        date = findViewById(R.id.textView_recycleViewItem_2);
        desc = findViewById(R.id.textView_recycleViewItem_3);

        datee = getIntent().getStringExtra("date");
        namee= getIntent().getStringExtra("name");
        descr = getIntent().getStringExtra("descriptions");

        name.setText(namee);
        date.setText(datee);
        desc.setText(descr);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());

        webView.loadUrl("https://www.google.com/search?ei=d30CXfi1JY3prgT6xLrgCg&q=" + namee +  "&oq=tatyanaday&gs_l=psy-ab.3..0i7i30i19l4j0i7i10i30i19l3j0i7i30i19l2j0i7i10i30i19.5735.5735..6278...0.0..0.112.112.0j1......0....1..gws-wiz.......0i71.TrQBmvl_UyY");

    }

    private class MyWebViewClient extends WebViewClient {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        // Для старых устройств
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
