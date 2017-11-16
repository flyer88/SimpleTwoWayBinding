package xu.dove.com.binding;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import xu.dove.com.binding.bind.ViewModel;

public class MainActivity extends AppCompatActivity{


    User mUser = new User();
    TextView nameTv;
    EditText setNameEt;
    ViewModel<User> mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTv = findViewById(R.id.name_tv);
        setNameEt = findViewById(R.id.set_name_et);
        mViewModel = new ViewModel<>(mUser);
        mViewModel.bind(nameTv,"name");
        mViewModel.bind(setNameEt,"name");
        mUser.setName("dove");
    }


}
