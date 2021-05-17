package com.demo.recyclerwithheadfoot;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ricky.materialdesign.wraprecyclerview.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private List<String> list;

	public MyAdapter(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	
	public class ViewHolder extends RecyclerView.ViewHolder{

		public TextView tv;
		public ViewHolder(View view) {
			super(view);
			// TODO Auto-generated constructor stub
			tv = (TextView) view.findViewById(R.id.tv);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.tv.setText(list.get(position));
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.listitem, parent, false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}
}
