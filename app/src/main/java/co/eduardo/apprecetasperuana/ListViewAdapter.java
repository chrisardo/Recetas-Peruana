package co.eduardo.apprecetasperuana;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;*/

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;
    private int lastPosition = -1;//animacion

    //private InterstitialAd mInterstitialAd;
    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        // TODO: Add adView to your view hierarchy.
        /*MobileAds.initialize(mContext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId("ca-app-pub-8302868983775944/8621915224");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());*/

        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv, tiempoB, tipoB,mingrediente, mpreparacion,web;
        ImageView mIconIv, eliminar;
        public Button agregar;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.txtView);
            holder.mDescTv = view.findViewById(R.id.textView2);
            holder.mIconIv = view.findViewById(R.id.imaView);
            holder.tiempoB = view.findViewById(R.id.textView3);
            holder.tipoB= view.findViewById(R.id.textView4);
            holder.mingrediente=view.findViewById(R.id.textView5);
            holder.mpreparacion=view.findViewById(R.id.tvPrepara);
            holder.agregar= view.findViewById(R.id.btnAgregar);
            holder.web= view.findViewById(R.id.tvUrl);
            holder.eliminar= view.findViewById(R.id.btnEliminar);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        holder.tiempoB.setText(modellist.get(postition).getTiempo());
        holder.tipoB.setText(modellist.get(postition).getTipo());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());
        holder.mingrediente.setText(modellist.get(postition).getIngrediente());
        holder.mpreparacion.setText(modellist.get(postition).getPreparacion());
        //holder.eliminar.setImageResource(modellist.get(postition).getBtnicon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                /*if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }*/
                Intent intent = new Intent(mContext, DetallesActivity.class);
                intent.putExtra("actionBarTitle", modellist.get(postition).getTitle());
                intent.putExtra("contentTv", modellist.get(postition).getDesc());
                intent.putExtra("actionBarImage", modellist.get(postition).getIcon());
                intent.putExtra("tiempo", modellist.get(postition).getTiempo());
                intent.putExtra("tipo", modellist.get(postition).getTipo());
                intent.putExtra("ingrediente", modellist.get(postition).getIngrediente());
                intent.putExtra("preparacio", modellist.get(postition).getPreparacion());
                mContext.startActivity(intent);
            }
        });
        holder.agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final int id = modellist.get(postition).getIcon();
                //final ImageView mLove = v.findViewById(R.id.btnAgregar);
                //final Boolean love = modellist.get(postition).getLove();
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(mContext, "administracion", null, 1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Para abirir la base de datos en modo lectura y escritura
                ContentValues registro = new ContentValues();
                registro.put("imagen", modellist.get(postition).getIcon());
                registro.put("texto", modellist.get(postition).getTitle());
                registro.put("persona", modellist.get(postition).getDesc());
                registro.put("tiempo",modellist.get(postition).getTiempo());
                registro.put("plato",modellist.get(postition).getTipo());
                registro.put("ingredien",modellist.get(postition).getIngrediente());
                registro.put("prepara",modellist.get(postition).getPreparacion());
                //registro.put("btnagregar", modellist.get(postition).getBtnicon());
                Long idResultante=BaseDeDatos.insert("articulos", null, registro);
                if(idResultante!=-1){
                    Toast.makeText(mContext,"Receta: "+modellist.get(postition).getTitle()+" agregado a favoritos", Toast.LENGTH_SHORT).show();
                    //holder.agregar.setBackgroundResource(R.drawable.ic_favorite);
                }else {
                    Toast.makeText(mContext,"Ya se agregó a favoritos: \n"+modellist.get(postition).getTitle(), Toast.LENGTH_SHORT).show();
                    //holder.agregar.setBackgroundResource(R.drawable.ic_favorite_border);
                }
                BaseDeDatos.close();//Cerrando la base de datos
            }
        });
        setAnimation(view, postition);
        return view;
    }
    public void setAnimation(View viewToAnimate, int position){
        if (position > lastPosition){
            ScaleAnimation animation = new ScaleAnimation(0.0f,1.0f,0.0f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(1500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }
    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}

