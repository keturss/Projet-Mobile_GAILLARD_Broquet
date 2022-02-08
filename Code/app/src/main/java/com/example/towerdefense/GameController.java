package com.example.towerdefense;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameController extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainWindow.EXTRA_PSEUDO);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);


        Log.d("ACTION","Create Application");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ACTION","Start Application");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ACTION","Resume Application");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ACTION","Pause Application");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ACTION","Stop Application");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ACTION","Restart Application");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ACTION","Destroy Application");
    }

}