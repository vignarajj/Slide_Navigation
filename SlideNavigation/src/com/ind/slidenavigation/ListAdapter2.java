package com.ind.slidenavigation;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListAdapter2 extends ArrayAdapter<ListItems> {
	private final Context context;
	private final ArrayList<ListItems> arrayList;

	public ListAdapter2(Context context, ArrayList<ListItems> arrayList) {
		super(context, R.layout.row_text, arrayList);
		this.context = context;
		this.arrayList = arrayList;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View rowView;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.row_text, parent, false);
		} else {
			rowView = convertView;
		}
		LinearLayout linearLayout = (LinearLayout) rowView
				.findViewById(R.id.rows);
		TextView text = (TextView) rowView.findViewById(R.id.textView1);
		text.setText(arrayList.get(position).getText());
		linearLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (position == 0) {
					context.startActivity(new Intent(context, NavPager.class));
				} else if (position == 1) {
					context.startActivity(new Intent(context, NavPager2.class));
				} else if (position == 2) {
					context.startActivity(new Intent(context, ColoredList.class));
				} else if(position==3) {
					context.startActivity(new Intent(context, NumsToChar.class));
				}
			}
		});
		return rowView;
	}
}