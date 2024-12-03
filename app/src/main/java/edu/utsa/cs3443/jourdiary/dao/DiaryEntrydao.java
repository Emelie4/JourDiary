package edu.utsa.cs3443.jourdiary.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import edu.utsa.cs3443.jourdiary.Model.DiaryEntry;

@Dao
public interface DiaryEntrydao {

    @Insert
    void insert(DiaryEntry diaryEntry);

    @Query("SELECT * FROM diary_entries ORDER BY id DESC")
    List<DiaryEntry> getAllEntries();

    @Query("SELECT * FROM diary_entries ORDER BY RANDOM() LIMIT 1")
    DiaryEntry getRandomEntry();

    @Query("SELECT * FROM diary_entries WHERE date >= date('now', '-7 days') ORDER BY date DESC")
    List<DiaryEntry> getLastWeekEntries();

    @Query("SELECT * FROM diary_entries WHERE date >= date('now', '-30 days') ORDER BY date DESC")
    List<DiaryEntry> getLastMonthEntries();

    @Delete
    void delete(DiaryEntry diaryEntry);

}
