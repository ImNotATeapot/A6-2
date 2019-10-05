package itp341.piyawiroj.patriya.a6;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    public static final String TAG = ResultActivity.class.getSimpleName();
    TextView resultsTextView;
    boolean win = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int numCompleted = getIntent().getIntExtra(MainActivity.EXTRA_NUM_COMPLETED_DOORS, -1);

        resultsTextView = findViewById(R.id.resultsTextView);
        if (numCompleted == 4) {
            resultsTextView.setText(R.string.winTextView);
            win = true;
        } else {
            resultsTextView.setText(R.string.lostTextView);
            win = false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "CODE 8888: Putting intent " + win);
        getIntent().putExtra(MainActivity.EXTRA_SHOULD_RESET, win);
        setResult(RESULT_OK, getIntent());
        finish();
        super.onBackPressed();
    }
}
