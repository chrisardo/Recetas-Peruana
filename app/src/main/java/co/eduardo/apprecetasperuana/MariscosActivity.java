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

public class MariscosActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mariscos);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        title = new String[]{"Ají de atún peruano","Ceviche de Conchitas","Chupe de camarones peruano","Chicharrón de calamar","Chicharrón de pescado","Majarisco norteño","Picante de mariscos","Pescado sudado", "Tiradito de lenguado"};
        description = new String[]{"6 personas","2 personas","6 personas","1 personas","6 personas","4 personas","2 personas","5 personas", "2 personas"};
        icon = new int[]{R.drawable.ajiatunper,R.drawable.cebicheconchitas,R.drawable.chupedecamaronesperu,R.drawable.chicharrondecalamar,R.drawable.chciarronpescado,R.drawable.majarisconorteno,R.drawable.picantedemariscospe,R.drawable.pescadosudadope, R.drawable.tiraditolenguado};
        tiempo= new String[]{"30m","25m","1h 30m","30m","30m","15m","1h 30m","45m", "6m"};
        tipo = new String[]{"Pescados y Mariscos", "Pescados y Mariscos","Pescados y Mariscos","Pescados y Mariscos","Pescados y Mariscos", "Pescados y Mariscos","Pescados y Mariscos","Pescados y Mariscos","Pescados y Mariscos"};
        ingrediente= new int[]{R.string.ajiatun, R.string.cebicheconchi,R.string.chupecamarones,R.string.chicharrondecalamar,R.string.chicharronpescado,R.string.majarisconorteno,R.string.piscantemariscope,R.string.pescadosudado, R.string.tiralenguado};
        preparacio= new int[]{R.string.ajiatunrece, R.string.cebicheconchirece, R.string.chupecamaronesrece, R.string.chicharrondecalamarrece, R.string.chcicharronpescadorece, R.string.majarisconortenorece,R.string.picantemariscorece, R.string.pescadosudadorece, R.string.tiralenguadorece};
        btnagrega = new int[]{R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp};
        listView = findViewById(R.id.listView);
        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i],tiempo[i],tipo[i], ingrediente[i], preparacio[i], btnagrega[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
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