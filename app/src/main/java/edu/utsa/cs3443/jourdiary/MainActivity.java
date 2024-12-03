package edu.utsa.cs3443.jourdiary;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

/**
* Represents the main activity in the application.
* @author Team Skittlez
*/

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button loginButton = findViewById(R.id.buttonLogin);
        Button signUpButton = findViewById(R.id.buttonSignUp);
        Button aboutButton = findViewById(R.id.buttonAbout);

        //Brings User to Login Page
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        //Brings User to Sign Up Page
        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        //Brings User to About Page
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });


    }
}
