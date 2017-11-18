package com.vendumedia.fifgroup.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vendumedia.fifgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_username_frame) TextInputLayout inputFrameUsername;
    @BindView(R.id.input_username) TextInputEditText inputEditUsername;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        
    }

    @OnClick(R.id.submit_login)
    protected void actionLogin() {
        Intent intent;
        intent = new Intent(LoginActivity.this, MainActivity.class);

        startActivity(intent);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        finish();
    }
}
