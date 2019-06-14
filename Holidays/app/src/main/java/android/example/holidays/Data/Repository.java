package android.example.holidays.Data;

import android.content.Context;
import android.example.holidays.Data.Entities.Root;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Repository {

    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public Repository(Context context) {
        remoteDataSource = new RemoteDataSource();
        localDataSource = new LocalDataSource(context);
    }

    public LiveData<List<HolidaysEntity>> getHoidays(final String API_KEY, final String country, final String year){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Root root = remoteDataSource.getHolidaysFinal(API_KEY,country,year);
                final List<HolidaysEntity> holidaysEntities = new ArrayList<>();
                for(int i = 0; i < root.getResponse().getHolidays().size(); i++) {
                    HolidaysEntity holidaysEntity = new HolidaysEntity();
                    holidaysEntity.id = i;
                    holidaysEntity.name = root.getResponse().getHolidays().get(i).getName();
                    holidaysEntity.date = root.getResponse().getHolidays().get(i).getDate().getDatetime().getYear() + "-"
                    + root.getResponse().getHolidays().get(i).getDate().getDatetime().getMonth() + "-"
                    + root.getResponse().getHolidays().get(i).getDate().getDatetime().getDay();
                    holidaysEntity.description = root.getResponse().getHolidays().get(i).getDescription();
                    holidaysEntity.locations = root.getResponse().getHolidays().get(i).getLocations();
                    holidaysEntities.add(holidaysEntity);
                }
                for(int i = 0; i < holidaysEntities.size(); i++) {
                    Log.e("Income", "" + holidaysEntities.get(i).name);
                }
                localDataSource.storeHolidays(holidaysEntities);
            }
        });
        return localDataSource.getHolidaysDB();
    }


}
