package com.demo.translucent;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.ricky.materialdesign.translucent.R;

public class MainActivity2 extends BaseTranslucentActivity{

	private Toolbar toolbar;
	private View nav;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		nav = findViewById(R.id.nav);
		setOrChangeTranslucentColor(toolbar, nav, getResources().getColor(R.color.colorPrimary_pink));
		
	}
}
