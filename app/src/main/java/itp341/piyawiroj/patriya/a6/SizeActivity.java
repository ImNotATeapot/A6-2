package itp341.piyawiroj.patriya.a6;

import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SizeActivity extends AppCompatActivity {


    public Spinner sizeSpinner;
    public Button saveChangesButton;
    public Integer userAnswer = -1;

    private static final String TAG = SizeActivity.class.getSimpleName();

    private class SaveChangesListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            userAnswer = sizeSpinner.getSelectedItemPosition();
            Log.d(TAG, "User chose " + userAnswer);
            getIntent().putExtra(MainActivity.EXTRA_USER_ANSWER, userAnswer);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        saveChangesButton = findViewById(R.id.setSizeChangesButton);
        saveChangesButton.setOnClickListener(new SaveChangesListener());
        sizeSpinner = findViewById(R.id.sizeSpinner);
    }
}
