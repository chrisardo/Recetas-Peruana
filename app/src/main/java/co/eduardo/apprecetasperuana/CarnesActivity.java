package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
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

public class CarnesActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        title = new String[]{"Albóndigas de carne peruanas","Carne al sillao peruano","Carapulcra de cerdo","Escabeche de pollo peruano","Lomo saltado peruano","Lomo negro sencillo","Pachamanca","Pollo al horno peruano","Salteado de pollo con holantao","Sangrecita de pollo",};
        description = new String[]{"2 personas","4 personas","4 personas","4 personas","4 personas","4 personas","12 personas","4 personas","4 personas","4 personas"};
        icon = new int[]{R.drawable.albondigascarnesperuanas,R.drawable.carnealsillaoper,R.drawable.carapulcradecerdo,R.drawable.escabechepolloperu,R.drawable.lomosaltado,R.drawable.lomonegrosencillo,R.drawable.pachamanca,R.drawable.pollalhornoperu,R.drawable.saltadopolloholantao,R.drawable.sangrecitapollo,};
        tiempo= new String[]{"30m","2h 30m","45m","30m","30m","30m","45m","45m","30m","30m"};
        tipo = new String[]{"Plato principal","Plato principal","Plato principal","Plato principal","Plato principal","Plato principal","Plato principal","Plato principal","Plato principal","Plato principal"};
        ingrediente= new int[]{R.string.albondigadecarne,R.string.carnealsillao,R.string.carapulcradecerdo,R.string.escabechedepollo,R.string.lomosaltado,R.string.lomonegrosencillo,R.string.pachamanca,R.string.polloalhorno,R.string.saltadodepolloconholantao,R.string.sangresitadepollo};
        preparacio= new int[]{R.string.albondigadecarnerece,R.string.carnealsillaorece, R.string.carapulcradecerdorece,R.string.escabechedepollorece, R.string.lomosaltadorece, R.string.lomonegrorece, R.string.pachamancarece, R.string.polloalhornorece,R.string.saltadodepolloconholantaorece,R.string.sangrecitadepollorece};
        btnagrega=new int[]{R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp};
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
    public void atras(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}