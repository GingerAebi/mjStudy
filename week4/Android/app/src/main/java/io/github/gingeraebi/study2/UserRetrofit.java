package io.github.gingeraebi.study2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public interface UserRetrofit {
    @POST("user")
    Call<APIResponse> registerUser(@Body User user);
}
