package xu.dove.com.binding.bind;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import xu.dove.com.binding.Utils;

/**
 * Created by flyer on 2018/4/10.
 */

public class BaseObservable implements Observable {

    private PropertyChangedListener mPropertyChangedListener;


    @Override
    public void update(Object value, String attrs) {
        try {
            Field fieldAttrs = this.getClass().getDeclaredField(attrs);
            Class type = fieldAttrs.getType();
            Method method = this.getClass().getMethod("set" + Utils.captureString(attrs), type);
            method.invoke(this,value);
        } catch (NoSuchFieldException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPropertyChangedListener(PropertyChangedListener propertyChangedListener) {
        this.mPropertyChangedListener = propertyChangedListener;
    }

    @Override
    public void removePropertyChangedListener(PropertyChangedListener propertyChangedListener) {

    }

    public void onPropertyChanged(String attrsName,Object changedValue){
        mPropertyChangedListener.onPropertyChanged(this,changedValue,attrsName);
    }

}
