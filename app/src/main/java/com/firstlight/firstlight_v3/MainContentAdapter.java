package com.firstlight.firstlight_v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static android.view.View.inflate;

/**
 * Created by sushantkumar on 10/08/15.
 */
public class MainContentAdapter extends RecyclerView.Adapter <MainContentAdapter.contentViewHolder>  {

    private LayoutInflater inflater;
    List<SubscribeItem> data = Collections.emptyList();
    public MainContentAdapter(Context context, List<SubscribeItem> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public contentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.product_row, viewGroup, false);
        contentViewHolder holder = new contentViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(contentViewHolder holder, int i) {
        SubscribeItem current = data.get(i);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconid);


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class contentViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        public contentViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.contentItemName);
            icon = (ImageView) itemView.findViewById(R.id.contentImg);
        }
    }

}
