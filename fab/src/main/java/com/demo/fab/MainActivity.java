package com.demo.fab;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.ricky.materialdesign.fab.animation.R;

public class MainActivity extends AppCompatActivity implements HideScrollListener{

	private RecyclerView recyclerview;
	private ImageButton fab;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
		fab = (ImageButton)findViewById(R.id.fab);

		toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		setTitle("动脑学院");
//		recyclerview.setOnScrollListener(null);
//		recyclerview.addOnScrollListener(new FabScrollListener(this));

		recyclerview.setLayoutManager(new LinearLayoutManager(this));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			list.add("Item"+i);
		}
		RecyclerView.Adapter adapter = new FabRecyclerAdapter(list );
		recyclerview.setAdapter(adapter );

	}

	public void rotate(View v){
		Snackbar.make(v, "倩倩该吃药了！", Snackbar.LENGTH_SHORT)
				.setAction("确定", new OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "吃过啦", 0).show();
					}
				})
				.show();
	}

	@Override
	public void onHide() {
		// 隐藏动画--属性动画
		toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
		RelativeLayout.LayoutParams layoutParams = (LayoutParams) fab.getLayoutParams();

		fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
	}

	@Override
	public void onShow() {
		// 显示动画--属性动画
		toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

		RelativeLayout.LayoutParams layoutParams = (LayoutParams) fab.getLayoutParams();
		fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

	}

}
