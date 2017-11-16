package xu.dove.com.binding.bind;

/**
 * Created by flyer on 2017/11/16.
 * 数据层的接口
 * 用来更新属性值
 */
public interface IModelListener {
    /**
     * 更新数据层接口
     * @param value
     * @param attrs
     */
    void update(Object value,String attrs);

    /**
     * 设置接口修改监听器
     * @param valueChangedListener
     */
    void setValueChangedListener(ValueChangedListener valueChangedListener);
}
