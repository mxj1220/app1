package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {
    private LiveData<News>newsLiveData;
    private NewsRepo newsRepo;
    public void getData(){
       newsLiveData= newsRepo.getNews();
    }
    public LiveData<News> getNewsLiveData() {
        return newsLiveData;
    }


}
