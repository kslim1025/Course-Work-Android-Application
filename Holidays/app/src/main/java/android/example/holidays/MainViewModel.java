package android.example.holidays;

import android.content.Context;
import android.example.holidays.Data.HolidaysEntity;
import android.example.holidays.Data.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {
    private Repository repository;
    LiveData<List<HolidaysEntity>> holidaysData;

    public void loadData(Context context, String country, String year){
        if( holidaysData == null) {
            repository = new Repository(context);
            holidaysData = repository.getHoidays(context.getString(R.string.API_KEY),country,year);
        }
    }

    public LiveData<List<HolidaysEntity>> getHolidaysData() {
        return holidaysData;
    }

}
