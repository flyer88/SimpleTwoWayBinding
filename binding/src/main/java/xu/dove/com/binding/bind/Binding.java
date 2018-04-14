package xu.dove.com.binding.bind;

/**
 * Created by flyer on 2018/4/12.
 */

public interface Binding<A,B> {

    /**
     * 单向绑定
     * {@param a} 中的 {@param aField} 对应值的改变，会导致 {@param b} 中的 {@param bField} 对应值的改变
     * 其中 {@param aField} 和 {@param bField} 对应的值是相等的
     * @param a
     * @param aField
     * @param b
     * @param bField
     */
    void oneWay(A a, String aField, B b, String bField);


    /**
     * 该函数主要因为 JVM 的类型擦除导致
     * 无法进行 {@link Binding#oneWay(Object, String, Object, String, Transform)}
     * B -> A 的绑定所导致
     * @param a
     * @param aField
     * @param b
     * @param bField
     */
    void oneWay(A a, String aField, B b, String bField, boolean inverse);

    /**
     * 单向绑定
     * 其中 {@param aField} 和 {@param bField} 对应的值是不相等的
     * {@param bField} = {@link Transform#trans(Object)}
     * @param a
     * @param aField
     * @param b
     * @param bField
     * @param a2b
     */
    <FieldA,FieldB> void oneWay(A a, String aField, B b, String bField, Transform<FieldA,FieldB> a2b);

    /**
     * 该函数主要因为 JVM 的类型擦除导致
     * 无法进行 {@link Binding#oneWay(Object, String, Object, String, Transform)}
     * B -> A 的绑定所导致
     * @param a
     * @param aField
     * @param b
     * @param bField
     * @param a2b
     * @param inverse 是否将转换函数改成 B -> A 倒过来
     */
    <FieldA,FieldB> void oneWay(A a, String aField, B b, String bField, Transform<FieldA,FieldB> a2b, boolean inverse);


    /**
     * 直接绑定，没有转换
     * @param a
     * @param aField
     * @param b
     * @param bField
     */
    void twoWay(A a, String aField, B b, String bField);

    /**
     * A -> B 有转换
     * B -> A 也有转换
     * @param a
     * @param aField
     * @param b
     * @param bField
     * @param a2b
     * @param b2a
     */
    <FieldA,FieldB> void twoWay(A a, String aField, B b, String bField, Transform<FieldA,FieldB> a2b, Transform<FieldB,FieldA> b2a);
}
