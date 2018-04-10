package xu.dove.com.binding;

import android.text.TextUtils;

/**
 * Created by flyer on 2017/11/16.
 * 用来判断两个 String 值是否相等
 */
public class Utils {

    public static boolean isEquals(String value1,String value2){
        if (TextUtils.isEmpty(value1) && TextUtils.isEmpty(value2)){
            return true;
        }
        if (TextUtils.isEmpty(value1) && !TextUtils.isEmpty(value2)){
            return false;
        }
        if (TextUtils.isEmpty(value2) && !TextUtils.isEmpty(value1)){
            return false;
        }
        return value1.equals(value2);
    }

    public static String captureString(String s){
        char[] cs = s.toCharArray();
        cs[0] -=32;
        return String.valueOf(cs);
    }
}
