package com.ind.slidenavigation;

import java.util.ArrayList;
import com.ind.fragments.Page1;
import com.ind.fragments.Page2;
import com.ind.fragments.Page3;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NavPager extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// NavigationDrawer title
	private CharSequence mDrawerTitle;

	// App title "Navigation Drawer"
	private CharSequence mTitle;

	// slider menu items details
	private String[] navMenuTitles;
	// private TypedArray navMenuIcons;

	private ArrayList<SlideDrawerItem> slideDrawerItems;
	private SlideDrawerAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_drawer);
		mTitle = mDrawerTitle = getTitle();

		// getting items of slider from array
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		slideDrawerItems = new ArrayList<SlideDrawerItem>();

		// navDrawerItems.add(new NavDrawerItem(navMenuTitles[0],
		// navMenuIcons.getResourceId(0, -1)));
		// list item in slider at 1 Home
		slideDrawerItems.add(new SlideDrawerItem(navMenuTitles[0]));
		slideDrawerItems.add(new SlideDrawerItem(navMenuTitles[1]));
		slideDrawerItems.add(new SlideDrawerItem(navMenuTitles[2]));

		// Recycle array
		// navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting list adapter for Navigation Drawer
		adapter = new SlideDrawerAdapter(getApplicationContext(),
				slideDrawerItems);
		mDrawerList.setAdapter(adapter);

		// Enable action bar icon_luncher as toggle Home Button
		getActionBar().setBackgroundDrawable(new ColorDrawable(0xff333333));
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		// getActionBar().setIcon(R.drawable.logo);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // Setting, Refresh and Rate App
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}

		};
		mDrawerToggle.setDrawerIndicatorEnabled(true);
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			displayView(0);
		}

	}

	/**
	 * Slider menu item click listener
	 * */
	public class SlideMenuClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// title/icon
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	// called when invalidateOptionsMenu() invoke

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if Navigation drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	private void displayView(int position) {
		// update the main content with called Fragment
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new Page1();
			break;
		case 1:
			fragment = new Page2();
			break;
		case 2:
			fragment = new Page3();
			break;
		default:
			// fragment = new HomeFragment();
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {

			Log.e("this is mainActivity", "Error in else case");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
