package com.example.myapplication;

import java.io.IOException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsRepo {
    private OkHttpClient okhttpClient;
    public LiveData<News>getNews(){
        final MutableLiveData<News>data=new MutableLiveData<>();
        Request request=new Request.Builder()
                .get()
                .url("https://upload.jianshu.io/users/upload_avatars/3274168/0fe32ea0fb32.png?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240")
                .build();
        Call call=okhttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                News news=new News(response.body().string(),"test");
                data.setValue(news);
            }
        });
        return data;
    }

}
