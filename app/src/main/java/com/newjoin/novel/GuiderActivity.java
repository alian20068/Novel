package com.newjoin.novel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by NewJoin on 2018/12/22.
 * 新手引导页
 */

public class GuiderActivity extends Activity implements View.OnTouchListener {

    private static final String TAG="GuiderActivity";

    //定义常量 引导页图片
    private final int[] arrGuider={R.drawable.guider1, R.drawable.guider2, R.drawable.guider3,R.drawable.guider4};
    private ViewPager vpGuider=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guider);

        //初始化
        initViewPager();
    }

    private void initViewPager(){
        vpGuider=findViewById(R.id.vpGuider);

        //配置必需的 Adapter
        vpGuider.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //返回引导图数量
                return arrGuider.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //return super.instantiateItem(container, position);

                //引导页是图片
                ImageView iv=new ImageView(GuiderActivity.this);
                //设置图片的背景地址
                iv.setBackgroundResource(arrGuider[position]);
                //裁剪图片白边
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //添加到容器
                container.addView(iv);

                Log.d(TAG,"添加第"+(position+1)+"页");

                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //super.destroyItem(container, position, object);

                Log.d(TAG,"移除第"+(position+1)+"页");

                //从容器里移除
                container.removeView((View) object);
            }
        });

        //当用户在最后一个页面滑动时，需要跳转到程序的主页面
        vpGuider.setOnTouchListener(this);
    }

    //跳转到主页
    private void jumpToMain(){
        Intent itMain=new Intent(this,MainActivity.class);
        startActivity(itMain);
        finish();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case  MotionEvent.ACTION_UP:
                Log.d(TAG,"这是抬起操作");
                break;
        }

        return false;
    }
}
