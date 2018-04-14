package io.dove.binding.annotation;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by flyer on 2018/4/12.
 */

public @interface TwoWay {

    @LayoutRes int layout() default -1;

    /**
     * 控件类型
     * @return
     */
    @IdRes int widget();



    /**
     * 属性名字
     * @return
     */
    String attrs();


    /**
     * model 层对应的 field
     * @return
     */
    String field();
}
