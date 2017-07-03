package com.twilio.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.content.Intent;
import android.net.Uri;

/**
 * This class echoes a string called from JavaScript.
 */
public class Twilio extends CordovaPlugin {
    
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final String TAG = "Twilio";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            String message = args.getString(0);
            Log.v(TAG, "Twilio here");
            this.echo(message, callbackContext);
            return true;
        }
        if (action.equals("call")) {
            String message = args.getString(0);
            this.call(message, callbackContext);
            return true;
        }
        return false;
    }

    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void call(String phone, CallbackContext callbackContext) {
        if (phone != null && phone.length() > 0) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phone));
            cordova.getActivity().startActivity(callIntent);
        } else {
            callbackContext.error("Empty Phone.");
        }
    }

    private void makeTheCall(String phone) {
        
    }
}
