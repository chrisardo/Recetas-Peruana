package co.eduardo.apprecetasperuana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MaAdapter extends RecyclerView.Adapter<MaAdapter.ExampleViewHolder>{
    private ArrayList<MExampleItem> mExampleListM;
    private OnItemClickListener mListener;
    private int lastPosition = -1;//animacion
    public interface OnItemClickListener{
        void onItemClick(int position);
        void onButtonClick(int position);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.relamain, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        holder.mImageView.setImageResource(mExampleListM.get(position).getmImageResource());
        holder.mTextView1.setText(mExampleListM.get(position).getmText1());
        setAnimation(holder.itemView, position);
    }
    public MaAdapter(ArrayList<MExampleItem> exampleList){
        mExampleListM = exampleList;
    }
    public  void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    @Override
    public int getItemCount() {
        return mExampleListM.size();
    }
    public static class  ExampleViewHolder extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public ExampleViewHolder(final View itemView, final OnItemClickListener listener){
            super(itemView);
            final Context context;
            context = itemView.getContext();
            mImageView = itemView.findViewById(R.id.imageViewM);
            mTextView1 = itemView.findViewById(R.id.textViewM);
            mTextView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener !=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
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

