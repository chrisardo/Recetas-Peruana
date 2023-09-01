package co.eduardo.apprecetasperuana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detalles2Activity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingtoolbar;
    ImageView im;
    TextView tvperso, tvhora, tvTipo, tvingrediente, tvpreparacion;
    int mImage,mingrediente,mprepara ;
    String mActionBarTitle,mContent,mtiempo,mtipo;
    AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles2);
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
    /*public void irWeb(View view){
        Intent miIntent = new Intent(getApplicationContext(), WebActivity.class);
        miIntent.putExtra("sitioWeb", "www.youtube.com/watch?v=ljKHry6y6Gs");
        startActivity(miIntent);
    }*/

    public void atras(View view){
        finish();
    }
}