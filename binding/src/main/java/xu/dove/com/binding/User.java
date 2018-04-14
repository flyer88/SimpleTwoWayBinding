package xu.dove.com.binding;

import io.dove.binding.annotation.BindableField;
import xu.dove.com.binding.bind.BaseObservable;

/**
 * Created by flyer on 2018/4/10.
 */

public class User extends BaseObservable{

    @BindableField
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        onPropertyChanged("name");
    }
}