package com.ljb.summary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.ljb.summary.bean.TypeInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ljb
 * 时间：2016/11/26 on 12:55
 * 邮箱：563773219@qq.com
 * 描述：工具类
 */
public class Utils {

    private static Toast toast;

    public static void showToast(Context context, String msg) {

        if (TextUtils.isEmpty(msg)) {
            return;
        }

        if (null == toast) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }

        toast.show();
    }

    public static List<TypeInfo> getPageTypes(Context context, String pageName) {
        List<TypeInfo> typeInfos = new ArrayList<>();
        String jsonString = getConfigData(context);
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray(pageName);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    typeInfos.add(new TypeInfo(json.getString("type"), json.getString("name")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return typeInfos;
    }

    public static String getConfigData(Context context) {
        String data = "";
        InputStream in = null;
        try {
            in = context.getAssets().open("config.cfg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(buffer))) {
                baos.write(buffer, 0, len);
                baos.flush();
            }
            data = baos.toString("utf-8").trim();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
