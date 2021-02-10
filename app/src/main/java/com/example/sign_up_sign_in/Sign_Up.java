package com.example.sign_up_sign_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_Up extends AppCompatActivity {
    TextView name,pass;
    Button login;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = name.getText().toString();
                String t2 = pass.getText().toString();
                if(t1.isEmpty() || t2.isEmpty())
                {
                    Message.message(getApplicationContext(),"Enter Both Name and Password");
                }
                else
                {
                    long id = helper.insertData(t1,t2);
                    if(id<=0)
                    {
                        Message.message(getApplicationContext(),"Insertion Unsuccessful");
                        name.setText("");
                        pass.setText("");
                    } else
                    {
                        Message.message(getApplicationContext(),"Insertion Successful");
                        name.setText("");
                        pass.setText("");
                        Intent intent = new Intent(Sign_Up.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private void init() {
        name=findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);
        helper = new myDbAdapter(this);
    }
}