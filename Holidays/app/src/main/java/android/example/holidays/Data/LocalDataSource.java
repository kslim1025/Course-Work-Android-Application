package android.example.holidays.Data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class LocalDataSource {
    final HolidaysDB database;

    public LocalDataSource (Context context) {
        database = Room.databaseBuilder(context,HolidaysDB.class,"holidays").build();
    }

    public void storeHolidays(List<HolidaysEntity> root) {
        database.holidaysDao().insertHolidays(root);
    }

    public LiveData<List<HolidaysEntity>> getHolidaysDB() {
        return database.holidaysDao().getHolidaysDao();
    }
}
