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
import java.util.concurrent.Executors;

import edu.utsa.cs3443.jourdiary.database.Database;
import edu.utsa.cs3443.jourdiary.Model.DiaryEntry;


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

        Button newDoc = findViewById(R.id.newDoc);
        Button reminisceButton = findViewById(R.id.remButton);
        Button lastWeek = findViewById(R.id.lastWeek);
        Button lastMonth = findViewById(R.id.lastMonth);

        newDoc.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryLogActivity.this, NewDiary.class);
            startActivity(intent);
        });

        reminisceButton.setOnClickListener(v -> {
            Executors.newSingleThreadExecutor().execute(() -> {
                DiaryEntry randomEntry = Database.getInstance(this).diaryEntryDao().getRandomEntry();

                runOnUiThread(() -> {
                    if (randomEntry != null) {
                        new AlertDialog.Builder(this)
                                .setTitle("Reminisce")
                                .setMessage("Date: " + randomEntry.date + "\n\n" + randomEntry.content)
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        Toast.makeText(this, "No memories to reminisce! Create Some!", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });

    }
}