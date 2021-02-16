package eu.neoaren.exercise_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NAME = "eu.neoaren.exercise-4-1.NAME";
    public static final String AGE = "eu.neoaren.exercise-4-1.AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> this.submit());
    }

    // Create intent and start new activity
    public void submit() {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText nameInput = (EditText) findViewById(R.id.name);
        EditText ageInput = (EditText) findViewById(R.id.age);
        String name = nameInput.getText().toString();
        String age = ageInput.getText().toString();
        if (!name.equals("") && !age.equals("")) {
            intent.putExtra(NAME, name);
            intent.putExtra(AGE, Integer.parseInt(age));
            startActivity(intent);
        }
    }

}
