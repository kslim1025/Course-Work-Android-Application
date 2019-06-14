package android.example.holidays.Data;

import android.example.holidays.Data.Entities.Holidays;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HolidaysEntity.class},version = 1,exportSchema = false)
public abstract class HolidaysDB extends RoomDatabase {
    public abstract HolidaysDao holidaysDao();
}
