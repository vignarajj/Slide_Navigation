package com.ind.slidenavigation;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FragmentList extends Activity{
	ListView listFragment;
protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fragment_list);
	listFragment= (ListView)findViewById(R.id.list_fragment);
	ListAdapter2 listAdapter2 = new ListAdapter2(this, getList());
	listFragment.setAdapter(listAdapter2);
}
private ArrayList<ListItems> getList(){
	ArrayList<ListItems> arrayList = new ArrayList<ListItems>();
	arrayList.add(new ListItems("Default Slide Navigation"));
	arrayList.add(new ListItems("Right to Left Navigation"));
	arrayList.add(new ListItems("Colored ListView"));
	arrayList.add(new ListItems("Numbers into Words"));
	return arrayList;
}
}
