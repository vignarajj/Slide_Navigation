package com.ind.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ind.slidenavigation.R;

public class Page2  extends Fragment{
	public Page2(){
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	    View rootView = inflater.inflate(R.layout.page2, container, false);    
	    return rootView;
	}
}