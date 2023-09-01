package co.eduardo.apprecetasperuana;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter2 extends BaseAdapter {
    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;
    private int lastPosition = -1;//animacion
    private ProgressDialog dialog;
    ListViewAdapter2 adapter;
    int eventoEliminar=0;
    //constructor
    public ListViewAdapter2(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }
    public class ViewHolder {
        TextView mTitleTv, mDescTv, tiempoB, tipoB,mingrediente, mpreparacion;
        ImageView mIconIv, eliminar;

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
    public View getView(int postition, View view, ViewGroup parent){
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.rowf, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.txtView);
            holder.mDescTv = view.findViewById(R.id.textView2);
            holder.mIconIv = view.findViewById(R.id.imaView);
            holder.tiempoB = view.findViewById(R.id.textView3);
            holder.tipoB= view.findViewById(R.id.textView4);
            holder.mingrediente=view.findViewById(R.id.textView5);
            holder.mpreparacion=view.findViewById(R.id.tvPrepara);
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
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(mContext, "administracion", null, 1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Para abirir la base de datos en modo lectura y escritura
                int codigo = modellist.get(postition).getIcon();
                if (codigo != postition){
                    int cantidad=BaseDeDatos.delete("articulos", "imagen=" + codigo, null);
                    //BaseDeDatos.close();//Cerrando la base de datos
                    if(cantidad != -1){
                        modellist.remove(postition);
                        notifyDataSetChanged();
                        setAnimation(v, postition);
                        Toast.makeText(mContext, "Receta eliminado: \n"+modellist.get(postition).getTitle(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "La receta no existe: "+modellist.get(postition).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
                BaseDeDatos.close();
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

