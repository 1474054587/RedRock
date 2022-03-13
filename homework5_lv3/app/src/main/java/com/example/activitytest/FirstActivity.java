package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button btn1 = findViewById(R.id.button_sign_in);
        Button btn2 = findViewById(R.id.button_sign_up);
        EditText et1 = findViewById(R.id.et_sign_in_username);
        EditText et2 = findViewById(R.id.et_sign_in_password);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et1.getText().toString();
                String password = et2.getText().toString();
                onOptionsItemSelected(username,password);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onOptionsItemSelected(String username,String password){
        if (load().equals(username+","+password)) {
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("account");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line=reader.readLine()) != null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
