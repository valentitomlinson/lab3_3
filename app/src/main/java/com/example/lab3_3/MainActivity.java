package com.example.lab3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private EditText inputPlainText;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPlainText = (EditText) findViewById(R.id.plain_text);
        outputTextView = (TextView) findViewById(R.id.text_view);
    }
        public void read(View view) throws IOException {
            FileInputStream inputFile = openFileInput("a.txt");
            InputStreamReader reader = new InputStreamReader(inputFile);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuilder = new StringBuilder();


            String lines;
            while ((lines = buffer.readLine()) != null) {
                strBuilder.append(lines).append("\n");
            }
            inputFile.close();
            outputTextView.setText(strBuilder.toString());
            outputTextView.setMovementMethod(new ScrollingMovementMethod());
    }
        public void write(View view) throws IOException {
            String myTxt = inputPlainText.getText().toString();
            FileOutputStream fileOutput = openFileOutput("a.txt", MODE_PRIVATE);
            fileOutput.write(myTxt.getBytes());
            fileOutput.close();
            inputPlainText.setText("");
            Toast.makeText(MainActivity.this, "Данные записаны", Toast.LENGTH_LONG).show();
            }
    }
