package itp341.piyawiroj.patriya.a6;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    Button saveChangesButton;
    CheckBox bicycleCheckBox;
    CheckBox motorcycleCheckBox;
    CheckBox carCheckBox;

    private static final String TAG = ImageActivity.class.getSimpleName();

    private class SaveChangesListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String userAnswer = "";
            if (bicycleCheckBox.isChecked()) {
                userAnswer += "bike";
            } if (motorcycleCheckBox.isChecked()) {
                userAnswer += "motorcycle";
            } if (carCheckBox.isChecked()) {
                userAnswer += "car";
            }
            Log.d(TAG, "User chose image" + userAnswer);
            getIntent().putExtra(MainActivity.EXTRA_USER_ANSWER, userAnswer);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        bicycleCheckBox = findViewById(R.id.bikeCheckBox);
        motorcycleCheckBox = findViewById(R.id.motorcycleCheckBox);
        carCheckBox = findViewById(R.id.carCheckBox);

        saveChangesButton = findViewById(R.id.setImageChanges);
        saveChangesButton.setOnClickListener(new SaveChangesListener());
    }
}
