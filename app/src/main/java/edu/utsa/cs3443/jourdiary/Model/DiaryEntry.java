package edu.utsa.cs3443.jourdiary.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
* Represents a diary entry in the database.
* @author Team Skittlez
*/

@Entity(tableName = "diary_entries")
public class DiaryEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String date;
    public String content;

    /**
    * Constructor for DiaryEntry
    * @param date
    * @param content
    */

    public DiaryEntry(String date, String content) {
        this.date = date;
        this.content = content;
    }
}
