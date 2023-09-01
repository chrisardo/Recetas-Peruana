package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class DetallesActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingtoolbar;
    ImageView im;
    TextView tvperso, tvhora, tvTipo, tvingrediente, tvpreparacion;
    int mImage,mingrediente,mprepara ;
    String mActionBarTitle,mContent,mtiempo,mtipo;
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        // NOTE always use test ads during development and testing
        StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);
        StartAppSDK.init(this, "202504993", true);
        admin = new AdminSQLiteOpenHelper(getApplicationContext(), "administracion", null, 1);
        collapsingtoolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        im=(ImageView)findViewById(R.id.mealThumb);
        tvperso = (TextView)findViewById(R.id.personas);
        tvhora =(TextView)findViewById(R.id.hora);
        tvTipo = (TextView)findViewById(R.id.categoria);
        tvingrediente = (TextView)findViewById(R.id.ingredientes);
        tvpreparacion = (TextView)findViewById(R.id.preparacion);
        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        mImage = intent.getIntExtra("actionBarImage",0);
        mActionBarTitle = intent.getStringExtra("actionBarTitle");
        mContent = intent.getStringExtra("contentTv");
        mtiempo = intent.getStringExtra("tiempo");
        mtipo = intent.getStringExtra("tipo");
        mingrediente = intent.getIntExtra("ingrediente",0);
        mprepara = intent.getIntExtra("preparacio",0);
        collapsingtoolbar.setTitle(mActionBarTitle);
        im.setImageResource(mImage);
        tvperso.setText(mContent);
        tvhora.setText(mtiempo);
        tvTipo.setText(mtipo);
        tvingrediente.setText(mingrediente);
        tvpreparacion.setText(mprepara);
    }
    public void irWeb(View view){
        String titulo= collapsingtoolbar.getTitle().toString();
        //String ti= model.getTitle().toString();
        switch (titulo){
            // Snacks y piqueos
            case "Champiñones rellenos gratinados":
                Intent champi = new Intent(getApplicationContext(), WebViewActivity.class);
                champi.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                champi.putExtra("sitioWeb", "www.youtube.com/watch?v=2lOiVqo9hKc");
                startActivity(champi);
                break;
            case "Empanadas mixtas":
                Intent empamix = new Intent(getApplicationContext(), WebViewActivity.class);
                empamix.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                empamix.putExtra("sitioWeb", "www.youtube.com/watch?v=8KOR0vHub0s");
                startActivity(empamix);
                break;
            case "Humita":
                Intent humita = new Intent(getApplicationContext(), WebViewActivity.class);
                humita.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                humita.putExtra("sitioWeb", "https://www.youtube.com/watch?v=Ev5aitKaCds");
                startActivity(humita);
                break;
            case "Langostinos empanizados":
                Intent longosempa = new Intent(getApplicationContext(), WebViewActivity.class);
                longosempa.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                longosempa.putExtra("sitioWeb", "www.youtube.com/watch?v=coMofISTBgc");
                startActivity(longosempa);
                break;
            case "Papitas al romero con dip de yogur y cebolla":
                Intent papitasrome = new Intent(getApplicationContext(), WebViewActivity.class);
                papitasrome.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                papitasrome.putExtra("sitioWeb", "www.youtube.com/watch?v=YZZ-ReDFxeU");
                startActivity(papitasrome);
                break;
            case "Quesadillas de pollo":
                Intent quesapollo = new Intent(getApplicationContext(), WebViewActivity.class);
                quesapollo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                quesapollo.putExtra("sitioWeb", "www.youtube.com/watch?v=j2t5SiUljDs");
                startActivity(quesapollo);
                break;
            case "Sandwich de Pan Artesanal con Queso":
                Intent sandqueso = new Intent(getApplicationContext(), WebViewActivity.class);
                sandqueso.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sandqueso.putExtra("sitioWeb", "www.youtube.com/watch?v=R7F4hmFR4Nc");
                startActivity(sandqueso);
                break;
            case "Tequeños de sangrecita":
                Intent tequesan = new Intent(getApplicationContext(), WebViewActivity.class);
                tequesan.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                tequesan.putExtra("sitioWeb", "www.youtube.com/watch?v=MB9xNH2K4gc");
                startActivity(tequesan);
                break;
            case "Tortilla de Bacalao":
                Intent tortbaca = new Intent(getApplicationContext(), WebViewActivity.class);
                tortbaca.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                tortbaca.putExtra("sitioWeb", "https://www.youtube.com/watch?v=4nkFQKZ2b50");
                startActivity(tortbaca);
                break;
            case "Wantanes de pulpo al olivo":
                Intent wantapulpo = new Intent(getApplicationContext(), WebViewActivity.class);
                wantapulpo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                wantapulpo.putExtra("sitioWeb", "www.youtube.com/watch?v=XacKKritHXk");
                startActivity(wantapulpo);
                break;
                //bebidas y refrescos
            case "Aguajina":
                Intent aguajina = new Intent(getApplicationContext(), WebViewActivity.class);
                aguajina.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                aguajina.putExtra("sitioWeb", "www.youtube.com/watch?v=Hk4c7o01Ljo");
                startActivity(aguajina);
                break;
            case "Chicha de jora":
                Intent chichajora = new Intent(getApplicationContext(), WebViewActivity.class);
                chichajora.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chichajora.putExtra("sitioWeb", "www.youtube.com/watch?v=9Np1dvJE35s");
                startActivity(chichajora);
                break;
            case "Chilicano de Pisco":
                Intent chilipisco = new Intent(getApplicationContext(), WebViewActivity.class);
                chilipisco.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chilipisco.putExtra("sitioWeb", "www.youtube.com/watch?v=_3jIEpzgCKM");
                startActivity(chilipisco);
                break;
            case "Cóctel de algarrobina":
                Intent coctelalgarro = new Intent(getApplicationContext(), WebViewActivity.class);
                coctelalgarro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                coctelalgarro.putExtra("sitioWeb", "www.youtube.com/watch?v=pm8aHDMUf9k");
                startActivity(coctelalgarro);
                break;
            case "Emoliente peruano":
                Intent emoliperu = new Intent(getApplicationContext(), WebViewActivity.class);
                emoliperu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                emoliperu.putExtra("sitioWeb", "www.youtube.com/watch?v=wNUFfc5p7PA");
                startActivity(emoliperu);
                break;
            case "Limonada frozen":
                Intent limofro = new Intent(getApplicationContext(), WebViewActivity.class);
                limofro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                limofro.putExtra("sitioWeb", "www.youtube.com/watch?v=PJCybQhfHrE");
                startActivity(limofro);
                break;
            case "Machu Picchu":
                Intent machupi = new Intent(getApplicationContext(), WebViewActivity.class);
                machupi.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                machupi.putExtra("sitioWeb", "www.youtube.com/watch?v=Rdjk3G6Lark");
                startActivity(machupi);
                break;
            case "Maracuyá Sour":
                Intent maracusour = new Intent(getApplicationContext(), WebViewActivity.class);
                maracusour.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                maracusour.putExtra("sitioWeb", "www.youtube.com/watch?v=rMgYK92-HP8");
                startActivity(maracusour);
                break;
            case "Peruanisimo":
                Intent peruanisimo = new Intent(getApplicationContext(), WebViewActivity.class);
                peruanisimo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                peruanisimo.putExtra("sitioWeb", "www.youtube.com/watch?v=AwQ-BxBkbtE");
                startActivity(peruanisimo);
                break;
            case "Pisco Sour":
                Intent piscosour = new Intent(getApplicationContext(), WebViewActivity.class);
                piscosour.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                piscosour.putExtra("sitioWeb", "www.youtube.com/watch?v=gCjVyVyRmEM");
                startActivity(piscosour);
                break;
            case "Quinua carretillera":
                Intent quinuacarre = new Intent(getApplicationContext(), WebViewActivity.class);
                quinuacarre.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                quinuacarre.putExtra("sitioWeb", "www.youtube.com/watch?v=Umbf4GPBdR0");
                startActivity(quinuacarre);
                break;
            case "Refresco de cocona":
                Intent refrescoco = new Intent(getApplicationContext(), WebViewActivity.class);
                refrescoco.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                refrescoco.putExtra("sitioWeb", "www.youtube.com/watch?v=5jUU2NtfZrA");
                startActivity(refrescoco);
                break;
            case "Refresco de uvas":
                Intent refresuva = new Intent(getApplicationContext(), WebViewActivity.class);
                refresuva.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                refresuva.putExtra("sitioWeb", "www.youtube.com/watch?v=Qv5YKreL8s4");
                startActivity(refresuva);
                break;
            case "Sangría peruana":
                Intent sangriaperu = new Intent(getApplicationContext(), WebViewActivity.class);
                sangriaperu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sangriaperu.putExtra("sitioWeb", "www.youtube.com/watch?v=9hZgQ3zM1iQ");
                startActivity(sangriaperu);
                break;
            case "Chicha morada peruana":
                Intent chichamorapi = new Intent(getApplicationContext(), WebViewActivity.class);
                chichamorapi.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chichamorapi.putExtra("sitioWeb", "www.youtube.com/watch?v=neyo2-aR8QQ");
                startActivity(chichamorapi);
                break;
                //MARISCOS
            case "Ají de atún peruano":
                Intent ajiatun = new Intent(getApplicationContext(), WebViewActivity.class);
                ajiatun.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                ajiatun.putExtra("sitioWeb", "www.youtube.com/watch?v=CwNsp2bSJUA");
                startActivity(ajiatun);
                break;
            case "Ceviche de Conchitas":
                Intent cecon = new Intent(getApplicationContext(), WebViewActivity.class);
                cecon.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                cecon.putExtra("sitioWeb", "www.youtube.com/watch?v=kmp8yX37MT4");
                startActivity(cecon);
                break;
            case "Chupe de camarones peruano":
                Intent chupecamaro = new Intent(getApplicationContext(), WebViewActivity.class);
                chupecamaro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chupecamaro.putExtra("sitioWeb", "www.youtube.com/watch?v=9AVjlzvtgdA");
                startActivity(chupecamaro);
                break;
            case "Chicharrón de calamar":
                Intent chichacalamar = new Intent(getApplicationContext(), WebViewActivity.class);
                chichacalamar.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chichacalamar.putExtra("sitioWeb", "www.youtube.com/watch?v=0GF0xSWXM04");
                startActivity(chichacalamar);
                break;
            case "Chicharrón de pescado":
                Intent chichapesca = new Intent(getApplicationContext(), WebViewActivity.class);
                chichapesca.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chichapesca.putExtra("sitioWeb", "www.youtube.com/watch?v=9WUsGG_u5kY");
                startActivity(chichapesca);
                break;
            case "Majarisco norteño":
                Intent majarinorte = new Intent(getApplicationContext(), WebViewActivity.class);
                majarinorte.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                majarinorte.putExtra("sitioWeb", "www.youtube.com/watch?v=RY7MF4T2g3I");
                startActivity(majarinorte);
                break;
            case "Picante de mariscos":
                Intent picantemarisc = new Intent(getApplicationContext(), WebViewActivity.class);
                picantemarisc.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                picantemarisc.putExtra("sitioWeb", "www.youtube.com/watch?v=TBZQvaHYBcE");
                startActivity(picantemarisc);
                break;
            case "Pescado sudado":
                Intent pescasuda = new Intent(getApplicationContext(), WebViewActivity.class);
                pescasuda.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                pescasuda.putExtra("sitioWeb", "www.youtube.com/watch?v=beZ1haYE3UA");
                startActivity(pescasuda);
                break;
            case "Tiradito de lenguado":
                Intent tiralenguado = new Intent(getApplicationContext(), WebViewActivity.class);
                tiralenguado.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                tiralenguado.putExtra("sitioWeb", "https://www.youtube.com/watch?v=LE4fbujNPXg");
                startActivity(tiralenguado);
                break;
                //SOPAS
            case "Aguadito de pollo":
                Intent aguapollo = new Intent(getApplicationContext(), WebViewActivity.class);
                aguapollo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                aguapollo.putExtra("sitioWeb", "www.youtube.com/watch?v=EFo7ZEsnACI");
                startActivity(aguapollo);
                break;
            case "Chupe de mariscos":
                Intent chupemarisco = new Intent(getApplicationContext(), WebViewActivity.class);
                chupemarisco.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chupemarisco.putExtra("sitioWeb", "www.youtube.com/watch?v=LXfQTUlt4d0");
                startActivity(chupemarisco);
                break;
            case "Chupe de olluco":
                Intent chupeolluco = new Intent(getApplicationContext(), WebViewActivity.class);
                chupeolluco.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chupeolluco.putExtra("sitioWeb", "www.youtube.com/watch?v=D7Oyd98Ac-o");
                startActivity(chupeolluco);
                break;
            case "Caldo verde de Cajamarca":
                Intent calvercajama = new Intent(getApplicationContext(), WebViewActivity.class);
                calvercajama.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                calvercajama.putExtra("sitioWeb", "www.youtube.com/watch?v=dJnbpqB6fHY");
                startActivity(calvercajama);
                break;
            case "Caldo de Gallina":
                Intent caldogalli = new Intent(getApplicationContext(), WebViewActivity.class);
                caldogalli.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                caldogalli.putExtra("sitioWeb", "www.youtube.com/watch?v=21RU79TNA6o");
                startActivity(caldogalli);
                break;
            case "Chilcano de pescado":
                Intent chilcapes = new Intent(getApplicationContext(), WebViewActivity.class);
                chilcapes.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                chilcapes.putExtra("sitioWeb", "www.youtube.com/watch?v=beZ1haYE3UA");
                startActivity(chilcapes);
                break;
            case "Espesado de Costilla de Res":
                Intent especosti = new Intent(getApplicationContext(), WebViewActivity.class);
                especosti.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                especosti.putExtra("sitioWeb", "www.youtube.com/watch?v=WC56wG_Ftcg");
                startActivity(especosti);
                break;
            case "Espesado chiclayano":
                Intent espechi = new Intent(getApplicationContext(), WebViewActivity.class);
                espechi.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                espechi.putExtra("sitioWeb", "www.youtube.com/watch?v=AGYNg29nlP4");
                startActivity(espechi);
                break;
            case "Inchicapi de gallina":
                Intent inchigall = new Intent(getApplicationContext(), WebViewActivity.class);
                inchigall.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                inchigall.putExtra("sitioWeb", "www.youtube.com/watch?v=qsoXLw0dcdo");
                startActivity(inchigall);
                break;
            case "Menestrón peruano":
                Intent menesperu = new Intent(getApplicationContext(), WebViewActivity.class);
                menesperu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                menesperu.putExtra("sitioWeb", "www.youtube.com/watch?v=M-_8c8DuCe4");
                startActivity(menesperu);
                break;
            case "Sopa criolla":
                Intent sopacrio = new Intent(getApplicationContext(), WebViewActivity.class);
                sopacrio.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sopacrio.putExtra("sitioWeb", "www.youtube.com/watch?v=FdFm3AsA2D8");
                startActivity(sopacrio);
                break;
            case "Sopa Shámbar":
                Intent sopasham = new Intent(getApplicationContext(), WebViewActivity.class);
                sopasham.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sopasham.putExtra("sitioWeb", "www.youtube.com/watch?v=t4ryb9ZtD98");
                startActivity(sopasham);
                break;
            case "Sopa a la minuta":
                Intent spaminu = new Intent(getApplicationContext(), WebViewActivity.class);
                spaminu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                spaminu.putExtra("sitioWeb", "www.youtube.com/watch?v=Qc_u5wx6ZuM");
                startActivity(spaminu);
                break;
            case "Sopa de patasca":
                Intent sopapatas = new Intent(getApplicationContext(), WebViewActivity.class);
                sopapatas.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sopapatas.putExtra("sitioWeb", "www.youtube.com/watch?v=e1_pgwd7JeI");
                startActivity(sopapatas);
                break;
            case "Sopa de choros":
                Intent sopachro = new Intent(getApplicationContext(), WebViewActivity.class);
                sopachro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sopachro.putExtra("sitioWeb", "www.youtube.com/watch?v=mRdDi-qM8rM");
                startActivity(sopachro);
                break;
                //POSTRES
            case "Avena con manzanas":
                Intent avemanza = new Intent(getApplicationContext(), WebViewActivity.class);
                avemanza.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                avemanza.putExtra("sitioWeb", "www.youtube.com/watch?v=Gwcsg7MEePg");
                startActivity(avemanza);
                break;
            case "Bola de oro de alfajor":
                Intent bolor = new Intent(getApplicationContext(), WebViewActivity.class);
                bolor.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                bolor.putExtra("sitioWeb", "www.youtube.com/watch?v=NIzAGkiCkZU");
                startActivity(bolor);
                break;
            case "Crema volteada peruana":
                Intent cremvolte = new Intent(getApplicationContext(), WebViewActivity.class);
                cremvolte.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                cremvolte.putExtra("sitioWeb", "www.youtube.com/watch?v=UelGbXwWOMw");
                startActivity(cremvolte);
                break;
            case "Crema de lúcuma":
                Intent cremlucu = new Intent(getApplicationContext(), WebViewActivity.class);
                cremlucu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                cremlucu.putExtra("sitioWeb", "www.youtube.com/watch?v=X2VY1hzSXE4");
                startActivity(cremlucu);
                break;
            case "Leche asada al baño María":
                Intent lecheasaalba = new Intent(getApplicationContext(), WebViewActivity.class);
                lecheasaalba.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                lecheasaalba.putExtra("sitioWeb", "www.youtube.com/watch?v=BKt00f2_Yj4");
                startActivity(lecheasaalba);
                break;
            case "Leche asada peruana":
                Intent lecheasa = new Intent(getApplicationContext(), WebViewActivity.class);
                lecheasa.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                lecheasa.putExtra("sitioWeb", "www.youtube.com/watch?v=9VtucH4NiHM");
                startActivity(lecheasa);
                break;
            case "leche asada en microondas":
                Intent lecasamicro = new Intent(getApplicationContext(), WebViewActivity.class);
                lecasamicro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                lecasamicro.putExtra("sitioWeb", "www.youtube.com/watch?v=hCwajYM7eV4");
                startActivity(lecasamicro);
                break;
            case "Mazamorra morada":
                Intent mazamora = new Intent(getApplicationContext(), WebViewActivity.class);
                mazamora.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                mazamora.putExtra("sitioWeb", "www.youtube.com/watch?v=G-fF-xxcv3U");
                startActivity(mazamora);
                break;
            case "Mazamorra de chancaca":
                Intent mazachanca = new Intent(getApplicationContext(), WebViewActivity.class);
                mazachanca.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                mazachanca.putExtra("sitioWeb", "www.youtube.com/watch?v=A0CSvjAxgvM");
                startActivity(mazachanca);
                break;
            case "Pie de limón peruano":
                Intent pilim = new Intent(getApplicationContext(), WebViewActivity.class);
                pilim.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                pilim.putExtra("sitioWeb", "www.youtube.com/watch?v=XaW1jGgzmEQ");
                startActivity(pilim);
                break;
            case "Pastel helado peruano":
                Intent pashela = new Intent(getApplicationContext(), WebViewActivity.class);
                pashela.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                pashela.putExtra("sitioWeb", "www.youtube.com/watch?v=CjdkXi-47Cg");
                startActivity(pashela);
                break;
            case "Queso helado arequipeño":
                Intent quehela = new Intent(getApplicationContext(), WebViewActivity.class);
                quehela.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                quehela.putExtra("sitioWeb", "www.youtube.com/watch?v=s18QPjhEP3I");
                startActivity(quehela);
                break;
            case "Queque de plátano":
                Intent queplata = new Intent(getApplicationContext(), WebViewActivity.class);
                queplata.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                queplata.putExtra("sitioWeb", "www.youtube.com/watch?v=x64x2BD0o14");
                startActivity(queplata);
                break;
            case "Rollo de aguaymanto":
                Intent rolloagu = new Intent(getApplicationContext(), WebViewActivity.class);
                rolloagu.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                rolloagu.putExtra("sitioWeb", "www.youtube.com/watch?v=58rbJ2uv7ik");
                startActivity(rolloagu);
                break;
            case "Smothie de leche de almendras":
                Intent smotleche = new Intent(getApplicationContext(), WebViewActivity.class);
                smotleche.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                smotleche.putExtra("sitioWeb", "www.youtube.com/watch?v=CrBv1qGJsAM");
                startActivity(smotleche);
                break;
            case "Soufflé de coliflor y queso parmesano":
                Intent socoli = new Intent(getApplicationContext(), WebViewActivity.class);
                socoli.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                socoli.putExtra("sitioWeb", "www.youtube.com/watch?v=Is_1iQxVJ_0");
                startActivity(socoli);
                break;
                //CARNES
            case "Albóndigas de carne peruanas":
                Intent albocarne = new Intent(getApplicationContext(), WebViewActivity.class);
                albocarne.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                albocarne.putExtra("sitioWeb", "www.youtube.com/watch?v=KQcoNZC2Tk8");
                startActivity(albocarne);
                break;
            case "Carne al sillao peruano":
                Intent carsi = new Intent(getApplicationContext(), WebViewActivity.class);
                carsi.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                carsi.putExtra("sitioWeb", "www.youtube.com/watch?v=wKk_UNR0rik");
                startActivity(carsi);
                break;
            case "Carapulcra de cerdo":
                Intent carcerd = new Intent(getApplicationContext(), WebViewActivity.class);
                carcerd.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                carcerd.putExtra("sitioWeb", "www.youtube.com/watch?v=oQ36K98GLRs");
                startActivity(carcerd);
                break;
            case "Escabeche de pollo peruano":
                Intent escapollo = new Intent(getApplicationContext(), WebViewActivity.class);
                escapollo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                escapollo.putExtra("sitioWeb", "www.youtube.com/watch?v=nclJw77czjw");
                startActivity(escapollo);
                break;
            case "Lomo saltado peruano":
                Intent lomsalta = new Intent(getApplicationContext(), WebViewActivity.class);
                lomsalta.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                lomsalta.putExtra("sitioWeb", "www.youtube.com/watch?v=Otzcqpw7euo");
                startActivity(lomsalta);
                break;
            case "Lomo negro sencillo":
                Intent lonegro = new Intent(getApplicationContext(), WebViewActivity.class);
                lonegro.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                lonegro.putExtra("sitioWeb", "www.youtube.com/watch?v=ZvIxp0qbZpE");
                startActivity(lonegro);
                break;
            case "Pachamanca":
                Intent pacham = new Intent(getApplicationContext(), WebViewActivity.class);
                pacham.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                pacham.putExtra("sitioWeb", "www.youtube.com/watch?v=u9AMJGOF26g");
                startActivity(pacham);
                break;
            case "Pollo al horno peruano":
                Intent pohor = new Intent(getApplicationContext(), WebViewActivity.class);
                pohor.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                pohor.putExtra("sitioWeb", "www.youtube.com/watch?v=nq6z4n-YZas");
                startActivity(pohor);
                break;
            case "Salteado de pollo con holantao":
                Intent salpo = new Intent(getApplicationContext(), WebViewActivity.class);
                salpo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                salpo.putExtra("sitioWeb", "www.youtube.com/watch?v=-utzjI5dsTI");
                startActivity(salpo);
                break;
            case "Sangrecita de pollo":
                Intent sanpo = new Intent(getApplicationContext(), WebViewActivity.class);
                sanpo.putExtra("actionBarTitle", collapsingtoolbar.getTitle().toString());
                sanpo.putExtra("sitioWeb", "www.youtube.com/watch?v=XIbUO6VmImE");
                startActivity(sanpo);
                break;
            default: Toast.makeText(getApplicationContext(), "No hay video la receta" + titulo, Toast.LENGTH_SHORT).show(); break;
        }
    }
    //public void compartir(View view){
        /*ArrayList<String> texto = new ArrayList<String>();
        texto.add(tvingrediente.getText().toString());
        texto.add(tvpreparacion.getText().toString());*/
    //now for sharing file i need to create file provider for android version greater than noughat let's do it
    //Intent intent=new Intent(Intent.ACTION_SEND);
    //intent.putExtra(Intent.EXTRA_TEXT,collapsingtoolbar.getTitle().toString());
        /*intent.putExtra(Intent.EXTRA_TEXT,tvingrediente.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,tvpreparacion.getText().toString());*/
    //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    //intent.setType("text/plain");
    //startActivity(Intent.createChooser(intent, null));
    //Everything WOrking
    //}
    public void atras(View view){
        finish();
        StartAppAd.showAd(DetallesActivity.this);
    }
}