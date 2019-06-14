package android.example.holidays.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HolidaysDao {

    @Query("SELECT * FROM holidays")
    LiveData<List<HolidaysEntity>> getHolidaysDao();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHolidays(List<HolidaysEntity> holidaysEntities);
}
