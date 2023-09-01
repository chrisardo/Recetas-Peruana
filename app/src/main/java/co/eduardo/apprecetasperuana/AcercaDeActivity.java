package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;*/
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BannerView;
import com.appnext.base.Appnext;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class AcercaDeActivity extends AppCompatActivity {
    FloatingActionButton btnInicio;
    //private AdView mAdViewa;
    Interstitial interstitialop_appnext;
    private BannerView bannerace_appnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        Appnext.init(this);
        // NOTE always use test ads during development and testing
        StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);
        StartAppSDK.init(this, "202200629", true);

        interstitialop_appnext = new Interstitial(this, "322134c4-c4c1-4865-9802-25eafe21a237");
        interstitialop_appnext.loadAd();
        interstitialop_appnext.setMute(true);
        interstitialop_appnext.setBackButtonCanClose(true);
        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdViewa = findViewById(R.id.adViewac);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdViewa.loadAd(adRequest);*/
        bannerace_appnext = (BannerView) findViewById(R.id.baneracerca);
        BannerView banerwv = new BannerView(this);
        banerwv.setPlacementId("da374833-5714-400f-a5c4-311747d5b1f0");
        bannerace_appnext.loadAd(new BannerAdRequest());
        banerwv.setBannerSize(BannerSize.BANNER);
        btnInicio=findViewById(R.id.btnHome);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irinicio = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(irinicio);
                finish();
                interstitialop_appnext.showAd();
                //StartAppAd.showAd(AcercaDeActivity.this);

            }
        });
    }
}