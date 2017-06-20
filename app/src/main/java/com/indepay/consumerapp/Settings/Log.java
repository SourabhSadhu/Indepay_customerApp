package com.indepay.consumerapp.Settings;

/**
 * Created by Sourabh on 6/20/2017.
 */

public class Log {
    private static boolean LOG = true;
    private String tag,message;
    Log(String tag, String message){
        this.tag = tag;
        this.message = message;
    }
    public static void i(String tag, String string) {
        if (LOG) android.util.Log.i(tag, string);
    }
    public static void e(String tag, String string) {
        if (LOG) android.util.Log.e(tag, string);
    }
    public static void d(String tag, String string) {
        if (LOG) android.util.Log.d(tag, string);
    }
    public static void v(String tag, String string) {
        if (LOG) android.util.Log.v(tag, string);
    }
    public static void w(String tag, String string) {
        if (LOG) android.util.Log.w(tag, string);
    }
}
