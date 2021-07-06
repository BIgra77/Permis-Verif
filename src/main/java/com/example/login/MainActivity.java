package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userId,password,name;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId=findViewById(R.id.userId);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        register=findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                if(userId.length()!=12){
                    userId.setError("Le numéro NEPH doit contenir 12 caractères.");
                }
                if(password.length() < 8){
                    password.setError("Le mot de passe doit contenir au moins 8 caractères.");
                    return;
                }
                if(name.length()<5){
                    name.setError("Email invalide.");
                }
                if(validateInput(userEntity)){
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Enregistré avec succès",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(),"Vous devez tout remplir.",Toast.LENGTH_SHORT).show();

                }


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login_ui.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity) {
        if(userEntity.getName().isEmpty() || userEntity.getPassword().isEmpty() || userEntity.getName().isEmpty()){
            return false;
        }
        return true;
    }
}