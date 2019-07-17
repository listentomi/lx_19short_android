package com.bytedance.camera.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bytedance.camera.demo.utils.Utils;

import java.io.File;


public class ShowPhotoActivity extends AppCompatActivity{
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        imageView = findViewById(R.id.photo);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                Intent data = getIntent();
                String imagePath = data.getStringExtra("imagepath");
                File imageFile = new File(imagePath);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(imageFile.getAbsolutePath(),options);
                int photoW = options.outWidth;
                int photoH = options.outHeight;
                int scaleFactor = Math.min(photoW/imageView.getWidth(),photoH/imageView.getHeight());
                options.inJustDecodeBounds = false;
                options.inSampleSize= scaleFactor;
                options.inPurgeable = true;
                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(),options);
                //bitmap = Utils.rotateImage(bitmap,imageFile.getAbsolutePath());
                bitmap= (Bitmap) rotateBimap(ShowPhotoActivity.this,90,bitmap);
                imageView.setImageBitmap(bitmap);
            }
        });

    }
    private Bitmap rotateBimap(Context context, float degree, Bitmap srcBitmap) {
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap bitmap = Bitmap.createBitmap(srcBitmap,0,0,srcBitmap.getWidth(),srcBitmap.getHeight()
                ,matrix,true);
        return bitmap;
    }

}
