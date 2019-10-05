package itp341.piyawiroj.patriya.a6;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultsTextView;
    boolean win = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_results);

        int numCompleted = getIntent().getIntExtra(MainActivity.EXTRA_NUM_COMPLETED_DOORS, -1);

        resultsTextView = findViewById(R.id.resultsTextView);
        if (numCompleted == 4) {
            resultsTextView.setText(R.string.winTextView);
            win = true;
            getIntent().putExtra(MainActivity.EXTRA_SHOULD_RESET, true);
        } else {
            resultsTextView.setText(R.string.lostTextView);
        }


    }
}
