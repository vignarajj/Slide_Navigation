package com.ind.slidenavigation;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list= (ListView)findViewById(R.id.mainList);
		ListAdapter listAdapter = new ListAdapter(this, getList());
		list.setAdapter(listAdapter);
	}
	private ArrayList<ListItems> getList(){
		ArrayList<ListItems> arrayList = new ArrayList<ListItems>();
		arrayList.add(new ListItems("Demo"));
		arrayList.add(new ListItems("Code view"));
		arrayList.add(new ListItems("Info"));
		return arrayList;
	}
}
