package com.example.practice2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView iconImage;
    TextView iconName;
    TextView iconNo;
    TextView iconHotValue;

    public ViewHolder(View view){
        super(view);
        //iconImage = (ImageView) view.findViewById(R.id.icon_image);
        iconName = (TextView) view.findViewById(R.id.icon_content);
        iconNo = (TextView) view.findViewById(R.id.icon_No);
        iconHotValue = (TextView) view.findViewById(R.id.icon_HotValue);
    }
}

