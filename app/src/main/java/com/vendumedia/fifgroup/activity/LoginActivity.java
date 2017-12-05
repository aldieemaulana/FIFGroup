package com.vendumedia.fifgroup.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.vendumedia.fifgroup.App;
import com.vendumedia.fifgroup.R;
import com.vendumedia.fifgroup.api.Auth;
import com.vendumedia.fifgroup.model.Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_username_frame) TextInputLayout inputFrameUsername;
    @BindView(R.id.input_username) TextInputEditText inputEditUsername;
    @BindView(R.id.input_password_frame) TextInputLayout inputFramePassword;
    @BindView(R.id.input_password) TextInputEditText inputEditPassword;
    @BindView(R.id.loading_overlay) RelativeLayout loadingOverlay;

    @OnClick(R.id.submit_login)
    public void submitLogin(View view) {
        doLogin();
    }

    private void doLogin() {
        hideKeyboard();

        final String username = inputEditUsername.getText().toString();
        final String password = inputEditPassword.getText().toString();

        if(!username.isEmpty() && !password.isEmpty()) {
            Log.i("aldieemaulana", "aldieemaulana: " + username + "-" + password);
            loadingOverlay.setVisibility(View.VISIBLE);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(App.API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Auth service = retrofit.create(Auth.class);
            Call<Login> call = service.login(username, password);
            call.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    Log.i("aldieemaulana", "aldieemaulana: " + response.code());
                    Log.i("aldieemaulana", "aldieemaulana: " + call.request());

                    if (response.code() == 200) {
                        goToMain();
                    } else {
                        if(response.code() == 401)
                            Toast.makeText(LoginActivity.this, "Username atau Password Anda Tidak Valid.", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(LoginActivity.this, "Kendala Jaringan. Mohon cek jaringan anda, atau coba kembali beberapa saat lagi.”", Toast.LENGTH_LONG).show();
                    }

                    loadingOverlay.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Log.i("aldieemaulana", "aldieemaulana: " + t.getMessage());
                    Log.i("aldieemaulana", "aldieemaulana: " + call.request());

                    Toast.makeText(LoginActivity.this, "Kendala Jaringan. Mohon cek jaringan anda, atau coba kembali beberapa saat lagi.”", Toast.LENGTH_LONG).show();
                    loadingOverlay.setVisibility(View.GONE);
                }
            });


        }else{
            if (password.isEmpty() && !username.isEmpty()) {
                inputEditPassword.setError("This field is required");
                inputEditPassword.hasFocus();
            } else if (username.isEmpty() && !password.isEmpty()) {
                inputEditUsername.setError("This field is required");
                inputEditUsername.hasFocus();
            } else {
                inputEditUsername.setError("This field is required");
                inputEditUsername.hasFocus();
                inputEditPassword.setError("This field is required");
            }

            loadingOverlay.setVisibility(View.GONE);
        }

    }

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

    protected void goToMain() {
        Intent intent;
        intent = new Intent(LoginActivity.this, MainActivity.class);

        startActivity(intent);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        finish();
    }

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
            view.clearFocus();
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
