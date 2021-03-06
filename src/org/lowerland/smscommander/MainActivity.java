package org.lowerland.smscommander;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements OnSharedPreferenceChangeListener {
	static final String TAG = "MainActivity";
	
	// this will make prefs shared with the rest of our application
	SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		String magicword = prefs.getString("magicword", "");
		String sound = prefs.getString("sound", "script_check");
		
		prefs.registerOnSharedPreferenceChangeListener(this);
		
		Log.d(TAG, "onCreated"+magicword +sound);
}

	public void onClick(View v) {
		startActivity(new Intent(this, PrefsActivity.class));
		Log.d(TAG, "Settings button clicked");
	}
	
	// Menu Stuff
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.item_prefs:
			startActivity(new Intent(this, PrefsActivity.class));
			return true;
		default:
			return false;
		}
	}
	
	@Override
	// when prefs are changed this will be called
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		Log.d(TAG, "pref changed for key: "+key);
	}
}
