package xu.dove.com.binding.bind;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import xu.dove.com.binding.Utils;

/**
 * Created by flyer on 2017/11/16.
 * 绑定工具
 */
public class BindUtils {

    public static void updateView(Object value, View view,String attr){
        if (view instanceof TextView){
            if (!Utils.isEquals(String.valueOf(((TextView) view).getText()),(String) value)){
                ((TextView) view).setText((String) value);
            }
        } else if (view instanceof EditText){
            if (!Utils.isEquals(String.valueOf(((TextView) view).getText()),(String) value)){
                ((TextView) view).setText((String) value);
            }
        }
    }

    public static void listenView(final IModelListener bindObject, final String bindAttr, View view){
        if (view instanceof TextView){
            ((TextView) view).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindObject.update(s == null ? "" : s.toString(),bindAttr);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        } else if (view instanceof EditText){
            ((TextView) view).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindObject.update(s == null ? "" :s.toString(),bindAttr);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
