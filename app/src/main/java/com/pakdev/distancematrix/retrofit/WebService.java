package com.pakdev.distancematrix.retrofit;



import com.pakdev.distancematrix.model.GoogleApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


// To do : make callbacks


public interface WebService {



    @GET(WebServiceConstants.WS_KEY_DISTANCE_MATRIX)
    Call<GoogleApiResponse> calculateDistance(
            @Query("units") String units,
            @Query("origins") String origins,
            @Query("destinations") String destinations,
            @Query("key") String apiKey
    );


}
