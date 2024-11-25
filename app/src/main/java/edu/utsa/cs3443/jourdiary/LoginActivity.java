package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonLoginSubmit = findViewById(R.id.buttonLoginSubmit);

        buttonLoginSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, DiaryLogActivity.class);
            startActivity(intent);
        });
    }
}

