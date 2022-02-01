package fr.iut63.portagejeujfx.views;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.portagejeujfx.R;

public class GameWindow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_window);
        Log.d("tests", "onCreate 2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tests", "onStart 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tests", "onResume 2");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tests", "onRestoreInstanceState 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tests", "onPause 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tests", "onStop 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tests", "onDestroy 2");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tests", "onSaveInstanceState 2");
    }



}
