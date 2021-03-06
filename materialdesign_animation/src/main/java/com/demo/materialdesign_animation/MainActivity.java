package com.demo.materialdesign_animation;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ricky.materialdesign.animation.R;

public class MainActivity extends AppCompatActivity {

	private Button bt1;
	private Button bt2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		bt1 = (Button)findViewById(R.id.bt1);
		bt2 = (Button)findViewById(R.id.bt2);
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//圆形水波纹揭露效果
//				ViewAnimationUtils.createCircularReveal(
//						view, //作用在哪个View上面
//						centerX, centerY, //扩散的中心点
//						startRadius, //开始扩散初始半径
//						endRadius)//扩散结束半径

				Animator animator = ViewAnimationUtils.createCircularReveal(bt1, bt1.getWidth()/2, bt1.getHeight()/2, 0, bt1.getHeight());
				animator.setDuration(1000);
				animator.setInterpolator(new AccelerateInterpolator());
				animator.start();
//				Math.hypot(x, y)
			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Animator animator = ViewAnimationUtils.createCircularReveal(bt2, 0, 0, 0, (float)Math.hypot(bt2.getWidth(), bt2.getHeight()));
				animator.setDuration(1000);
				animator.setInterpolator(new AccelerateInterpolator());
				animator.start();

			}
		});
	}

}
