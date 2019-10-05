package itp341.piyawiroj.patriya.a6;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    public EditText editText;
    public Button saveChangesButton;
    public String userAnswer = "";

    private static final String TAG = NameActivity.class.getSimpleName();

    private class SaveChangesListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            userAnswer = editText.getText().toString();
            Log.d(TAG, "User chose " + userAnswer);
            getIntent().putExtra(MainActivity.EXTRA_USER_ANSWER, userAnswer);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        saveChangesButton = findViewById(R.id.setNameChangesButton);
        saveChangesButton.setOnClickListener(new SaveChangesListener());
        editText = findViewById(R.id.nameEditText);
    }
}