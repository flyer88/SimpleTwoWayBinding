package xu.dove.com.binding.bind.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xu.dove.com.binding.bind.Observable;
import xu.dove.com.binding.bind.Transform;
import xu.dove.com.binding.bind.ViewAttrChangedListener;

/**
 * Created by flyer on 2018/4/10.
 */

public class ViewListenerUtils {


    public static void setAttrChangedListener(View view,
                                              String field,
                                              Observable bindObject,
                                              Transform transform,
                                              ViewAttrChangedListener viewAttrChangedListener){
        if (view instanceof TextView){
            TextViewHelper.setListener((TextView) view, transform ,bindObject, field ,viewAttrChangedListener);
        } else if (view instanceof ViewGroup){

        }

    }

}
