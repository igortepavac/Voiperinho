package xyz.thedevspot.voiperinho.network;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RegisterRequest;

/**
 * Created by foi on 06/01/16.
 */
public interface VoiperinhoService {

    @POST("/user/insert")
    Call<BaseResponse<String>> userRegister(@Body RegisterRequest registerRequest);

    //@GET("/user/{id}/contacts")

}
