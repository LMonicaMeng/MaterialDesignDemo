package com.demo.custombehavior;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.ricky.materialdesign.custombehavior.R;

public class MainActivity extends AppCompatActivity {

	private TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1 = (TextView)findViewById(R.id.tv1);
		tv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ViewCompat.offsetTopAndBottom(v, 9);
			}
		});
	}

}
