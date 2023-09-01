package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;*/
//import com.startapp.sdk.adsbase.StartAppSDK;

import com.appnext.ads.interstitial.Interstitial;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BannerView;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<MExampleItem> mExampleListM;
    private ArrayList<Model> listaModel;
    private RecyclerView mRecyclerView, mRView2;
    private MaAdapter mAdapter;
    private AdaptadorRecetas adaptadorRecetas;
    CardView Postres, Bebidas, Marisocs, Sopas, Fideos, Carnes;
    private BannerView bannermain_appnext;
    Interstitial interstitialmain_appnext;
    /*private AdView mAdView;
    private InterstitialAd mInterstitialAd;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // NOTE always use test ads during development and testing
        StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);
        StartAppSDK.init(this, "202200629", true);
        bannermain_appnext = (BannerView) findViewById(R.id.banerMain);
        interstitialmain_appnext = new Interstitial(this, "322134c4-c4c1-4865-9802-25eafe21a237");
        interstitialmain_appnext.loadAd();
        interstitialmain_appnext.setMute(true);
        interstitialmain_appnext.setBackButtonCanClose(true);
        BannerView banerwv = new BannerView(this);
        banerwv.setPlacementId("322134c4-c4c1-4865-9802-25eafe21a237");
        bannermain_appnext.loadAd(new BannerAdRequest());
        banerwv.setBannerSize(BannerSize.BANNER);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolboarI);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(lim);
        createExampleList();
        inicializaAdaptador();
        mRView2 = (RecyclerView)findViewById(R.id.rView2);
        LinearLayoutManager lirem = new LinearLayoutManager(this);
        lirem.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRView2.setLayoutManager(lirem);
        llenarRecetas();
        inicaadaptadorRecetas();
        
        Postres = (CardView) findViewById(R.id.postres);
        Bebidas = (CardView) findViewById(R.id.bebidas);
        Marisocs = (CardView) findViewById(R.id.mariscos);
        Sopas = (CardView)findViewById(R.id.sopa);
        Fideos = (CardView)findViewById(R.id.pastas);
        Carnes =(CardView)findViewById(R.id.carnes);
        Postres.setOnClickListener(this);
        Bebidas.setOnClickListener(this);
        Marisocs.setOnClickListener(this);
        Sopas.setOnClickListener(this);
        Fideos.setOnClickListener(this);
        Carnes.setOnClickListener(this);
        // TODO: Add adView to your view hierarchy.
        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8302868983775944/8621915224");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());*/
    }
    private void llenarRecetas() {
        listaModel=new ArrayList<>();
        listaModel.add(new Model("Avena con manzanas","4 personas", R.drawable.avenaconmanzana,"25m","Postres",R.string.avenamanza, R.string.avenamanzarece, R.drawable.ic_favorite));
        listaModel.add(new Model("Chupe de camarones peruano","6 personas", R.drawable.chupedecamaronesperu,"1h 30m","Pescados y Mariscos",R.string.chupecamarones, R.string.chupecamaronesrece, R.drawable.ic_favorite));
        listaModel.add(new Model("Chicha de jora","10 litros", R.drawable.chichajora,"11h","Tragos y refrescos",R.string.chichajora, R.string.chichajorarece, R.drawable.ic_favorite));
        listaModel.add(new Model("Lomo saltado peruano","4 personas", R.drawable.lomosaltado,"30m","Plato principal",R.string.lomosaltado, R.string.lomosaltadorece, R.drawable.ic_favorite));
        listaModel.add(new Model("Machu Picchu","1 copa", R.drawable.machupicchu,"10m","Tragos y refrescos",R.string.machupichu, R.string.machupichurece, R.drawable.ic_favorite));
        listaModel.add(new Model("Pachamanca","12 personas", R.drawable.pachamanca,"45m","Plato principal",R.string.pachamanca, R.string.pachamancarece, R.drawable.ic_favorite));
        listaModel.add(new Model("Pescado sudado","5 personas", R.drawable.pescadosudadope,"45m","Pescados y Mariscos",R.string.pescadosudado, R.string.pescadosudadorece, R.drawable.ic_favorite));
        listaModel.add(new Model("Sopa de patasca","4 personas", R.drawable.sopapatasca,"55m","Entrante",R.string.sopapatasca, R.string.sopapatascarece, R.drawable.ic_favorite));
    }
    private void inicaadaptadorRecetas() {
        adaptadorRecetas =new AdaptadorRecetas(listaModel);
        adaptadorRecetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetallesActivity.class);
                intent.putExtra("actionBarTitle", listaModel.get(mRView2.getChildAdapterPosition(v)).getTitle());
                intent.putExtra("contentTv", listaModel.get(mRView2.getChildAdapterPosition(v)).getDesc());
                intent.putExtra("actionBarImage", listaModel.get(mRView2.getChildAdapterPosition(v)).getIcon());
                intent.putExtra("tiempo", listaModel.get(mRView2.getChildAdapterPosition(v)).getTiempo());
                intent.putExtra("tipo", listaModel.get(mRView2.getChildAdapterPosition(v)).getTipo());
                intent.putExtra("ingrediente", listaModel.get(mRView2.getChildAdapterPosition(v)).getIngrediente());
                intent.putExtra("preparacio", listaModel.get(mRView2.getChildAdapterPosition(v)).getPreparacion());
                startActivity(intent);
            }
        });
        mRView2.setAdapter(adaptadorRecetas);
    }
    public void createExampleList(){
        mExampleListM = new ArrayList<>();
        mExampleListM.add(new MExampleItem(R.drawable.snacks, "Hay 10 recetas"));
        mExampleListM.add(new MExampleItem(R.drawable.pisco, "Hay 15 recetas"));
        mExampleListM.add(new MExampleItem(R.drawable.icocevi, "Hay 9 recetas"));
        mExampleListM.add(new MExampleItem(R.drawable.icoso, "Hay 15 recetas"));
        mExampleListM.add(new MExampleItem(R.drawable.sample_image_category, "Hay 16 recetas"));
        mExampleListM.add(new MExampleItem(R.drawable.lo, "Hay 10 recetas"));
    }
    private void inicializaAdaptador() {
        mAdapter = new MaAdapter(mExampleListM);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contenedor_instrucciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.compartir){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,"Conoce la gastronomía del Perú por medio de esta app de recetas, lo cúal puedes aprender a preparar comidas y bebidas peruana. Descarga AppRecetasPeruana desde la Play Store, es gratis: " + "https://play.google.com/store/apps/details?id=co.eduardo.apprecetasperuana");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, null));
        }else if (id == R.id.fvorito) {
            Intent im= new Intent(getApplicationContext(), FavoritoActivity.class);
            startActivity(im);
            interstitialmain_appnext.showAd();
            //StartAppAd.showAd(MainActivity.this);
        }else if (id == R.id.Acerca) {
            Intent im= new Intent(getApplicationContext(), AcercaDeActivity.class);
            startActivity(im);
            interstitialmain_appnext.showAd();
            //StartAppAd.showAd(MainActivity.this);
        }else if (id == R.id.instruction) {
            Intent im= new Intent(getApplicationContext(), OpcionesActivity.class);
            startActivity(im);
            interstitialmain_appnext.showAd();
        }else if (id == R.id.salir) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogSalida);
            builder.setMessage("¿Desea salir de AppRecetasPeruana?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.postres:
                /*if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }*/
                Intent ab = new Intent(MainActivity.this, PostresActivity.class);
                startActivity(ab);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                break;
            case R.id.bebidas:
                Intent ag = new Intent(MainActivity.this, BebidasyRefrescosActivity.class);
                startActivity(ag);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                finish();
                break;
            case R.id.mariscos:
                Intent ca = new Intent(MainActivity.this, MariscosActivity.class);
                startActivity(ca);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                finish();
                break;
            case R.id.sopa:
                Intent pro = new Intent(MainActivity.this, SopasActivity.class);
                startActivity(pro);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                finish();
                break;
            case R.id.pastas:
                Intent in = new Intent(MainActivity.this, PastasyFideosActivity.class);
                startActivity(in);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                finish();
                break;
            case R.id.carnes:
                Intent i2 = new Intent(MainActivity.this, CarnesActivity.class);
                startActivity(i2);
                //interstitialmain_appnext.showAd();
                StartAppAd.showAd(MainActivity.this);
                finish();
                break;

        }
    }
    /*se controla la pulsacion del boton atras*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogSalida);
            builder.setMessage("¿Desea salir de AppRectasPeruana?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}