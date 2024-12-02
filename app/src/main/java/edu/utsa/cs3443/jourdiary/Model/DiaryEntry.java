package edu.utsa.cs3443.jourdiary.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "diary_entries")
public class DiaryEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String date;
    public String content;

    public DiaryEntry(String date, String content) {
        this.date = date;
        this.content = content;
    }
}