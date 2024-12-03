package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signUpButton = findViewById(R.id.buttonSignUpSubmit);

        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Registration complete!", Toast.LENGTH_SHORT).show();
        });
    }
}
