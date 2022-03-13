package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button btn = findViewById(R.id.button2_sign_up);
        EditText et1 = findViewById(R.id.et_sign_up_username);
        EditText et2 = findViewById(R.id.et_sign_up_password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et1.getText().toString();
                String password = et2.getText().toString();
                save(username,password);
                onOptionsItemSelected();
            }
        });
    }
    public boolean onOptionsItemSelected(){
        Toast.makeText(SecondActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void save(String username,String password){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("account", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(username+","+password);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch (IOException f){
                f.printStackTrace();
            }
        }
    }
}