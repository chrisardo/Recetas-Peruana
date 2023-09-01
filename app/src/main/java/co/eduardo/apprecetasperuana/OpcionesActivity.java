package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        // NOTE always use test ads during development and testing
        StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);
        StartAppSDK.init(this, "202504993", true);
    }
    public void instrucciones(View view){
        Intent im= new Intent(getApplicationContext(), ContenedorInstruccionesActivity.class);
        startActivity(im);
    }
    public void dejaropinion(View view){
        Intent im= new Intent(getApplicationContext(), WebViewActivity.class);
        im.putExtra("actionBarTitle","AppRecetasPeruana");
        im.putExtra("sitioWeb", "play.google.com/store/apps/details?id=co.eduardo.apprecetasperuana");
        startActivity(im);
    }
    public void irAtras(View view){
        Intent im= new Intent(getApplicationContext(), MainActivity.class);
        startActivity(im);
        StartAppAd.showAd(OpcionesActivity.this);
    }
}