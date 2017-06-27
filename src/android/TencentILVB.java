package cn.easecloud.cordova.tencent;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONTokener;

import com.tencent.ilivesdk.*;
import com.tencent.ilivesdk.core.*;

public class TencentILVB extends CordovaPlugin {

    private Context context;
    private Activity activity;
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
        this.activity = cordova.getActivity();
        this.context = this.activity.getApplicationContext();
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
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {

//        this.cordova.requestPermission(this, 0, Manifest.permission.READ_CONTACTS);

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "TencentILVB, " + name;

            Intent intent = new Intent(this.cordova.getActivity(), TestActivity.class);
            this.cordova.startActivityForResult(this, intent, 0);

            callbackContext.success(message);

            return true;

        } else if (action.equals("initSdk")) {

            int appid = data.getInt(0);
            int accountType = data.getInt(1);
            ILiveSDK.getInstance().initSdk(this.context, appid, accountType);
            return true;

        } else if (action.equals("iLiveLogin")) {

            String id = data.getString(0);
            String sig = data.getString(1);
            ILiveLoginManager.getInstance().iLiveLogin(id, sig, new ILiveCallBack() {
                @Override
                public void onSuccess(Object data) {
                    JSONObject json = null;
                    try {
                        // object to JSONObject
                        // https://stackoverflow.com/a/33056323/2544762
                        json = (JSONObject) (new JSONTokener(data.toString()).nextValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackContext.error("JSON parse object fail: " + data.toString());
                    }
                    callbackContext.success(json);
                }

                @Override
                public void onError(String module, int errCode, String errMsg) {
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("module", module);
                        obj.put("errCode", errCode);
                        obj.put("errMsg", errMsg);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackContext.error("ERROR: " + errMsg);
                    }
                    callbackContext.error(obj);
                }
            });
            return true;

        } else if (action.equals("iLiveLogout")) {
            return false;
        } else if (action.equals("createRoom")) {
            return false;
        } else if (action.equals("joinRoom")) {
            return false;
        } else {
            return false;
        }
    }

}
