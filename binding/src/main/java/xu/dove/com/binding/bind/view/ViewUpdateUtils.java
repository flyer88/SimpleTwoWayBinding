package xu.dove.com.binding.bind.view;

import android.view.View;
import android.widget.TextView;

/**
 * Created by flyer on 2017/11/16.
 * 绑定工具
 */
public class ViewUpdateUtils {

    public static void updateView(Object value, View view,String attr){

        if (view instanceof TextView){
            TextViewHelper.update((TextView) view,value,attr);
        }
    }
}
