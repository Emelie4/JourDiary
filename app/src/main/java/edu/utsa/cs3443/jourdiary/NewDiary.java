package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;

import edu.utsa.cs3443.jourdiary.database.Database;
import edu.utsa.cs3443.jourdiary.Model.DiaryEntry;

/**
* Represents the New Diary Page in the application.
* @author Team Skittlez
*/

public class NewDiary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diary);

        //Text and Buttons
        EditText diaryContent = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);
        Button prevButton = findViewById(R.id.prevButton);

        //Saves Diary Entry
        saveButton.setOnClickListener(v -> {
            String content = diaryContent.getText().toString();
            if (!content.isEmpty()) {
                String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                //Creates Diary Entry
                DiaryEntry diaryEntry = new DiaryEntry(currentDate, content);
                Executors.newSingleThreadExecutor().execute(() -> {
                    Database.getInstance(this).diaryEntryDao().insert(diaryEntry);
                });

                diaryContent.setText("");
            }
        });

        //Brings User back to Diary Log
        prevButton.setOnClickListener(v -> {
            Intent intent = new Intent(NewDiary.this, DiaryLogActivity.class);
            startActivity(intent);
        });
    }
}
