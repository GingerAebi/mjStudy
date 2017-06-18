package io.github.gingeraebi.study2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public class RetrofitBase {

    private static RetrofitBase retrofitBase;
    private static Retrofit retrofit;

    private RetrofitBase() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://52.78.159.87:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitBase getInstance() {
        if (retrofitBase == null) {
            retrofitBase = new RetrofitBase();
            return retrofitBase;
        }

        return retrofitBase;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
