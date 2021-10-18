package com.example.a2019106050_midterm_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.a2019106050_midterm_test.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();

    int aipoint=0, yourpoint=0, time=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(v -> game("바위"));
        binding.button1.setOnClickListener(v-> binding.yourrock.setVisibility(View.VISIBLE));
        binding.button2.setOnClickListener(v -> game("가위"));
        binding.button2.setOnClickListener(v-> binding.yourscissors.setVisibility(View.VISIBLE));
        binding.button3.setOnClickListener(v -> game("보"));
        binding.button3.setOnClickListener(v-> binding.yourpaper.setVisibility(View.VISIBLE));

        binding.button4.setOnClickListener(v -> restart());
    }
    private void game(String yourChoice) {
        int ai = random.nextInt(3);
        binding.button4.setVisibility(View.VISIBLE);
        binding.imageView.setVisibility(View.GONE);

        String aiChoice;
        switch (ai){
            case 0:
                binding.airock.setVisibility(View.VISIBLE);
                aiChoice = "바위";
                break;
            case 1:
                binding.aiscissors.setVisibility(View.VISIBLE);
                aiChoice = "가위";
                break;
            default:
                binding.aipaper.setVisibility(View.VISIBLE);
                aiChoice = "보";
        }
        binding.textView.setText("당신은 " + yourChoice +"를 AI는 " + aiChoice + "를 냈습니다");

        String result;

        if(aiChoice.equals(yourChoice)){
            result = "비겼습니다..다시한번!";
        } else if ((aiChoice.equals("바위") && yourChoice.equals("보")) ||
                (aiChoice.equals("가위") && yourChoice.equals("바위")) ||
                (aiChoice.equals("보") && yourChoice.equals("가위"))) {
            result = "축하합니다! 당신이 이겼습니다";
            yourpoint++;
            time++;
        } else {
            result = "미안합니다ㅜㅜ 당신이 졌습니다";
            aipoint++;
            time++;
        }
        binding.textView2.setText(result);
        binding.textView4.setText("AI:"+aipoint);
        binding.textView5.setText("YOU"+yourpoint +"승률="+ yourpoint+ "/" + time );

    }

    private void restart(){
        finish();
        startActivity(getIntent());
    }





}