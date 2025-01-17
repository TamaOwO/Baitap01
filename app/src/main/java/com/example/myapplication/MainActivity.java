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

        TextView txt2 = findViewById(R.id.textView2);
        EditText editText = findViewById(R.id.editTextText);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(v -> {
            String input = txt2.getText().toString();
            String reversed = reverseWords(input);
            txt2.setText(reversed);
            Toast.makeText(MainActivity.this, reversed, Toast.LENGTH_SHORT).show();

        });

    }
    private String reverseWords(String input) {
        String[] words = input.split(" "); // Tách chuỗi theo khoảng trắng
        StringBuilder reversed = new StringBuilder();

        // Đảo ngược thứ tự từ
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        // Chuyển thành chữ in hoa và loại bỏ khoảng trắng thừa
        return reversed.toString().trim().toUpperCase();
    }

}