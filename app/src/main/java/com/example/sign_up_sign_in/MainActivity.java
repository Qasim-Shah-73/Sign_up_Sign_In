package com.example.sign_up_sign_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name,pass;
    Button login,signup;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = name.getText().toString();
                String t2 = pass.getText().toString();
                boolean chk = helper.Login_Validity(t1,t2);
                if (chk)
                {
                    Intent intent = new Intent(MainActivity.this, Work.class);
                    startActivity(intent);
                }
                else
                {
                    Message.message(getApplicationContext(),"Login failed");
                    name.setText("");
                    pass.setText("");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sign_Up.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
    name=findViewById(R.id.editTextTextPersonName);
    pass = findViewById(R.id.editTextTextPassword);
    login = findViewById(R.id.button);
    signup = findViewById(R.id.button2);
    helper = new myDbAdapter(this);
    }
}