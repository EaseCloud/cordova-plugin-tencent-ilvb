package cn.easecloud.cordova.tencent;

import android.Manifest;
import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class TencentILVB extends CordovaPlugin {

    private CordovaInterface cordova;
    private CordovaWebView webView;


    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
        this.cordova = cordova;
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action          The action to execute.
     * @param args            JSONArry of arguments for the plugin.
     * @param callbackContext The callback id used when calling back into JavaScript.
     * @return True if the action was valid, false if not.
     */
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

//        this.cordova.requestPermission(this, 0, Manifest.permission.READ_CONTACTS);

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "TencentILVB, " + name;

            Intent intent = new Intent(this.cordova.getActivity(), TestActivity.class);
            this.cordova.startActivityForResult(this, intent, 0);

            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
