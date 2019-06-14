package android.example.holidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonMain;
    private EditText editText_country;
    private EditText editText_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMain = findViewById(R.id.button_main);
        editText_country = findViewById(R.id.editText_main_country);
        editText_year = findViewById(R.id.editText_main_year);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.country), editText_country.getText().toString());
                intent.putExtra(getString(R.string.year), editText_year.getText().toString());
                intent.setClass(getApplicationContext(),HolidaysActivity.class);
                startActivity(intent);
            }
        });

    }
}
