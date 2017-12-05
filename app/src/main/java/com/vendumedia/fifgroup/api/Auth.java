package com.vendumedia.fifgroup.api;

import com.vendumedia.fifgroup.model.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aldimaulana on 12/6/17.
 */

public interface Auth {

    @FormUrlEncoded
    @POST("/login")
    Call<Login> login(@Field("username") String username, @Field("password") String password);

}
