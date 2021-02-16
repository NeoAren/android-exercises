package eu.neoaren.exercise_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up counter
        this.counter = new Counter(20, -20, 0, 1);

        // Find buttons
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        ImageButton reset = findViewById(R.id.reset);
        RadioGroup radioGroup = findViewById(R.id.radioOutput);

        // Attach event listeners
        plus.setOnClickListener(view -> this.updateCounter(view));
        minus.setOnClickListener(view -> this.updateCounter(view));
        reset.setOnClickListener(view -> this.updateCounter(view));
        radioGroup.setOnCheckedChangeListener((_group, _checkedId) -> this.updateUI());

    }

    // Update counter
    private void updateCounter(View view) {
        if (view == findViewById(R.id.plus)) {
            this.counter.increment();
        } else if (view == findViewById(R.id.minus)) {
            this.counter.decrement();
        } else if (view == findViewById(R.id.reset)) {
            this.counter.reset();
        }
        this.updateUI();
    }

    // Update user interface
    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    private void updateUI() {
        TextView text = findViewById(R.id.counter);
        RadioGroup rg = findViewById(R.id.radioOutput);
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.radioOutputDec: {
                text.setText(Integer.toString(this.counter.getValue()));
                break;
            }
            case R.id.radioOutputHex: {
                text.setText(Integer.toHexString(this.counter.getValue()));
                break;
            }
            case R.id.radioOutputBin: {
                text.setText(Integer.toBinaryString(this.counter.getValue()));
                break;
            }
        }
    }

}
