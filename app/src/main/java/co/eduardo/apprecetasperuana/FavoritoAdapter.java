package co.eduardo.apprecetasperuana;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.ViewHolderRecetas> implements Filterable, View.OnClickListener {
    ArrayList<Model> listaRectas;
    private View.OnClickListener listener;
    private int lastPosition = -1;//animacion
    List<Model> modellist;
    Context mContext;
    Activity actividad;
    int eventoEliminar=0;
    public FavoritoAdapter(ArrayList<Model> listaRectas) {
        this.listaRectas = listaRectas;
        modellist= new ArrayList<Model>();
        modellist.addAll(listaRectas);
    }
    @Override
    public ViewHolderRecetas onCreateViewHolder(ViewGroup parent, int viewType) {
        //mContext=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowf,parent,false);
        view.setOnClickListener(this);
        return new ViewHolderRecetas(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderRecetas holder, int position) {
        holder.foto.setImageResource(listaRectas.get(position).getIcon());
        holder.etiNombre.setText(listaRectas.get(position).getTitle());
        holder.etpersona.setText(listaRectas.get(position).getDesc());
        holder.ettiempo.setText(listaRectas.get(position).getTiempo());
        holder.etcategoria.setText(listaRectas.get(position).getTipo());
        holder.ingredientes.setText(listaRectas.get(position).getIngrediente());
        holder.preparcio.setText(listaRectas.get(position).getPreparacion());
        //holder.eliminar.setImageResource(listaRectas.get(position).getBtnicon());
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "eliminar "+ listaRectas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext,R.style.DialogSalida);
                builder.setTitle("Advertencia!!!")
                        .setMessage("¿Está seguro que desea eliminar: "+listaRectas.get(position).getTitle()+" ?")
                        .setNegativeButton("CANCELAR",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                        .setPositiveButton("ACEPTAR",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        eliminarJugador(position);
                                        dialog.cancel();
                                    }
                                });
                builder.show();
                builder.create();
            }
        });
        setAnimation(holder.itemView, position);
    }
    private void eliminarJugador(int position) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(mContext, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Para abirir la base de datos en modo lectura y escritura
        int cantidad=BaseDeDatos.delete("articulos", "imagen=" + listaRectas.get(position).getIcon(), null);
        if(cantidad != -1){
            /*listaRectas.remove(position);
            notifyDataSetChanged();*/
            Intent im= new Intent(mContext, FavoritoActivity.class);
            mContext.startActivity(im);
            eventoEliminar=1;
            Toast.makeText(mContext, "Receta eliminado: "+listaRectas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "La receta no existe: "+listaRectas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        }
        BaseDeDatos.close();
    }
    @Override
    public int getItemCount() {
        return listaRectas.size();//Retornar el tamaño de la lista
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }
    public class ViewHolderRecetas extends RecyclerView.ViewHolder {
        TextView etiNombre, etpersona, ettiempo, etcategoria, ingredientes, preparcio;
        ImageView foto, eliminar;
        public ViewHolderRecetas(View itemView) {
            super(itemView);
            mContext=itemView.getContext();
            etiNombre= (TextView) itemView.findViewById(R.id.txtNombre);
            etpersona= (TextView) itemView.findViewById(R.id.txtpersonas);
            foto= (ImageView) itemView.findViewById(R.id.imaView);
            ettiempo= (TextView) itemView.findViewById(R.id.txtiempo);
            etcategoria= (TextView) itemView.findViewById(R.id.txcategoria);
            ingredientes= (TextView) itemView.findViewById(R.id.txingrediente);
            preparcio= (TextView) itemView.findViewById(R.id.tpreparacion);
            eliminar = (ImageView) itemView.findViewById(R.id.btnEliminar);
        }
    }
    //Filter
    @Override
    public Filter getFilter(){
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Model> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(modellist);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Model item : modellist){
                    if (item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listaRectas.clear();
            listaRectas.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
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
}
