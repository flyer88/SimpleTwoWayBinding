package xu.dove.com.binding.bind;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by flyer on 2017/11/16.
 * 控件和 Model 的 Attribute 进行绑定的核心层
 */
public class ViewModel<O extends IModelListener> {


    private O bindObject;
    private HashMap<String,List<View>> bindViewMap = new HashMap<>();

    public ViewModel(O bindObject){
        this.bindObject = bindObject;
        bindObject.setValueChangedListener(new ValueChangedListener() {
            @Override
            public void onValueChanged(Object changedObject, Object changedValue, String changedAttr) {
                List<View> views = bindViewMap.get(changedAttr);
                for (View view : views) {
                    BindUtils.updateView(changedValue,view,changedAttr);
                }
            }
        });
    }

    public void bind(View view, String attr){
        boolean hasPut = bindViewMap.containsKey(attr);
        if (hasPut) {
            List<View> views = bindViewMap.get(attr);
            views.add(view);
        } else {
            List<View> views = new ArrayList();
            views.add(view);
            bindViewMap.put(attr,views);
        }
        BindUtils.listenView(bindObject,attr,view);
    }

}
