package com.demo.materialdesign.recyclerview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ricky.materialdesign.recyclerview.R;

public class MainActivity extends Activity {

	private RecyclerView recylerview;
	private ArrayList<String> list;
	private MyRecyclerAdapter adapter;
//	private MyStaggedRecyclerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		list = new ArrayList<String>();
		for (int i = 0; i < 60; i++) {
			list.add("item"+i);
		}
		
		recylerview = (RecyclerView)findViewById(R.id.recylerview);
		adapter = new MyRecyclerAdapter(list);
//		adapter = new MyStaggedRecyclerAdapter(list);
		//LayoutManager布局摆放管理器(线性摆放、瀑布流)
//		recylerview.setLayoutManager(new LinearLayoutManager(this));//默认垂直
		//reverseLayout:数据倒置，从右边开始滑动
//		recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
		recylerview.setLayoutManager(new GridLayoutManager(this, 3));
		//瀑布流效果
//		recylerview.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
		recylerview.setAdapter(adapter);

		decor = new DividerGridViewItemDecoration(this);
		recylerview.addItemDecoration(decor);
		
		recylerview.setItemAnimator(new DefaultItemAnimator());
		adapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
			
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(MainActivity.this, "点我干嘛"+position, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	boolean isGrid = false;
	private RecyclerView.ItemDecoration decor;
	
	public void change(View v){
		if(decor!=null)
		recylerview.removeItemDecoration(decor);
		if(!isGrid){
//			recylerview.setLayoutManager(new GridLayoutManager(this, 3));
			recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));//默认垂直
			decor = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
			recylerview.addItemDecoration(decor);
		}else{
			recylerview.setLayoutManager(new LinearLayoutManager(this));//默认垂直
			decor = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
			recylerview.addItemDecoration(decor);
		}
		isGrid = !isGrid;
	}
	
	public void addItem(View v){
		adapter.addData(0);
		restoreScrollPositionAfterAdAdded();
	}

	private void restoreScrollPositionAfterAdAdded() {
		LinearLayoutManager layoutManager = (LinearLayoutManager) recylerview.getLayoutManager();
		if (layoutManager != null) {
			int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

			if (firstVisibleItemPosition == 0){
				layoutManager.scrollToPosition(0);
			}
		}
	}
}
