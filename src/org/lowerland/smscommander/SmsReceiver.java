package org.lowerland.smscommander;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class SmsReceiver extends BroadcastReceiver {
	static final String TAG = "SmsReceiver";
	MediaPlayer mpSplash;
	
@Override
public void onReceive(Context context, Intent intent) {
	// for later use
	// String strMagicWord = getResources().getString(R.string.sms_magicword);
	
       Bundle extras = intent.getExtras();
       if (extras == null)
       return;      
                
       Object[] pdus = (Object[]) extras.get("pdus");
       for (int i = 0; i < pdus.length; i++) {
          SmsMessage SMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
          String sender = SMessage.getOriginatingAddress();
          String body = SMessage.getMessageBody().toString();
          
          
			  // sms body txt compares to our secret text string :)
          
        	  if(body.compareTo("Pussylover") == 0)
        	  {
        		  
        	      // Strings match! (This code will execute)
        		  // To display a Toast when there is an SMS with our secret text.
        		  Toast.makeText(context,"PREPARE FOR ULTIMATE TROLLING !! :D",Toast.LENGTH_LONG).show();
        			// play sound
        			mpSplash = MediaPlayer.create(context, R.raw.test_cbr);
        			mpSplash.start();
        			//
        		  
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