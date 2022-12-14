package com.ibo.sharedperferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textID);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextTextPersonName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("secret",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("msg",editText.getText().toString());
                editor.commit();
            }
        });

        SharedPreferences preferences=getSharedPreferences("secret",0);
        if(preferences.contains("msg")){
            textView.setText(preferences.getString("msg","not found"));
        }


    }
}