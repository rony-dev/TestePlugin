package com.labofclouds.cordova.testePlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class TestePlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONObject args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("doAlert")) {
            String message = args.getString("message");
			this.alert(message, callbackContext);
			
            return true;
        }
		
        return false;
    }
	
	private void alert(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}