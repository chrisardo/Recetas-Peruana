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

public class SopasActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter adapter;
    String[] title, description,tiempo,tipo;
    int[] icon, ingrediente, preparacio, btnagrega;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopas);
        toolbar = findViewById(R.id.toolboar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");
        title = new String[]{"Aguadito de pollo","Chupe de mariscos","Chupe de olluco","Caldo verde de Cajamarca","Caldo de Gallina","Chilcano de pescado","Espesado de Costilla de Res","Espesado chiclayano","Inchicapi de gallina","Menestrón peruano","Sopa criolla","Sopa Shámbar","Sopa a la minuta","Sopa de patasca","Sopa de choros"};
        description = new String[]{"6 personas","4 personas","3 personas","6 personas","4 personas","4 personas","6 personas","4 personas","6 personas","6 personas","4 personas","4 personas","4 personas","4 personas","4 personas"};
        icon = new int[]{R.drawable.aguaditodepollo,R.drawable.chupemariscos,R.drawable.chupeolluco,R.drawable.caldoverdedecajamarca,R.drawable.caldodegallina,R.drawable.chilcanopescado,R.drawable.sopares,R.drawable.espesadochiclaya,R.drawable.inchicapigallina,R.drawable.recetademenestronperuano,R.drawable.sopacriolla,R.drawable.shambar,R.drawable.sopaminuta,R.drawable.sopapatasca,R.drawable.sopachoros,};
        tiempo= new String[]{"45m","30m","30m","30m","20m","35m","12h30m","1h","2h","30m","55m","2h","25m","1h30m","50m"};
        tipo = new String[]{"Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante","Entrante"};
        ingrediente= new int[]{R.string.aguaditopollo,R.string.chupemarisco,R.string.chupeolluco,R.string.caldoverde,R.string.caldogallina,R.string.chilcanopescado,R.string.sopares,R.string.espesadochicla,R.string.inchicapi,R.string.menestron,R.string.sopacriolla,R.string.shambar,R.string.sopaminuta,R.string.sopapatasca,R.string.sopachoros};
        preparacio= new int[]{ R.string.aguaditopollorece,R.string.chupemariscorece,R.string.chupeollucorece,R.string.caldoverderece,R.string.caldogallinarece,R.string.chilcanopescadorece,R.string.soparesrece,R.string.espesadochiclarece,R.string.inchicapirece,R.string.menestronrece,R.string.sopacriollarece,R.string.shambarrece,R.string.sopaminutarece,R.string.sopapatascarece,R.string.sopachorosrece};
        btnagrega= new int[]{R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp, R.drawable.ic_delete_forever_black_24dp};
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