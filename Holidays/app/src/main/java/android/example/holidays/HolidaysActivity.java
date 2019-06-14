package android.example.holidays;


import android.example.holidays.Data.HolidaysEntity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HolidaysActivity extends AppCompatActivity implements Observer<List<HolidaysEntity>> {

    private String country_value;
    private String year_value;

    private HolidaysAdapter holidaysAdapter;
    private RecyclerView recyclerView;

    private List<HolidaysEntity> holidaysEntities0;

    private LiveData<List<HolidaysEntity>> holidaysData;

    @Override
    public void onChanged(List<HolidaysEntity> root) {
        for (int i= 0; i < root.size(); i++) {
            Log.e("Outcome","" + root.get(i).name);
        }
            holidaysAdapter.func(root);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        country_value = getIntent().getStringExtra(getString(R.string.country));

        year_value = getIntent().getStringExtra(getString(R.string.year));

        holidaysData = new MutableLiveData<>();

        recyclerView = findViewById(R.id.rec_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        holidaysEntities0 = new ArrayList<>();
        holidaysAdapter = new HolidaysAdapter(holidaysEntities0);

        recyclerView.setAdapter(holidaysAdapter);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.loadData(this,country_value,year_value);

        holidaysData = mainViewModel.getHolidaysData();

        holidaysData.observe(this,this);
    }

}
