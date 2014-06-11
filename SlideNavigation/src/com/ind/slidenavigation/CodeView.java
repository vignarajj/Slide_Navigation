package com.ind.slidenavigation;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CodeView extends Activity{
	TextView hint1, hint2, hint3, code1, code2, code3;
protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_codeview);
	Typeface type = Typeface.createFromAsset(getAssets(),"fonts/consolas.ttf");
	hint1= (TextView)findViewById(R.id.h1);
	hint2= (TextView)findViewById(R.id.h2);
	hint3= (TextView)findViewById(R.id.h3);
	code1= (TextView)findViewById(R.id.ch1);
	code2= (TextView)findViewById(R.id.ch2);
	code3= (TextView)findViewById(R.id.ch3);
	hint1.setTypeface(type);
	hint2.setTypeface(type);
	hint3.setTypeface(type);
	code1.setTypeface(type);
	code2.setTypeface(type);
	code3.setTypeface(type);
}
}
