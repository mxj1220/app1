package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView iv_img;
    TextView tv_title;
    NewsViewModel newsViewModel;
    LiveData<News>newsLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsViewModel= new ViewModelProvider(MainActivity.this).get(NewsViewModel.class);
        newsViewModel.getData();
        newsViewModel.getNewsLiveData().observe(this, (Observer<? super News>) newsLiveData);
    }
}