package xyz.thedevspot.voiperinho.network;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.models.RegisterResponse;

/**
 * Created by foi on 06/01/16.
 */
public interface VoiperinhoService {

    @POST("/user/insert")
    Call<RegisterResponse> userRegister(@Body RegisterRequest registerRequest);
}
