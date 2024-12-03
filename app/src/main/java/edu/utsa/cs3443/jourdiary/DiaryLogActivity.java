package edu.utsa.cs3443.jourdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

import java.util.List;
import java.util.concurrent.Executors;

import edu.utsa.cs3443.jourdiary.database.Database;
import edu.utsa.cs3443.jourdiary.Model.DiaryEntry;

/**
* Represents the Diary Log page in the application.
* @author Team Skittlez
*/
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
        Button reminisceButton = findViewById(R.id.remButton);
        Button lastWeek = findViewById(R.id.lastWeek);
        Button lastMonth = findViewById(R.id.lastMonth);
        Button prevButton = findViewById(R.id.prevButton);

        //Goes to New Diary Page
        newDoc.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryLogActivity.this, NewDiary.class);
            startActivity(intent);
        });

        //Gets Entries from the past week
        lastWeek.setOnClickListener(v -> {
            Executors.newSingleThreadExecutor().execute(() -> {
                List<DiaryEntry> lastWeekEntries = Database.getInstance(this).diaryEntryDao().getLastWeekEntries();

                runOnUiThread(() -> {
                    //Displays Entries
                    if (lastWeekEntries != null && !lastWeekEntries.isEmpty()) {
                        StringBuilder message = new StringBuilder();
                        for (DiaryEntry entry : lastWeekEntries) {
                            message.append("Date: ").append(entry.date).append("\n").append(entry.content).append("\n\n");
                        }
                        new AlertDialog.Builder(this)
                                .setTitle("Entries from Last Week")
                                .setMessage(message.toString())
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        //Displays Error Message
                        Toast.makeText(this, "No entries from the past week!", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });

        //Gets Entries from the past month
        lastMonth.setOnClickListener(v -> {
            Executors.newSingleThreadExecutor().execute(() -> {
                List<DiaryEntry> lastMonthEntries = Database.getInstance(this).diaryEntryDao().getLastMonthEntries();

                runOnUiThread(() -> {
                    //Displays Entries
                    if (lastMonthEntries != null && !lastMonthEntries.isEmpty()) {
                        StringBuilder message = new StringBuilder();
                        for (DiaryEntry entry : lastMonthEntries) {
                            message.append("Date: ").append(entry.date).append("\n").append(entry.content).append("\n\n");
                        }
                        new AlertDialog.Builder(this)
                                .setTitle("Entries from Last Month")
                                .setMessage(message.toString())
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        //Displays Error Message
                        Toast.makeText(this, "No entries from the past month!", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });

        //Shows most recent Diary Entry
        reminisceButton.setOnClickListener(v -> {
            Executors.newSingleThreadExecutor().execute(() -> {
                DiaryEntry randomEntry = Database.getInstance(this).diaryEntryDao().getRandomEntry();

                runOnUiThread(() -> {
                    if (randomEntry != null) {
                        //Displays Entry
                        new AlertDialog.Builder(this)
                                .setTitle("Reminisce")
                                .setMessage("Date: " + randomEntry.date + "\n\n" + randomEntry.content)
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        //Displays Error Message
                        Toast.makeText(this, "No memories to reminisce! Create some!", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });

        //Brings User back to Main Menu
        prevButton.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryLogActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
