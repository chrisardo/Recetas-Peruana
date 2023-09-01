package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritoActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ListViewAdapter2 adapter;
    AdminSQLiteOpenHelper admin;
    //ArrayList<Model> arrayList;

    RecyclerView rView;
    private FavoritoAdapter favoritoAdapter;
    ArrayList<Model> listaRectas;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);
        toolbar = findViewById(R.id.toolboar);
        //toolbar.setTitleTextColor(View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");
        rView = (RecyclerView)findViewById(R.id.listView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(lim);
        consultarListaPersonas();
        llenarRecetasFavoritas();
        //pass results to listViewAdapter class
        //adapter = new ListViewAdapter2(this, arrayList);
        //bind the adapter to the listview
        //listView.setAdapter(adapter);
    }
    private void consultarListaPersonas() {
        admin = new AdminSQLiteOpenHelper(getApplicationContext(), "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();//Para abirir la base de datos en modo lectura y escritura
        Model usuario=null;
        listaRectas=new ArrayList<Model>();
        cursor=BaseDeDatos.rawQuery("SELECT * FROM  articulos",null);
        while (cursor.moveToNext()){
            usuario = new Model();
            usuario.setIcon(cursor.getInt(0));
            usuario.setTitle(cursor.getString(1));
            usuario.setDesc(cursor.getString(2));
            usuario.setTiempo(cursor.getString(3));
            usuario.setTipo(cursor.getString(4));
            usuario.setIngrediente(cursor.getInt(5));
            usuario.setPreparacion(cursor.getInt(6));
            //usuario.setBtnicon(cursor.getInt(7));
            listaRectas.add(usuario);
        }
        BaseDeDatos.close();
    }

    private void llenarRecetasFavoritas() {
        favoritoAdapter = new FavoritoAdapter(listaRectas);
        favoritoAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Receta: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetallesActivity.class);
                intent.putExtra("actionBarTitle", listaRectas.get(rView.getChildAdapterPosition(v)).getTitle());
                intent.putExtra("contentTv", listaRectas.get(rView.getChildAdapterPosition(v)).getDesc());
                intent.putExtra("actionBarImage", listaRectas.get(rView.getChildAdapterPosition(v)).getIcon());
                intent.putExtra("tiempo", listaRectas.get(rView.getChildAdapterPosition(v)).getTiempo());
                intent.putExtra("tipo", listaRectas.get(rView.getChildAdapterPosition(v)).getTipo());
                intent.putExtra("ingrediente", listaRectas.get(rView.getChildAdapterPosition(v)).getIngrediente());
                intent.putExtra("preparacio", listaRectas.get(rView.getChildAdapterPosition(v)).getPreparacion());
                startActivity(intent);
            }
        });
        rView.setAdapter(favoritoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setMaxWidth(Integer.MIN_VALUE);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                favoritoAdapter.getFilter().filter(s);
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