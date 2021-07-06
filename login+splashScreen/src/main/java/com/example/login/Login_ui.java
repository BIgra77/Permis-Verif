package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_ui extends AppCompatActivity {

    EditText userId, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);
        userId=findViewById(R.id.userId);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdText = userId.getText().toString();
                String passwordText = password.getText().toString();
                if(userIdText.isEmpty()||passwordText.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Remplissez tous les champs",Toast.LENGTH_SHORT).show();
                }
                else{
                     UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                     UserDao userDao = userDatabase.userDao();
                     new Thread(new Runnable() {
                         @Override
                         public void run() {
                            UserEntity userEntity=userDao.login(userIdText,passwordText);
                            if(userEntity==null)
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"invalid credential",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String name = userEntity.name;
                                startActivity(new Intent(Login_ui.this,Homescreen.class).putExtra("name",name));
                            }
                         }
                     }).start();
                }
            }
        });
    }
}