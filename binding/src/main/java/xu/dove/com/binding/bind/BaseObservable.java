package xu.dove.com.binding.bind;

import android.util.SparseArray;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import xu.dove.com.binding.Utils;

/**
 * Created by flyer on 2018/4/10.
 */

public class BaseObservable implements Observable {

    private SparseArray<PropertyChangedListener> mPropertyChangedListeners = new SparseArray<>();


    @Override
    public void update(Object value, String field) {
        Object originValue = getValue(field);
        if (value == null){
            if (originValue == null){
                return;
            }
        } else {
            if (value.equals(originValue)){
                return;
            }
        }
        setValue(field,value);
    }

    @Override
    public void addPropertyChangedListener(PropertyChangedListener propertyChangedListener) {
        this.mPropertyChangedListeners.append(mPropertyChangedListeners.size(),propertyChangedListener);
    }

    @Override
    public void removePropertyChangedListener(PropertyChangedListener propertyChangedListener) {


    }
    public void onPropertyChanged(String fieldName){
        Object value = getValue(fieldName);
        for (int i = 0 ;i< mPropertyChangedListeners.size() ;i++) {
            mPropertyChangedListeners.get(i).onPropertyChanged(this,value,fieldName);
        }
    }


    private Object getValue(String fieldName){
        try {
            Method method = this.getClass().getMethod("get" + Utils.captureString(fieldName));
            return method.invoke(this);
        } catch (IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setValue(String fieldName,Object value){
        try {
            Field fieldAttrs = this.getClass().getDeclaredField(fieldName);
            Class type = fieldAttrs.getType();
            Method method = this.getClass().getMethod("set" + Utils.captureString(fieldName), type);
            method.invoke(this,value);
        } catch (NoSuchFieldException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
