package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.textView);
        txt.setText("Huỳnh Thị Mỹ Tâm\n" +
                "22110410\n" +
                "Lớp: 22110ST1");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtChan = findViewById(R.id.textChan);
        TextView txtLe = findViewById(R.id.textLe);
        Button btnSoNgauNhien = findViewById(R.id.buttonSo);

        btnSoNgauNhien.setOnClickListener(v -> {
            ArrayList<Integer> listRandom = generateRandomNumbers(30);

            ArrayList<Integer> listChan = new ArrayList<>();
            ArrayList<Integer> listLe = new ArrayList<>();

            classifyNumbers(listRandom, listChan, listLe);
            displayNumbers(listChan, txtChan, "even");
            displayNumbers(listLe, txtLe, "odd");
        });



        btn1 = findViewById(R.id.button);
        TextView txt2 = findViewById(R.id.textView2);
        EditText editText = findViewById(R.id.editTextText);

        btn1.setOnClickListener(v -> {
            String input = editText.getText().toString().trim();
            String reversed = reverseWords(input);
            txt2.setText(reversed);
            Toast.makeText(MainActivity.this, reversed, Toast.LENGTH_SHORT).show();

        });

    }
    private String reverseWords(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        Collections.reverse(words);
        return String.join(" ", words).toUpperCase();
    }

    private ArrayList<Integer> generateRandomNumbers(int count) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }

    private void classifyNumbers(ArrayList<Integer> listRandom, ArrayList<Integer> listChan, ArrayList<Integer> listLe) {
        for (int number : listRandom) {
            if (number % 2 == 0) {
                listChan.add(number);
            } else {
                listLe.add(number);
            }
        }
    }

    private void displayNumbers(ArrayList<Integer> list, TextView textView, String type) {
        Log.d("MainActivity", "Displaying numbers: " + list.toString());
        if (Objects.equals(type, "even")) {
            textView.setText("Số chẵn: ");
        } else {
            textView.setText("Số lẻ: ");

        }
        for (int number : list) {
            textView.append(number + ", ");
        }
    }

}