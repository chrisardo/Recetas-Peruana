package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appnext.ads.interstitial.Interstitial;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BannerView;
import com.appnext.base.Appnext;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class WebViewActivity extends AppCompatActivity {
    WebView wv1;
    String mActionBarTitle;
    TextView tvTi;
    private BannerView bannerwv_appnext;
    Interstitial interstitialwv_appnext;
    ImageButton btnatras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Appnext.init(this);
        // NOTE always use test ads during development and testing
        //StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);
        //StartAppSDK.init(this, "202504993", true);
        bannerwv_appnext = (BannerView) findViewById(R.id.banerop);
        interstitialwv_appnext = new Interstitial(this, "da374833-5714-400f-a5c4-311747d5b1f0");
        interstitialwv_appnext.loadAd();
        interstitialwv_appnext.setMute(true);
        interstitialwv_appnext.setBackButtonCanClose(true);

        BannerView banerwv = new BannerView(this);
        banerwv.setPlacementId("da374833-5714-400f-a5c4-311747d5b1f0");
        bannerwv_appnext.loadAd(new BannerAdRequest());
        banerwv.setBannerSize(BannerSize.BANNER);
        wv1=(WebView)findViewById(R.id.wv1);
        WebSettings webSettings =  wv1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        tvTi = (TextView)findViewById(R.id.nivel);
        Intent intent = getIntent();
        mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String URL = getIntent().getStringExtra("sitioWeb");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://" + URL);

        tvTi.setText(mActionBarTitle);

        btnatras = (ImageButton)findViewById(R.id.btnIcoAtras);
        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                interstitialwv_appnext.showAd();
                //StartAppAd.showAd(WebViewActivity.this);
            }
        });
    }
}