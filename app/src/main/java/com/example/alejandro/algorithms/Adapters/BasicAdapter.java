package com.example.alejandro.algorithms.Adapters;

/**
 * Created by Administrador on 30/01/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.alejandro.algorithms.Lists.BasicList;
import com.example.alejandro.algorithms.R;

import java.util.List;


public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {
    List<BasicList> basiclist;
    Context context;
    OnItemClickListener mItemClickListener;
    int key=0;

    public BasicAdapter(Context context, List<BasicList> basiclist) {
        this.context = context;
        this.basiclist = basiclist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basiclist_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        BasicList item = basiclist.get(position);
        holder.titlebasiclist.setText(item.getTitle());
        holder.infobasiclist.setText(item.getDescription());
        Glide.with(context)
                .load(item.getImagen())
                .error(R.drawable.ic_menu_gallery)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return basiclist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titlebasiclist;
        public TextView infobasiclist;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            titlebasiclist = (TextView) itemView.findViewById(R.id.title);
            infobasiclist = (TextView) itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
