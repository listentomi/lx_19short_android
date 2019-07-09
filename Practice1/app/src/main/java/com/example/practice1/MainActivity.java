package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CheckBox checkbox_shoucang;
        checkbox_shoucang = (CheckBox) findViewById(R.id.checkBox);
        checkbox_shoucang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    checkbox_shoucang.setText("已收藏");
                    Log.i("ischecked","isChecked=1");
                } else {
                    checkbox_shoucang.setText("收藏");
                    Log.i("ischecked","isChecke=0");
                }
            }
        });

        final Button btn_pingfen;
        btn_pingfen=(Button) findViewById(R.id.button_pingfen);
        btn_pingfen.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                btn_pingfen.setText("评分已提交！");
                Log.i("isclick_pingfen","isclick");
            }
        });

        final EditText input;
        final Button button_tijiao;
        input = (EditText) findViewById(R.id.editText2);
        button_tijiao=(Button) findViewById(R.id.button_tijiao);
        button_tijiao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String value = input.getText().toString();
                //trim() 表示输入前后空格
                if(value != "指鹿为马"){
                    input.setError("答案错误！");
                    return;
                }
                else{
                    input.setError("恭喜答案正确！");
                    return;
                }
            }
        });
    }

}





