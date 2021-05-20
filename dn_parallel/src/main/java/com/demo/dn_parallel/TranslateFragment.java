package com.demo.dn_parallel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TranslateFragment extends Fragment {
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		Bundle bundle = getArguments();
		int layoutId = bundle.getInt("layoutId");
		int pageIndex = bundle.getInt("pageIndex");
		
		View view = inflater.inflate(layoutId, null);
		view.setTag(pageIndex);
		return view;
	}

}
