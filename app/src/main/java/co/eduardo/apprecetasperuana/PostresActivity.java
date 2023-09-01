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

public class PostresActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postres);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        title = new String[]{"Avena con manzanas","Bola de oro de alfajor","Crema volteada peruana","Crema de lúcuma","Leche asada al baño María","Leche asada peruana","leche asada en microondas","Mazamorra morada","Mazamorra de chancaca","Pie de limón peruano","Pastel helado peruano","Queso helado arequipeño","Queque de plátano","Rollo de aguaymanto","Smothie de leche de almendras","Soufflé de coliflor y queso parmesano"};
        description = new String[]{"4 personas","8 personas","4 personas","4 personas","6 personas","6 personas","8 personas","10 personas","6 personas","8 personas","6 personas","4 personas","10 personas","1 perosna","2 perosnas","4 personas"};
        icon = new int[]{R.drawable.avenaconmanzana,R.drawable.bolaalfajor,R.drawable.cremvolteperu,R.drawable.cremadelucuma,R.drawable.leasadaalba,R.drawable.lechasaperu,R.drawable.lecheasadaenmicroondas,R.drawable.mazamorramoradape,R.drawable.mazamorrachancaca,R.drawable.piedelimon,R.drawable.pastelheladoper,R.drawable.quesoheladoarequipeno,R.drawable.quequeplatano,R.drawable.rolloaguaymanto,R.drawable.smothiealmendra,R.drawable.soufle};
        tiempo= new String[]{"25m","40m","30m","15m","1h 30m","30m","45m","45m"," 30m","45m","4h","2h 30m","35m","1h 30m","9h","45m"};
        tipo = new String[]{"Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres","Postres"};
        ingrediente= new int[]{R.string.avenamanza,R.string.bolaalfajor,R.string.cremavolteadaperu,R.string.cremalucuma,R.string.lecheasadaalbanomaria,R.string.lecheasadaperu,R.string.lecheasadaconlechecondesada,R.string.mazamorramorada,R.string.mazamorradechancaca,R.string.pielimonper,R.string.pasteldeheladoperu,R.string.quesohelodoarequipeno,R.string.quequeplatano,R.string.rolloaguaymanto,R.string.smothieleche,R.string.souflecoliflor};
        preparacio= new int[]{R.string.avenamanzarece,R.string.bolaalfajorrece,R.string.cremavolteadarece,R.string.cremaprepara, R.string.lecheasadoalbanorece, R.string.lecheasadarece,R.string.lecheasadaconlechecondesadarece, R.string.mazamorramoradarece, R.string.mazamorrachancacarece, R.string.pielimonrece, R.string.pasteldeheladorece, R.string.quesoheladorece,R.string.quequeplatanorece,R.string.rolloaguaymantorece,R.string.smothielecherece,R.string.souflecoliflorrece};
        btnagrega = new int[]{R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp};
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