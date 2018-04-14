package xu.dove.com.binding.bind;

import android.view.View;

import xu.dove.com.binding.bind.view.ViewListenerUtils;
import xu.dove.com.binding.bind.view.ViewUpdateUtils;

/**
 * Created by flyer on 2018/4/10.
 */

public class ActivityMainBinding<O extends Observable, V extends View> extends ViewDataBinding<O,V>{






    public ActivityMainBinding() {
        super();
    }

    @Override
    protected void handleModelFieldChanged(Observable changedObject, Object fieldValue,View view, String viewAttr,Transform transform) {
        Object value = fieldValue;
        if (transform == null) {

        } else {
            value = transform.trans(fieldValue);
        }
        ViewUpdateUtils.updateView(value,view,viewAttr);
    }

    @Override
    protected void listenViewAttrChanged(Observable bindObject, String modelField, View view,String viewAttr,Transform transform) {
    }

}
