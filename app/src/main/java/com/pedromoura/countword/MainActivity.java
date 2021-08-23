package com.pedromoura.countword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText edtText;
    private Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnCount.setOnClickListener((v) -> {
            sendResult(countWords(edtText.getText().toString()));
        });
    }

    private void initComponents() {
        edtText = findViewById(R.id.edt_phrase);
        btnCount = findViewById(R.id.btn_count);
    }

    private HashMap<String, Integer> countWords(String phrase) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] words = phrase.split(" ");

        for (String word : words) {
            if (hashMap.containsKey(word))
                hashMap.put(word, hashMap.get(word) + 1);
            else
                hashMap.put(word, 1);
        }

        return hashMap;
    }

    private void sendResult(HashMap<String, Integer> result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("map", result);
        startActivity(intent);
    }
}