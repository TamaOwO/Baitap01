package com.example.myapplication;

import android.os.Bundle;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt2;
    EditText edittext1;
    TextView txt1;
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

}