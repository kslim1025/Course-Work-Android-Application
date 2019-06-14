package android.example.holidays.Data;

import android.example.holidays.Data.Entities.Root;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HolidaysService {
    @GET("/api/v2/holidays?")
    Call<ResponseBody> getHolidays(@Query("api_key") String appId, @Query("country") String country, @Query("year") String year);
}
