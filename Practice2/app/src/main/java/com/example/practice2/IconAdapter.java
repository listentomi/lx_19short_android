package com.example.practice2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IconAdapter extends RecyclerView.Adapter {
    private List<Item> mIconList;

    public static enum ITEM_TYPE {
        ITEM_TYPE_FirstThree,
        ITEM_TYPE_OrdinaryList,
        ITEM_TYPE_TagXin
    }

    public IconAdapter(List<Item> iconList){
        mIconList = iconList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE.ITEM_TYPE_OrdinaryList.ordinal()){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.icon_item_type1,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }else if(viewType == ITEM_TYPE.ITEM_TYPE_FirstThree.ordinal()){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.icon_item_withtag,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }else if(viewType == ITEM_TYPE.ITEM_TYPE_TagXin.ordinal()){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.icon_item_withtag1_xin,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item icon = mIconList.get(position);
//        ((ViewHolder)holder).iconImage.setImageResource(icon.getmImageId());
        ((ViewHolder)holder).iconName.setText(icon.getmContent());
        ((ViewHolder)holder).iconNo.setText(icon.getmNumber());
        ((ViewHolder)holder).iconHotValue.setText(icon.getmHotValue());
    }

    @Override
    public int getItemCount() {
        return mIconList.size();
    }
    public int getItemViewType(int position){
        if(position>2)
        {
            if(position%5==0){
                return ITEM_TYPE.ITEM_TYPE_TagXin.ordinal();
            }
            else{
                return ITEM_TYPE.ITEM_TYPE_OrdinaryList.ordinal();
            }
        }
        else{
            return ITEM_TYPE.ITEM_TYPE_FirstThree.ordinal();
        }

    }


}
