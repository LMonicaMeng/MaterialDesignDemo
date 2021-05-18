package com.demo.slidingmenudrawerlayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.ricky.materialdesign.slidingmenu.drawerlayout.R;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private DrawerLayout drawerlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		//将actionBar替换成toolbar
		setSupportActionBar(toolbar);
		
		drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
		
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.drawer_open, R.string.drawer_close);
		//同步状态
		drawerToggle.syncState();
		//给侧滑控件设置监听
//		drawerlayout.setDrawerListener(drawerToggle);
		
		drawerlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
			
			@Override
			public void onDrawerStateChanged(int newState) {
				// 状态发生改变
				
			}
			
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// 滑动的过程当中不断地回调 slideOffset：0~1
				View content = drawerlayout.getChildAt(0);
				View menu = drawerView;
				float scale = 1-slideOffset;//1~0
				float leftScale = (float) (1-0.3*scale);
				float rightScale = (float) (0.7f+0.3*scale);//0.7~1
				menu.setScaleX(leftScale);//1~0.7
				menu.setScaleY(leftScale);//1~0.7
				
				content.setScaleX(rightScale);
				content.setScaleY(rightScale);
				content.setTranslationX(menu.getMeasuredWidth()*(1-scale));//0~width
				
			}
			
			@Override
			public void onDrawerOpened(View drawerView) {
				// 打开
				
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
				// 关闭
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
