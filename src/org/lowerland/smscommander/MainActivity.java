package org.lowerland.smscommander;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// Also for later use :)
	
	/*	
	public void activateListener(View v) {
		Log.d(TAG, "onclick activateListener happend");
	}
	
	public void deactivateListener(View v) {
		Log.d(TAG, "onclick deactivateListener happend");
	}
*/
}
