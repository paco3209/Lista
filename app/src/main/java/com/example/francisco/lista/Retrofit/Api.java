package com.example.francisco.lista.Retrofit;



import com.example.francisco.lista.Model.Post;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
