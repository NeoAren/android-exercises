package eu.neoaren.exercise_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PresidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president);
        this.intentHandler();
    }

    // Get presidentId from intent
    private void intentHandler() {
        Intent intent = getIntent();
        int presidentId = intent.getIntExtra(MainActivity.EXTRA_PRESIDENT_ID, -1);
        this.renderPresidentData(presidentId);
    }

    // Render president data to TextViews
    private void renderPresidentData(int presidentId) {
        TextView presidentName = findViewById(R.id.president_name);
        TextView presidentIncumbency = findViewById(R.id.president_incumbency);
        TextView presidentDescription = findViewById(R.id.president_description);
        if (presidentId != -1) {
            President president = GlobalModel.getInstance().presidents.get(presidentId);
            presidentName.setText(president.getName());
            presidentIncumbency.setText(president.getIncumbency());
            presidentDescription.setText(president.getDescription());
        }
    }

}
