package com.demo.snackbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.ricky.materialdesign.snackbar.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showCustomToast(View v){
//		Toast.makeText(this, "吐司", 0).show();
		Toast result = new Toast(this);

		LayoutInflater inflate = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.custom_toast, null);
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		tv.setText("自定义吐司在此！");

//        result.setGravity(gravity, xOffset, yOffset)
		result.setView(view);
		result.setDuration(Toast.LENGTH_LONG);
		result.show();
	}

	public void showSnackbar(View v){
		//LENGTH_INDEFINITE:无穷
		Snackbar snackbar = Snackbar.make(v, "是否开启加速模式？", Snackbar.LENGTH_INDEFINITE);
		snackbar.setAction("确定", new OnClickListener() {

			@Override
			public void onClick(View v) {
				showCustomToast(null);
			}
		});
		//不能设置多个action，会被覆盖
		snackbar.setAction("取消", new OnClickListener() {

			@Override
			public void onClick(View v) {
				showCustomToast(null);
			}
		});
		snackbar.setCallback(new Snackbar.Callback() {

			@Override
			public void onDismissed(Snackbar snackbar, int event) {
				// TODO Auto-generated method stub
				showCustomToast(null);
				super.onDismissed(snackbar, event);
			}

			@Override
			public void onShown(Snackbar snackbar) {
				// TODO Auto-generated method stub
				super.onShown(snackbar);
			}
		});
		snackbar.setActionTextColor(Color.RED);
		snackbar.show();

	}

}
