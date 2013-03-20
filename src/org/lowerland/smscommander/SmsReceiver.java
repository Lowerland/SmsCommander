package org.lowerland.smscommander;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class SmsReceiver extends BroadcastReceiver {
	static final String TAG = "SmsReceiver";
	MediaPlayer mpSplash;
	
@Override
public void onReceive(Context context, Intent intent) {
	
	// gets the shared prefs
	SharedPreferences prefs = PreferenceManager
			.getDefaultSharedPreferences(context);
	
	// gets our preference for our magicword
	String magicword = prefs.getString("magicword", "");
	String sound = prefs.getString("sound", "");
	String script_check = "script_check";
	String homer_nacho_man = "homer_nacho_man";
	String whohaha = "whohaha";
	String goddammit = "goddammit";
	String dog = "dog";
	String donkey = "donkey";
	String orgasm = "orgasm";
	String orgasm2 = "orgasm2";
	
	
	
       Bundle extras = intent.getExtras();
       if (extras == null)
       return;      
                
       Object[] pdus = (Object[]) extras.get("pdus");
       for (int i = 0; i < pdus.length; i++) {
          SmsMessage SMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
          String sender = SMessage.getOriginatingAddress();
          String body = SMessage.getMessageBody().toString();
          
			  // sms body txt compares to our secret text string :)
          
        	  if(body.compareTo(magicword) == 0)
        	  {
       		  
        	      // Strings match! (This code will execute)
        		  // To display a Toast when there is an SMS with our secret text.
        		  Toast.makeText(context,"PREPARE FOR ULTIMATE TROLLING !! :D",Toast.LENGTH_LONG).show();
        		  Toast.makeText(context,sound,Toast.LENGTH_LONG).show();            		  
        		  //Sound check
        		  if(sound.compareTo(script_check) == 0) {
          			// play sound
            		  mpSplash = MediaPlayer.create(context, R.raw.script_check);
            		  mpSplash.start();
        		  }
        		  if(sound.compareTo(homer_nacho_man) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.homer_nacho_man);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(whohaha) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.whohaha);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(goddammit) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.goddammit);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(dog) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.dog);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(donkey) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.donkey);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(orgasm) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.orgasm);
              		  mpSplash.start();
          		  }
        		  if(sound.compareTo(orgasm2) == 0) {
              		  mpSplash = MediaPlayer.create(context, R.raw.orgasm2);
              		  mpSplash.start();
          		  }

        		  
        	  } else {
        		  
        	      // Strings don’t match!
        		  // To display a Toast even if it is not the good text.
        		  Toast.makeText(context,sender+":"+body,Toast.LENGTH_LONG).show();
        		  
        	  } 			                    
        	  
         // A custom Intent that will used as another Broadcast
         Intent in = new Intent("SmsMessage.intent.MAIN").
         putExtra("get_msg", sender+":"+body);

         //You can place your check conditions here(on the SMS or the sender)            
         //and then send another broadcast 
         context.sendBroadcast(in);

        // This is used to abort the broadcast and can be used to silently drop the
        // sms process incoming message and prevent it from further being broadcasted.
        // so system wont even know there was an sms if we use the this.abortBroadcast
         
        // Avoid this, as this is not the way to program an app.
           // WARNING WARNING WARNING
         		this.abortBroadcast();  // WARNING WARNING WARNING
           // WARNING WARNING WARNING
        // Avoid this, as this is not the way to program an app.
        
        }
     }
 }