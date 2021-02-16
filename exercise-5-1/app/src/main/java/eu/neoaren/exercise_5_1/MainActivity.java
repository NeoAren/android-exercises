package eu.neoaren.exercise_5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Counter created, started, hit;

    private final String TAG = "Exercise-5-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate ran");
        this.setup();
        this.created.increment();
        this.updateUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart ran");
        this.started.increment();
        this.updateUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume ran");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause ran");
        this.setSharedPrefs();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop ran");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart ran");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy ran");
    }

    // Initial application setup
    private void setup() {
        this.initializeCounters();
        Button hitButton = findViewById(R.id.hit_button);
        hitButton.setOnClickListener(view -> {
            this.hit.increment();
            this.updateUI();
        });
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(view -> {
            this.created.reset();
            this.started.reset();
            this.hit.reset();
            this.updateUI();
        });
    }

    // Initilaize counter instances
    private void initializeCounters() {
        int[] initial = this.getSharedPrefs();
        this.created = new Counter(100, -100, initial[0], 1);
        this.started = new Counter(100, -100, initial[1], 1);
        this.hit = new Counter(100, -100, initial[2], 1);
    }

    // Set counter data in SharedPreferences
    private void setSharedPrefs() {
        Gson gson = new Gson();
        int[] values = { this.created.getValue(), this.started.getValue(), this.hit.getValue() };
        SharedPreferences prefs = getSharedPreferences("CounterApp", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString("counters", gson.toJson(values));
        prefsEditor.apply();
    }

    // Get counter data from SharedPreferences
    private int[] getSharedPrefs() {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("CounterApp", Activity.MODE_PRIVATE);
        String jsonString = prefs.getString("counters", "[0,0,0]");
        return gson.fromJson(jsonString, int[].class);
    }

    // Update user interface with current counter data
    @SuppressLint("SetTextI18n")
    private void updateUI() {
        TextView createdCounterDisplay = findViewById(R.id.created_counter);
        TextView startedCounterDisplay = findViewById(R.id.started_counter);
        TextView hitCounterDisplay = findViewById(R.id.hit_counter);
        createdCounterDisplay.setText(Integer.toString(this.created.getValue()));
        startedCounterDisplay.setText(Integer.toString(this.started.getValue()));
        hitCounterDisplay.setText(Integer.toString(this.hit.getValue()));
    }

}
