package com.demo.fab;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	private boolean reverse = false;
	public void rotate(View v){
		float toDegree= reverse?-180f:180f;
		ObjectAnimator animator = ObjectAnimator
				.ofFloat(v, "rotation", 0.0f,toDegree)
				.setDuration(400);
		animator.start();
		reverse = !reverse;
	}
	
}
