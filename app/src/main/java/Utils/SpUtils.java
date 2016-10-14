package Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by clark on 2016/10/14.
 */

public class SpUtils {
    private static SharedPreferences sp;

    /**
     *
     * @param context
     * @param key 存储节点名称
     * @param value 存储节点的值 boolean
     */
    public static void putBoolean(Context context,String key,boolean value){
        if (sp == null){
            sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key,value).commit();
    }

    /**
     *
     * @param context
     * @param key 存储节点名称
     * @param defValue 存储节点得默认值
     * @return
     */
    public static boolean getBoolean(Context context,String key,boolean defValue){
        if (sp == null){
            sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key,defValue);
    }
}
