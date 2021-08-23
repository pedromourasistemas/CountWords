package com.pedromoura.countword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initComponents();

        Intent intent = getIntent();
        if(intent != null) {
            HashMap<String, Integer> hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("map");

            for(Map.Entry<String,Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                txtResult.append(key + " - " + value + "\n");
            }
        }
    }

    private void initComponents() {
        txtResult = findViewById(R.id.txt_result);
    }
}