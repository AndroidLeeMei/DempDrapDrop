package com.example.auser.dempdrapdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView=(ImageView)findViewById(R.id.imageView);
        imgView.setOnTouchListener(listener);

    }

    //可以偵測滑的移動
    View.OnTouchListener listener=new View.OnTouchListener() {
        private  float x,y;
        private int mx,my;
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN://先取得x,y的初始位置
                    x=event.getX();
                    y=event.getY();
                case MotionEvent.ACTION_MOVE:
                    mx=(int)(event.getRawX()-x);
                    my=(int)(event.getRawY()-getContentViewTop()-y);
                    //左上右下
                    view.layout(mx,my,mx+ view.getWidth(),my+ view.getHeight());
                    break;


            }
            return true;
        }
    };
    //計算content view的高度位置
    public int getContentViewTop() {
        View contentView = getWindow().findViewById(android.R.id.content);
        int[] coordinates = new int[2];
        contentView.getLocationOnScreen(coordinates);
        return coordinates[1];
    }

    //只能偵測按下動作
    View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };
}
