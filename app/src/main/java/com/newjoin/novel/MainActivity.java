package com.newjoin.novel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.newjoin.novel.Views.BottomBarView;
import com.newjoin.novel.Fragments.Fragment1;
import com.newjoin.novel.Fragments.Fragment2;
import com.newjoin.novel.Fragments.Fragment3;

/**
 * Created by NewJoin on 2018-12-30 17:28:28.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		initView();
    }
	
	private void initView(){
		BottomBarView bbv = findViewById(R.id.bbv);
		
		bbv
                .setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999","#1FA9C4")
                .addItem(Fragment1.class,"书架",R.drawable.menu_bookrack,R.drawable.menu_bookrack_selected)
                .addItem(Fragment2.class,"书城",R.drawable.menu_bookmall,R.drawable.menu_bookmall_selected)
                .addItem(Fragment3.class,"优惠",R.drawable.menu_me,R.drawable.menu_me_selected)
                .build();
		bbv.setBackgroundColor(getResources().getColor(R.color.Ink));
		   
	}
}
