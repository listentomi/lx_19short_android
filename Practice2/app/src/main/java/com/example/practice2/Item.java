package com.example.practice2;

public class Item {
    private String mContent;
    private int mImageId;
    private int mNumber;
    private int mHotValue;

    public Item(String content,int imageId,int number,int HotValue){
        this.mContent = content;
        this.mImageId = imageId;
        this.mNumber = number;
        this.mHotValue = HotValue;
    }

    public String getmContent(){
        return mContent;
    }
    public String getmNumber(){ return String.valueOf(mNumber)+"."; }
    public int getmImageId(){
        return mImageId;
    }
    public String getmHotValue(){
        return String.valueOf(mHotValue);
    }
}
