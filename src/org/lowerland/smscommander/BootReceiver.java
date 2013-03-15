package org.lowerland.smscommander;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// For later use ;)
		Log.d("BootReceiver", "onReceived BootReceiver");
	}

}
