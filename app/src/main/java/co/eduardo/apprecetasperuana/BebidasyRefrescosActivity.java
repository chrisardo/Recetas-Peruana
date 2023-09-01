package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class BebidasyRefrescosActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidasy_refrescos);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");
        title = new String[]{"Aguajina", "Chicha morada peruana", "Chicha de jora", "Chilicano de Pisco", "Cóctel de algarrobina","Emoliente peruano","Limonada frozen","Machu Picchu","Maracuyá Sour","Peruanisimo","Pisco Sour","Quinua carretillera","Refresco de cocona","Refresco de uvas","Sangría peruana"};
        description = new String[]{"5 personas", "8 personas", "10 litros", "1 persona", "2 persona","14 vasos","2 personas","1 copa","1 copa","1 copa","2 personas","4 personas","4 personas","1 persona","6 personas"};
        icon = new int[]{R.drawable.aguajina, R.drawable.chichamorada, R.drawable.chichajora, R.drawable.chilcanopisco, R.drawable.coctelalgarrobina,R.drawable.emolienteperuano,R.drawable.limonadafrozen, R.drawable.machupicchu,R.drawable.maracuyasour,R.drawable.peruanisimo,R.drawable.piscosour,R.drawable.quinuacarretillera,R.drawable.cocona,R.drawable.uva,R.drawable.sangriaperua,};
        tiempo= new String[]{"20m", "30m", "11h", "2m", "15m","35m","15 m","10m","5m y 15s","5m","30m","45m","60m","20m","15m"};
        tipo = new String[]{"Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos","Tragos y refrescos","Tragos y refrescos","Tragos y refrescos","Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos", "Tragos y refrescos"};
        ingrediente= new int[]{R.string.aguajina,R.string.chicamorada,R.string.chichajora, R.string.chilipisco,R.string.coctelalgarrobina,R.string.emolienteper,R.string.limonadafrozen,R.string.machupichu,R.string.maracuyasour,R.string.peruanisimo,R.string.piscosour,R.string.quinuacarretillera, R.string.refrecocona,R.string.reuva,R.string.sangriaperu};
        preparacio= new int[]{R.string.aguajinarece,R.string.chichamoradarece,R.string.chichajorarece,R.string.chilipiscorece,R.string.coctelalgarrobinarece,R.string.emolienteperece,R.string.limonfrozenrece,R.string.machupichurece,R.string.maracuyasourrece,R.string.peruanisimorece,R.string.piscosourrece,R.string.quinuacarretillerarece,R.string.refrecocorece,R.string.reuvarece,R.string.sangriarece};
        btnagrega=new  int[]{R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp};
        listView = findViewById(R.id.listView);
        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i],tiempo[i],tipo[i], ingrediente[i], preparacio[i], btnagrega[i]);
            //bind all strings in an array
            arrayList.add(model);
        }
        //pasando resultado a la clase listView
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
    public void atras(View vista){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        //finish();
    }
    /*se controla la pulsacion del boton atras*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            //finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}