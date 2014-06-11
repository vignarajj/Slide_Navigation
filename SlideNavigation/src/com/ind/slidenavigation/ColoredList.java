package com.ind.slidenavigation;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ColoredList extends Activity{
	ListView colorList;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colored_list);
		colorList= (ListView)findViewById(R.id.colorList);
		ColorAdapter adapter= new ColorAdapter(this, getList());
		colorList.setAdapter(adapter);
	}
	public ArrayList<ListItems> getList(){
		ArrayList<ListItems> colors= new ArrayList<ListItems>();
		colors.add(new ListItems("Red"));
		colors.add(new ListItems("Violet"));
		colors.add(new ListItems("Green"));
		colors.add(new ListItems("Blue"));
		colors.add(new ListItems("Orange"));
		return colors;
	}
}