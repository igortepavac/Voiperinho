package xyz.thedevspot.voiperinho.network;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.models.RequestInformation;
import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 06/01/16.
 */
public interface ApiService {

    @POST("/user/insert")
    Call<BaseResponse<String>> userRegister(@Body RegisterRequest registerRequest);

    @GET("/user/{id}/contacts")
    Call<BaseResponse<List<User>>> getContacts(@Path("id") int userId);

    @GET("user/{id}/requests")
    Call<BaseResponse<List<RequestInformation>>> getRequests(@Path("id") int userId);

}
