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

public class PastasyFideosActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastasy_fideos);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        title = new String[]{"Champiñones rellenos gratinados","Empanadas mixtas","Humita","Langostinos empanizados","Papitas al romero con dip de yogur y cebolla","Quesadillas de pollo", "Sandwich de Pan Artesanal con Queso","Tequeños de sangrecita", "Tortilla de Bacalao","Wantanes de pulpo al olivo"};
        description = new String[]{"4 personas","6 personas","2 personas","6 personas","8 personas","4 personas","1 persona","4 personas", "4 personas","4 personas"};
        icon = new int[]{R.drawable.champinonesrellenosgratinados,R.drawable.empanadasmixtas,R.drawable.humitaspe,R.drawable.langostinosempanizados,R.drawable.papitasromero,R.drawable.quesadillapollo,R.drawable.sandwichqueso,R.drawable.tquenosangrecita,R.drawable.tortilladebacalao,R.drawable.wantanpulpo};
        tiempo= new String[]{"20m","15m","8m","10m","30m","15m","3m","25m","4m","15m"};
        tipo = new String[]{"Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos","Snacks y piqueos"};
        ingrediente= new int[]{R.string.champirellenos,R.string.empanadasmixtas,R.string.humita,R.string.langosempanizados,R.string.paroyo,R.string.quesapollo,R.string.sandqueso,R.string.tequesangre,R.string.tortibacalao,R.string.wantanpulpo};
        preparacio= new int[]{R.string.champirellenosrece,R.string.empanadasmixtasrece,R.string.humitarece,R.string.langosempanizadosrece,R.string.paroyorece,R.string.quesapollorece, R.string.sandquesorece,R.string.tequesangrerece,R.string.tortibacalaorece,R.string.wantanpulporece};
        btnagrega = new int[]{R.drawable.ic_delete_forever_black_24dp,R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp};
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