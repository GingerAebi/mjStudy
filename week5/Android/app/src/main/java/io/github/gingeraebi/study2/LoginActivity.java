package io.github.gingeraebi.study2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private UserRetrofit userRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = RetrofitBase.getInstance().getRetrofit();
        userRetrofit = retrofit.create(UserRetrofit.class);

        Button button = (Button) findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLoginRequest();
            }
        });
    }

    private void sendLoginRequest() {
        EditText idEdit = (EditText) findViewById(R.id.idEdit);
        EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        User user = new User(idEdit.getText().toString(), passwordEdit.getText().toString());

        Call<APIResponse> call = userRetrofit.loginUser(user);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.isSuccessful() && response.body().rspCode.equals("200")) {
                    startMainActivity();
                } else if (response.isSuccessful() && response.body().rspCode.equals("401")) {
                    Toast.makeText(LoginActivity.this, response.body().rspMsg, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "api 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                Toast.makeText(LoginActivity.this, "API call FAIL", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendRegisterRequest() {

        EditText idEdit = (EditText) findViewById(R.id.idEdit);
        EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        User user = new User(idEdit.getText().toString(), passwordEdit.getText().toString());

        Call<APIResponse> call = userRetrofit.registerUser(user);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                Log.i("Login Result", response.body().toString());
                startMainActivity();
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                Toast.makeText(LoginActivity.this, "API call FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
