package android.example.holidays.Data.Entities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Response
{

    private List<Holidays> holidays ;

    public void setHolidays(List<Holidays> holidays){
        this.holidays = holidays;
    }
    public List<Holidays> getHolidays(){
        return this.holidays;
    }
}
