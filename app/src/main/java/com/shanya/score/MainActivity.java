package com.shanya.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.shanya.score.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);//相当于上面注释的那一条语句
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);//创建MyViewModel实例
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}
