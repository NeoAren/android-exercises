package eu.neoaren.exercise_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "EXERCISE-6-1";
    public static final String EXTRA_PRESIDENT_ID = "eu.neoaren.exercise_6_1.PRESIDENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializeListView();
    }

    // Handle ListView initialization and item clicks
    public void initializeListView() {
        ListView lv = findViewById(R.id.presidents);
        ArrayList<President> presidents = GlobalModel.getInstance().presidents;
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, presidents));
        lv.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {
            Log.d(TAG, "Selected president id: " + i);
            Intent intent = new Intent(this, PresidentActivity.class);
            intent.putExtra(EXTRA_PRESIDENT_ID, i);
            startActivity(intent);
        });
    }

}
