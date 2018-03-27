package com.example.giulia.recyclerview;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Giulia on 19/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainActivity mainActivity = new MainActivity();
        View itemView;

        switch (mainActivity.myLayoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
                break;
            case LINEAR_LAYOUT_MANAGER:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_item, parent, false);
                break;
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_item, parent, false);
                break;
        }
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.tv.setText("Loop_IC_Launcher");
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public ImageView iv;

        public ViewHolder(View v) {
            super(v);
            tv = (TextView) v.findViewById(R.id.txv);
            iv = (ImageView) v.findViewById(R.id.img);
        }
    }
}
