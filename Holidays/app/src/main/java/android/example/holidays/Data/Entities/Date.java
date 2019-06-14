package android.example.holidays.Data.Entities;

import android.example.holidays.Data.Entities.DateTime;

public class Date
{
    private String iso;

    private DateTime datetime;

    public void setIso(String iso){
        this.iso = iso;
    }
    public String getIso(){
        return this.iso;
    }
    public void setDatetime(DateTime datetime){
        this.datetime = datetime;
    }
    public DateTime getDatetime(){
        return this.datetime;
    }
}
