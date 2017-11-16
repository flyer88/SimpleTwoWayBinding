package xu.dove.com.binding.bind;

/**
 * Created by flyer on 2017/11/16.
 * kvo 的实现
 * 如果有一个 Object 它的值变了，就会发出通知
 */
public interface ValueChangedListener {
    /**
     * 数据层修改监听
     * @param changedObject 修改的对象
     * @param changedValue 修改后属性的值
     * @param changedAttr 修改的属性名字
     */
    void onValueChanged(Object changedObject, Object changedValue,String changedAttr);
}
