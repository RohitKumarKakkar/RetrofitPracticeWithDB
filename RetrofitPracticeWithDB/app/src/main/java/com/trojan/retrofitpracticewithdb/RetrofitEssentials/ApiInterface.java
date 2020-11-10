package com.trojan.retrofitpracticewithdb.RetrofitEssentials;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("insertdata.php")
    Call<ResponseBody> saveUserData(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("dob") String dob
    );

    @Headers({"Content-Type: text/plain; charset=UTF-8"})
    @GET("retriveData.php")
    Call<List<UserData>> getUserData();


    @FormUrlEncoded
    @POST("updatedata.php")
    Call<ResponseBody> updateUserData(
            @Field("id") String id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("dob") String dob
    );

    @FormUrlEncoded
    @POST("deletedata.php")
    Call<ResponseBody> deleteUserData(
            @Field("id") String id
    );
}
