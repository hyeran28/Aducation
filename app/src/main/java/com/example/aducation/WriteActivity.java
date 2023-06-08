package com.example.aducation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class WriteActivity extends AppCompatActivity {

    private EditText mWriteTitleText;
    private EditText mWriteContentsText;
    private EditText mWriteNameText;
    private Button mWriteEndButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mWriteTitleText = findViewById(R.id.write_title_text);
        mWriteContentsText = findViewById(R.id.write_contents_text);
        mWriteNameText = findViewById(R.id.write_name_text);
        mWriteEndButton = findViewById(R.id.write_end_button);

        mWriteEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteActivity.this, Fragment1.class);
                startActivity(intent);
            }
        });
    }
}
