package com.demo.dn_parallel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ricky.d.welcompager2.ricky.R;

public class MainActivity extends FragmentActivity {

	private ViewPager vp;
	private int[] layouts = {
			R.layout.welcome11,
			R.layout.welcome2,
			R.layout.welcome3
//			R.layout.welcome1,
//			R.layout.welcome2,
//			R.layout.welcome3
	};
	private WelcompagerTransformer transformer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vp = (ViewPager)findViewById(R.id.vp);
		
		WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager());
		System.out.println("offset:"+vp.getOffscreenPageLimit());
		vp.setOffscreenPageLimit(3);
		vp.setAdapter(adapter);
		
		transformer = new WelcompagerTransformer();
		vp.setPageTransformer(true, transformer);
	
		vp.setOnPageChangeListener(transformer);
	}
	
	class WelcomePagerAdapter extends FragmentPagerAdapter {

		public WelcomePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment f = new TranslateFragment();
			Bundle bundle = new Bundle();
			bundle.putInt("layoutId", layouts[position]);
			bundle.putInt("pageIndex", position);
			f.setArguments(bundle );
			return f;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
		
		
		
	}
	

}
