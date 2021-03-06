package axhome.com.threesell.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import axhome.com.threesell.MainActivity;
import axhome.com.threesell.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.login_phone_et)
    EditText loginPhoneEt;
    @InjectView(R.id.login_pw_et)
    EditText loginPwEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.login_register_tv, R.id.login_btn, R.id.login_forget_tv, R.id.login_wx, R.id.login_qq, R.id.login_sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register_tv:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.login_btn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.login_forget_tv:
                break;
            case R.id.login_wx:
                break;
            case R.id.login_qq:
                break;
            case R.id.login_sina:
                break;
        }
    }
}
