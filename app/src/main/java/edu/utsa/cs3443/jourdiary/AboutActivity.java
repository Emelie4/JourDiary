package edu.utsa.cs3443.jourdiary;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

/**
* Represents the About page in the application.
* @author Team Skittlez
*/

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Button
        Button prevButton = findViewById(R.id.prevButton);

        //Brings User back to Main Menu
        prevButton.setOnClickListener(v -> {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
