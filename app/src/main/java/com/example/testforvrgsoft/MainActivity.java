package com.example.testforvrgsoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testforvrgsoft.utils.PermissionUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.example.testforvrgsoft.Application.getContext;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}