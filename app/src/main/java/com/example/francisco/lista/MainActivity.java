package com.example.francisco.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.francisco.lista.Adapter.PostAdapter;
import com.example.francisco.lista.Model.Post;
import com.example.francisco.lista.Retrofit.Api;
import com.example.francisco.lista.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    Api api;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = RetrofitClient.getInstance();
        api = retrofit.create(Api.class);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();







    }

    private void fetchData() {
        compositeDisposable.add(api.getPosts()
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        displayData(posts);
                    }
                })
        );

    }

    private void displayData(List<Post> posts) {
        PostAdapter adapter = new PostAdapter(this, posts);
        recyclerView.setAdapter(adapter);
    }


}
