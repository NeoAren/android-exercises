package eu.neoaren.exercise_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract values
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        int age = intent.getIntExtra(MainActivity.AGE, 0);

        // Capture the layout's TextView and set the 'info' string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format(getResources().getString(R.string.info), name, age));

    }

}
