package xu.dove.com.binding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import xu.dove.com.binding.bind.ViewDataBinding;


public class MainActivity extends AppCompatActivity{


    TextView nameTv;
    EditText setNameEt;
    ViewDataBinding<User, View> mMainBinding;
    User mUser2 = new User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTv = findViewById(R.id.name_tv);
        setNameEt = findViewById(R.id.set_name_et);
        mMainBinding = new ViewDataBinding<User, View>();

        mMainBinding.oneWay(mUser2,"name", nameTv,"text");
//        mMainBinding.oneWay(mUser2,"name", setNameEt,"text");
//
//        mMainBinding.oneWay(mUser2,"name", nameTv,"text",true);
//
//        mMainBinding.oneWay( mUser2, "name", setNameEt, "text",
//                new Transform<String, String>() {
//                        @Override
//                        public String trans(String s) {
//                            return s + "2333";
//                        }
//                    }
//                );
//
//        mMainBinding.oneWay( mUser2, "name", setNameEt, "text",
//                new Transform<String, String>() {
//                    @Override
//                    public String trans(String s) {
//                        return s + "2333";
//                    }
//
//                }, true);
        mMainBinding.twoWay(mUser2, "name", setNameEt, "text");
//        mMainBinding.twoWay(mUser2, "name", setNameEt, "text",
//                new Transform<String, String>() {
//                    @Override
//                    public String trans(String s) {
//                        if (Utils.isEquals(s,"dove"))
//                            return "白言午";
//                        else return s;
//                    }
//                },
//                new Transform<String, String>() {
//                    @Override
//                    public String trans(String s) {
//                        if (Utils.isEquals(s,"白言午"))
//                            return "dove";
//                        else return s;
//                    }
//                }
//        );
        mUser2.setName("dove");
    }


}
