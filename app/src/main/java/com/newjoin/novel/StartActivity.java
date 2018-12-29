package com.newjoin.novel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by NewJoin on 2018/12/22.
 * 启动页
 */

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //初始化图片
        initImageView();
    }

    private void initImageView(){
        ImageView ivStart=findViewById(R.id.ivStart);

        //5秒后跳转到引导页
        ivStart.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转到引导页
                jumpToGuider();
            }
        },5000);

    }

    private void jumpToGuider(){
        Intent itGuider=new Intent(this,GuiderActivity.class);
        startActivity(itGuider);
        finish();//在用户返回时，不会返回此 activity，而返回到 此 activity 的发起者
    }

}
