package org.sifacai.vlcxwjellyfin;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {

    public static class DeviceType {
        public final static int UNKNOWN = 0;
        public final static int TV = 1;
        public final static int MOBILE = 2;
    }

    public static int getDeviceType(Context context){
        SharedPreferences sp = context.getSharedPreferences("VlcXWJellyfin",Context.MODE_PRIVATE);
        return sp.getInt("DeviceType",0);
    }

    public static void setDeviceType(Context context,int type){
        SharedPreferences sp = context.getSharedPreferences("VlcXWJellyfin",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("DeviceType",type);
        editor.commit();
    }

}
