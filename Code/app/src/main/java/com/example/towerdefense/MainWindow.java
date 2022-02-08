package com.example.towerdefense;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainWindow extends AppCompatActivity {


    public static final String EXTRA_PSEUDO = "Pseudo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
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

    public void sendStart(View view){
        Intent intent = new Intent(this, GameController.class);
        /*
        findViewById(R.id.text);
        TextInputLayout
         */

        intent.putExtra("Pseudo","Keturss");
        startActivity(intent);
    }
}
