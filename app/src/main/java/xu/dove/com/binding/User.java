package xu.dove.com.binding;

import xu.dove.com.binding.bind.IModelListener;
import xu.dove.com.binding.bind.ValueChangedListener;

/**
 * Created by flyer on 2017/11/16.
 * 数据层，该层中的代码可以完全脱离出去
 *
 * {@link User#setValueChangedListener(ValueChangedListener)}
 * {@link User#onValueChanged(Object, String)}
 * 以上两个方法，可以统一到一个 base 类中，用于
 *
 *
 * {@link User#update(Object, String)}
 * 该方法可以借助注解器进行代码插入
 *
 * {@link User#setName(String)}
 * 该方法的 onValueChanged() 调用也可以借助注解器进行插入
 * 可以生成下层代码
 * 也可以像 dataBinding 一样直接插入代码
 */
public class User implements IModelListener {
    protected String name;

    private ValueChangedListener mValueChangedListener;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        onValueChanged(this.name,"name");
    }

    private void onValueChanged(Object changedValue,String attr){
        if (mValueChangedListener != null) {
            this.mValueChangedListener.onValueChanged(this,changedValue,attr);
        }
    }

    public void setValueChangedListener(ValueChangedListener valueChangedListener){
        this.mValueChangedListener = valueChangedListener;
    }

    @Override
    public void update(Object value,String attrs) {
        if ("name".equals(attrs)){
            if (!Utils.isEquals(this.name, (String) value)) {
                setName((String) value);
            }
        }
    }
}
