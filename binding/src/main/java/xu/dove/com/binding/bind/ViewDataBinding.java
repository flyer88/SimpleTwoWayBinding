package xu.dove.com.binding.bind;

import android.text.TextUtils;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;

import xu.dove.com.binding.bind.view.ViewListenerUtils;
import xu.dove.com.binding.bind.view.ViewUpdateUtils;

/**
 * Created by flyer on 2017/11/16.
 * 控件和 Model 的 Attribute 进行绑定的核心层
 */
public class ViewDataBinding<O extends Observable, V extends View> implements Binding<O,V>{


//    protected HashMap<Class<? extends View>,BindAttrAndField> bindViewMap = new HashMap<Class<? extends View>, BindAttrAndField>();
//    protected HashMap<Class<? extends Observable>,List<View>> bindObjectMap = new HashMap<Class<? extends Observable>,List<View>>();

    private ViewAttrChangedListener mTextAndroidTextAttrChangedListener = new ViewAttrChangedListener() {
        @Override
        public void onViewAttrChanged(Observable bindObject, String field,View view, Object changedValue, String changedAttr) {
            bindObject.update(changedValue, field);
        }
    };

    public ViewDataBinding(){

    }

    @Override
    public void oneWay(O bindObject, String modelField,
                       V view, String viewAttr){
        oneWay(bindObject,modelField,view, viewAttr,false);
    }

    @Override
    public void oneWay(O bindObject, String modelField,
                       V view, String viewAttr, boolean inverse) {
        oneWay(bindObject,modelField,view, viewAttr,null);
    }


    @Override
    public <FieldA, FieldB> void oneWay(O bindObject, String modelField,
                                        V view, String viewAttr,
                                        Transform<FieldA, FieldB> m2v) {
        oneWay(bindObject, modelField, view, viewAttr, m2v,false);
    }

    @Override
    public <FieldA, FieldB> void oneWay(O bindObject, String modelField,
                                        final V view, final String viewAttr,
                                        final Transform<FieldA, FieldB> m2v, boolean inverse) {
        if (view == null
                || bindObject == null
                || TextUtils.isEmpty(viewAttr)
                || TextUtils.isEmpty(modelField))
            return;

        if (inverse){
            // view 的监听
            listenViewAttrChanged(bindObject,modelField,view,viewAttr,m2v);
        } else {
            // model 的监听
            bindObject.addPropertyChangedListener(new PropertyChangedListener() {
                @Override
                public void onPropertyChanged(Observable changedObject, Object changedValue, String changedField) {
                    handleModelFieldChanged(changedObject, changedValue, view, viewAttr, m2v);
                }
            });
        }
//        if (inverse) {
//            twoWay(bindObject, modelField, view, viewAttr, null,v2m);
//        } else {
//            twoWay(bindObject, modelField, view, viewAttr,  v2m,null);
//        }
    }

    @Override
    public void twoWay(O bindObject, String modelField, V view, String viewAttr) {
        twoWay(bindObject,modelField,view, viewAttr,null,null);
    }

    @Override
    public <FieldA, FieldB> void twoWay(O bindObject, String modelField, final V view, final String viewAttr, final Transform<FieldA, FieldB> m2v, Transform<FieldB, FieldA> v2m) {
        if (view == null
                || bindObject == null
                || TextUtils.isEmpty(viewAttr)
                || TextUtils.isEmpty(modelField))
            return;
        // model 的监听
        bindObject.addPropertyChangedListener(new PropertyChangedListener() {
            @Override
            public void onPropertyChanged(Observable changedObject, Object changedValue, String changedField) {
                handleModelFieldChanged(changedObject,changedValue,view,viewAttr,m2v);
            }
        });
        // 控件的监听
        listenViewAttrChanged(bindObject,modelField,view,viewAttr,v2m);
    }


    /**
     * model 层修改，通知 view 更新
     * @param changedObject
     * @param changedValue
     * @param viewAttr
     */
    protected void handleModelFieldChanged(Observable changedObject, Object changedValue,
                                           View view, String viewAttr,
                                           Transform transform){
        Object value = changedValue;
        if (transform == null) {

        } else {
            value = transform.trans(changedValue);
        }
        ViewUpdateUtils.updateView(value,view,viewAttr);
    }

    /**
     * 控件层数据改动，通知 model 层更新
     * @param bindObject
     * @param viewAttr
     * @param view
     */
    protected void listenViewAttrChanged(Observable bindObject, String modelField,
                                         View view, String viewAttr,
                                         Transform transform){
        ViewListenerUtils.setAttrChangedListener(view,modelField,bindObject,transform,mTextAndroidTextAttrChangedListener);
    }


    public class BindAttrAndField{
        private String viewAttr;
        private String modelField;

        public String getViewAttr() {
            return viewAttr;
        }

        public void setViewAttr(String viewAttr) {
            this.viewAttr = viewAttr;
        }

        public String getModelField() {
            return modelField;
        }

        public void setModelField(String modelField) {
            this.modelField = modelField;
        }
    }

}
