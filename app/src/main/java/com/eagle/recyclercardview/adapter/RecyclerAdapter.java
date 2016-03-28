package com.eagle.recyclercardview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eagle.recyclercardview.R;
import com.eagle.recyclercardview.model.Lamp;

import java.util.List;

/**
 * Created by 1 on 28.03.2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private List<Lamp> mData;
    private LayoutInflater mInflater;


    public RecyclerAdapter(Context context, List<Lamp> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Lamp currentObj = mData.get(position);
        holder.setData(currentObj, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imgAdd;
        ImageView imgDelete;
        ImageView imgThumb;
        TextView title;
        int position;
        Lamp current;

        public MyViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }


        public void setData(Lamp currentObj, int position) {
            this.title.setText(currentObj.getTitle());
            this.imgThumb.setImageResource(currentObj.getImageId());
            this.position = position;
            this.current = currentObj;

        }
    }
}
