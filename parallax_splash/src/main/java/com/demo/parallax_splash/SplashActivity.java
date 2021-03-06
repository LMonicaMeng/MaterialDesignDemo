package com.demo.parallax_splash;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.dongnaoedu.parallaxsplash.R;

public class SplashActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ParallaxContainer container = (ParallaxContainer) findViewById(R.id.parallax_container);
		container.setUp(new int[]{
			R.layout.view_intro_1,
			R.layout.view_intro_2,
			R.layout.view_intro_3,
			R.layout.view_intro_4,
			R.layout.view_intro_5,
			R.layout.view_login
		});
		
		//设置动画
		ImageView iv_man = (ImageView) findViewById(R.id.iv_man);
		iv_man.setBackgroundResource(R.drawable.man_run);
		container.setIv_man(iv_man);
		
	}


}
