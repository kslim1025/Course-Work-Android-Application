package android.example.holidays.Data;

import android.example.holidays.Data.Entities.Holidays;
import android.example.holidays.Data.Entities.Root;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RemoteDataSource {

    private HolidaysService holidaysService;
    private Gson gson;

    public RemoteDataSource() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://calendarific.com/")
                //.addConverterFactory(GsonConverterFactory.create())
                .build();

        holidaysService = retrofit.create(HolidaysService.class);
        gson = new GsonBuilder()
                .registerTypeAdapter(Holidays.class, new Holidays.HolidaysDeserilizer())
                .create();
    }

    public Root getHolidaysFinal(String API_KEY, String country, String year) {
        Call<ResponseBody> call = holidaysService.getHolidays(API_KEY,country,year);
        try {
            Response<ResponseBody> response = call.execute();
            Log.e("HTTP:", "" + response.raw().toString());
            if (response.isSuccessful()){
                Root root = gson.fromJson(response.body().string(), Root.class);
                return root;
            }
        } catch(IOException ioex) {
            Log.e("Remote","IOEX" + ioex);
        }
        return null;
    }
}
