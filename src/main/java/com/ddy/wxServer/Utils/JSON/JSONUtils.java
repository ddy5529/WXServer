package com.ddy.wxServer.Utils.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
//    static private JSONObject OldjsonObject=new JSONObject();
//    static private JSONArray OldjsonArray=new JSONArray();
//    static public void setJSONObject(String name) throws JSONException {
//        OldjsonObject.put("name",name);
//    }
    static public String getJSONObjectToString(JSONObject jsonObject) throws JSONException {
        Object a= jsonObject.get("");
        return jsonObject.toString();
    }
}
