# 一个简单的双向绑定 Demo
    没有任何第三方框架插入，纯 DEMO，如果需要成型的库，DataBinding 是一个不错的选择

# 原理
    核心原理是观察者模式

### Model 层：
+ User 类的 set 方法调用时发出通知
+ 遍历 User 类属性，更新对应属性

### ViewModel 层

+ 监听 View 修改，调用 User 类的 update 方法，更新 Model

+ 监听 Model 层修改，调用 IModelListener.setValueChangedListener() 方法，进行监听，在回调中，获取修改属性所对应控件 List，更新所有控件