package com.demo.fabanimation;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
