package co.eduardo.apprecetasperuana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecetas extends RecyclerView.Adapter<AdaptadorRecetas.ViewHolderRecetas>
        implements View.OnClickListener{
    ArrayList<Model> listaRectas;
    private View.OnClickListener listener;
    private int lastPosition = -1;//animacion
    List<Model> modellist;
    public AdaptadorRecetas(ArrayList<Model> listaRectas) {
        this.listaRectas = listaRectas;
        modellist= new ArrayList<Model>();
        modellist.addAll(listaRectas);
    }
    @Override
    public ViewHolderRecetas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recemain,parent,false);
        view.setOnClickListener(this);
        return new ViewHolderRecetas(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderRecetas holder, int position) {
        holder.etiNombre.setText(listaRectas.get(position).getTitle());
        holder.etpersona.setText(listaRectas.get(position).getDesc());
        holder.foto.setImageResource(listaRectas.get(position).getIcon());
        holder.ettiempo.setText(listaRectas.get(position).getTiempo());
        holder.etcategoria.setText(listaRectas.get(position).getTipo());
        holder.ingredientes.setText(listaRectas.get(position).getIngrediente());
        holder.preparcio.setText(listaRectas.get(position).getPreparacion());
        //holder.sonido.setImageResource(listaPersonajes.get(position).getSonido());
        setAnimation(holder.itemView, position);
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
        ImageView foto;
        ImageView sonido;
        public ViewHolderRecetas(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.txtView);
            etpersona= (TextView) itemView.findViewById(R.id.personas);
            foto= (ImageView) itemView.findViewById(R.id.imaView);
            ettiempo= (TextView) itemView.findViewById(R.id.tiempo);
            etcategoria= (TextView) itemView.findViewById(R.id.categoria);
            ingredientes= (TextView) itemView.findViewById(R.id.tingrediente);
            preparcio= (TextView) itemView.findViewById(R.id.tpreparacion);
            //sonido = (ImageView) itemView.findViewById(R.id.idsonido);
        }
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
}
