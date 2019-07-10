package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.app.ListActivity;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private List<String> listData=new ArrayList<>();
    View  contentView;
    private ListView list_view;
    private AnimatorSet animatorSet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.animation_fragmentA);
        animationView.playAnimation();

        demo();
        list_view = view.findViewById(R.id.ListView01);
        MyListAdapter myListAdapter;
        myListAdapter = new MyListAdapter();
        list_view.setAdapter(myListAdapter);
        list_view.setAlpha(0f);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,
                        "alpha",
                        1f,
                        0.0f);
                animator1.setDuration(2000);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(list_view,
                        "alpha",
                        0.0f,
                        1f);
                animator2.setDuration(2000);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();
            }

        }, 3000);
    }


    /////////////////////添加数据
    private void demo()
    {
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
        listData.add("好友列表");
    }

    private View view;
    private static final String KEY = "title";
 //   private TextView tvContent;
     /**
       * fragment静态传值
       */
        public static PlaceholderFragment newInstance(String str){
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle bundle = new Bundle();
            bundle.putString(KEY,str);
            fragment.setArguments(bundle);

            return fragment;
        }

    public class MyListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {

            if(converView==null)
            {
                converView=getLayoutInflater().inflate(R.layout.listview_item,parent,false);
            }
            String c= (String) getItem(position);
            TextView textView=(TextView)converView.findViewById(R.id.listView_item);
            textView.setText(c);
            return converView;
        }
    }
}
