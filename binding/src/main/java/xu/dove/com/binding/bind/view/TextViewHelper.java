package xu.dove.com.binding.bind.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import xu.dove.com.binding.Utils;
import xu.dove.com.binding.bind.Observable;
import xu.dove.com.binding.bind.Transform;
import xu.dove.com.binding.bind.ViewAttrChangedListener;

/**
 * Created by flyer on 2018/4/12.
 */

public class TextViewHelper {


    public static void setListener(final TextView textView, final Transform<String,String> transform,
                                   final Observable bindObject, final String field,
                                   final ViewAttrChangedListener viewAttrChangedListener){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (transform == null){
                    viewAttrChangedListener.onViewAttrChanged(bindObject, field, textView, "" + s, "text");
                } else {
                    viewAttrChangedListener.onViewAttrChanged(bindObject, field, textView, transform.trans("" + s), "text");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static void update(TextView textView,Object value,String attrs){

        if (attrs.equals("text")){
            if (Utils.isEquals(String.valueOf(value),String.valueOf(textView.getText())))
                return;
            textView.setText(String.valueOf(value));
        }
    }
}
