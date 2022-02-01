package fr.iut63.portagejeujfx.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.portagejeujfx.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tests", "onCreate");
        setContentView(R.layout.main_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tests", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tests", "onResume");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tests", "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tests", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tests", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tests", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tests", "onSaveInstanceState");
    }

    public void onClickButtonPlay(View view) {
        Intent intent = new Intent(this, GameWindow.class);
        startActivity(intent);
    }
}
