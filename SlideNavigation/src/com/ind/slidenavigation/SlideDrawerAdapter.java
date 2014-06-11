package com.ind.slidenavigation;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SlideDrawerAdapter  extends BaseAdapter {
	
	private Context context;
	private ArrayList<SlideDrawerItem> slideDrawerItems;
	
	public SlideDrawerAdapter(Context context, ArrayList<SlideDrawerItem> slideDrawerItems){
		this.context = context;
		this.slideDrawerItems = slideDrawerItems;
	}

	@Override
	public int getCount() {
		return slideDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return slideDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item,null);
        }
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);       
        txtTitle.setText(slideDrawerItems.get(position).getTitle());
        return convertView;
	}

}
