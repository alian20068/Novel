package com.newjoin.novel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by NewJoin on 2018/12/22.
 * 启动页2
 */

public class Start2Activity extends Activity implements View.OnClickListener {

    private static final String TAG="Start2Activity";

    private int iCountDown=5;//倒计时秒数
    private TextView tvCountDown;
    private Handler myHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            Log.d(TAG,"-------------------"+iCountDown);

            tvCountDown.setText("跳过 "+iCountDown+" 秒");
            iCountDown--;

            if(iCountDown<0){

                jumpToGuider();
                return;
            }

            myHandler.sendEmptyMessageDelayed(0,1000);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);

        initView();
    }

    private void initView(){
        tvCountDown=findViewById(R.id.tvCountdown);
        tvCountDown.setOnClickListener(this);//监听点击事件

        myHandler.sendEmptyMessageDelayed(0,1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCountdown:
                jumpToGuider();
                break;
        }
    }

    //跳到引导页
    private void jumpToGuider(){
        myHandler.removeCallbacksAndMessages(null);

        Intent itGuider=new Intent(this,GuiderActivity.class);
        startActivity(itGuider);
        finish();//在用户返回时，不会返回此 activity，而返回到 此 activity 的发起者
    }

}
