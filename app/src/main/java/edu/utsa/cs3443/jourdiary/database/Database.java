package edu.utsa.cs3443.jourdiary.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.utsa.cs3443.jourdiary.dao.DiaryEntrydao;
import edu.utsa.cs3443.jourdiary.Model.DiaryEntry;

/**
* Represents the Database for Diary Entries.
* @author Team Skittlez
*/

@androidx.room.Database(entities = {DiaryEntry.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract DiaryEntrydao diaryEntryDao();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    Database.class,
                    "diary_database"
            ).fallbackToDestructiveMigration().build();
        }
        /**
        * @return Database instance
        */
        return instance;
    }
}
