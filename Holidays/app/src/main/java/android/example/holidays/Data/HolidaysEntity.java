package android.example.holidays.Data;

import android.example.holidays.Data.Entities.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "holidays")
public class HolidaysEntity {

    @PrimaryKey
    public int id;
    public String name;
    public String date;
    public String description;
    public String locations;
}
