package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DiaryLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diary_log);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Buttons
        Button newDoc = findViewById(R.id.newDoc);
        Button prevDoc = findViewById(R.id.prevDoc);
        Button lastWeek = findViewById(R.id.lastWeek);
        Button lastMonth = findViewById(R.id.lastMonth);
        Button prevButton = findViewById(R.id.prevButton);

        newDoc.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryLogActivity.this, NewDiary.class);
            startActivity(intent);
        });



        prevButton.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryLogActivity.this, MainActivity.class);
            startActivity(intent);
        });







    }
}