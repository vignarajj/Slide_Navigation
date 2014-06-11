package com.ind.slidenavigation;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorAdapter extends ArrayAdapter<ListItems> {
	private final Context context;
	private final ArrayList<ListItems> arrayList;
	private int[] drawablecol={R.color.color_1, R.color.color_2, R.color.color_3,
			R.color.color_4, R.color.color_5};
	
	public ColorAdapter(Context context, ArrayList<ListItems> arrayList) {
		super(context, R.layout.row_text, arrayList);
		this.context = context;
		this.arrayList = arrayList;
	}
	public View getView(final int position, View convertView, ViewGroup parent) {
		View rowView;
		if(convertView==null)
		{
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rowView = inflater.inflate(R.layout.row_text, parent, false);
		}
		else
		{
			rowView=convertView;
		}
		LinearLayout linearLayout = (LinearLayout)rowView.findViewById(R.id.rows);
		TextView text= (TextView)rowView.findViewById(R.id.textView1);
		text.setTextColor(context.getResources().getColor(drawablecol[position]));
		text.setText(arrayList.get(position).getText());
		return rowView;
	}
}
