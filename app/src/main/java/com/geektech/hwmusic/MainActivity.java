package com.geektech.hwmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.geektech.hwmusic.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private String btnStop;
    private ActivityMainBinding binding;
    private boolean isMusicOn = false;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        player = MediaPlayer.create(MainActivity.this, R.raw.downtown_baby);
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMusicOn){
                    player.pause();
                    isMusicOn = false;
                } else {
                    isMusicOn=true;
                    player.start();
                }
            }
        });
    }


    @Override
    public void onInit(int i) {
    }
}