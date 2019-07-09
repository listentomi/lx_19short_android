package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Item> iconList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///初始化
        init();
        //获取RecyclerView的实例
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //创建一个layoutManager，这里使用LinearLayoutManager指定为线性，也就可以有ListView这样的效果
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //完成layoutManager设置
        recyclerView.setLayoutManager(layoutManager);
        //创建IconAdapter的实例同时将iconList传入其构造函数
        IconAdapter adapter = new IconAdapter(iconList);
        //完成adapter设置
        recyclerView.setAdapter(adapter);
    }
    private void init(){
        ArrayList arr = new ArrayList(); //初始化数组,下面各种方法省略初始化
        arr.add("敬礼我的超级英雄");
        arr.add("我们不一Young");
        arr.add("珍eye每一天");
        arr.add("请平安出行");
        arr.add("现在是怀旧时间");
        arr.add("纸短情长");
        arr.add("田馥甄");
        arr.add("我们一起学猫叫");
        arr.add("轻轻牵着你的耳朵");
        arr.add("林俊杰");
        arr.add("浙江大学");
        arr.add("小学期实训");
        arr.add("抖音APP");
        arr.add("迪士尼公主戒指");
        arr.add("上海垃圾分类");
        arr.add("林海");
        arr.add("陈情令预告");
//        String[] stringData=new String[]{"敬礼我的超级英雄","我们不一Young","珍eye每一天","请平安出行","现在是怀旧时间","纸短情长","田馥甄","我们一起学猫叫",
//                "轻轻牵着你的耳朵","林俊杰","浙江大学","抖音APP","Android实训"};
        for (int i=0;i<arr.size();i++) {
            Item it = new Item((String)arr.get(i), 1,i+1,1233457-2334*i);
            iconList.add(it);
        }
    }
}
