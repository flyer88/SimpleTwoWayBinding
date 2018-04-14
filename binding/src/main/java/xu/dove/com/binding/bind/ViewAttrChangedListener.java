package xu.dove.com.binding.bind;

import android.view.View;

/**
 * Created by flyer on 2018/4/10.
 */

public interface ViewAttrChangedListener {
    void onViewAttrChanged(Observable bindObject,String field,View view, Object changedValue, String changedAttr);
}
