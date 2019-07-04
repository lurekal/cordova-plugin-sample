package com.test.myplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class myPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {


        // plugin.xml에 맵핑되어있는 action과 JavaScript Interface에서 전달받는 action이 동일할 때 수행한다
        if (action.equals("echo")) {
            // JavaScript Interface에서 전달받은 매개변수를 받아 저장한다
            String message = args.getString(0);

            // JavaScript Interface로 보낼 Callback 함수
            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Echo Fail");
            }
            return true;
        }
        return false;
    }

}
