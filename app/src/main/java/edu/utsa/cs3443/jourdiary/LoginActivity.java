package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
* Represents the Login page in the application.
* @author Team Skittlez
*/
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Button
        Button buttonLoginSubmit = findViewById(R.id.buttonLoginSubmit);

        //Brings User to Diary Log
        buttonLoginSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, DiaryLogActivity.class);
            startActivity(intent);
        });
    }
}

