package xyz.thedevspot.voiperinho.network;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import xyz.thedevspot.voiperinho.models.Credentials;
import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 06/01/16.
 */
public interface VoiperinhoService {

    @POST("user")
    Call<LoginResponse> userLogin(@Body Credentials credentials);
}
