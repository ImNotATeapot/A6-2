package itp341.piyawiroj.patriya.a6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private int SIZE_INTENT_REQUEST_CODE = 0;
    private int COLOR_INTENT_REQUEST_CODE = 1;
    private int NAME_INTENT_REQUEST_CODE = 2;
    private int IMAGE_INTENT_REQUEST_CODE = 3;
    private int SUBMIT_INTENT_REQUEST_CODE = 4;

    public static final String EXTRA_USER_ANSWER = "piyawiroj.patriya.A6-2.extra.user-answer";
    public static final String EXTRA_COLOR_ANSWER = "piyawiroj.patriya.A6-2.extra.color.answer";
    public static final String EXTRA_SIZE_ANSWER = "piyawiroj.patriya.A6-2.extra.size.answer";
    public static final String EXTRA_IMAGE_ANSWER = "piyawiroj.patriya.A6-2.extra.image.answer";
    public static final String EXTRA_NAME_ANSWER = "piyawiroj.patriya.A6-2.extra.name.answer";
    public static final String EXTRA_NUM_COMPLETED_DOORS = "piyawiroj.patriya.A6-2.extra.num.completed-doors";
    public static final String EXTRA_SHOULD_RESET = "piyawiroj.patriya.A6-2.extra.should-reset";

    private Button room1Button;
    private Button room2Button;
    private Button room3Button;
    private Button room4Button;
    private Button submitButton;

    private TextView colorRiddleTextView;
    private TextView sizeRiddleTextView;
    private TextView imageRiddleTextView;
    private TextView nameRiddleTextView;

    private Integer colorAnswer;
    private Integer sizeAnswer;
    private Integer imageAnswer;
    private Integer nameAnswer;

    private int numCompletedDoors = 0;

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.room1Button:
                    Intent colorIntent = new Intent(getApplicationContext(), ColorActivity.class);
                    colorIntent.putExtra(EXTRA_COLOR_ANSWER, colorAnswer);
                    colorIntent.putExtra(EXTRA_NUM_COMPLETED_DOORS, numCompletedDoors);
                    startActivityForResult(colorIntent,COLOR_INTENT_REQUEST_CODE);
                    break;
                case R.id.room2Button:
                    Intent sizeIntent = new Intent(getApplicationContext(), SizeActivity.class);
                    sizeIntent.putExtra(EXTRA_SIZE_ANSWER, sizeAnswer);
                    sizeIntent.putExtra(EXTRA_NUM_COMPLETED_DOORS, numCompletedDoors);
                    startActivityForResult(sizeIntent,SIZE_INTENT_REQUEST_CODE);
                    break;
                case R.id.room3Button:
                    Intent nameIntent = new Intent(getApplicationContext(), NameActivity.class);
                    nameIntent.putExtra(EXTRA_NAME_ANSWER, nameAnswer);
                    nameIntent.putExtra(EXTRA_NUM_COMPLETED_DOORS, numCompletedDoors);
                    startActivityForResult(nameIntent,NAME_INTENT_REQUEST_CODE);
                    break;
                case R.id.room4Button:
                    Intent imageIntent = new Intent(getApplicationContext(), ImageActivity.class);
                    imageIntent.putExtra(EXTRA_IMAGE_ANSWER, imageAnswer);
                    imageIntent.putExtra(EXTRA_NUM_COMPLETED_DOORS, numCompletedDoors);
                    startActivityForResult(imageIntent,IMAGE_INTENT_REQUEST_CODE);
                    break;
                case R.id.submitButton:
                    Intent submitIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    submitIntent.putExtra(EXTRA_NUM_COMPLETED_DOORS, numCompletedDoors);
                    startActivityForResult(submitIntent,SUBMIT_INTENT_REQUEST_CODE);
                    break;
                    default:
                        break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect UI elements
        room1Button = findViewById(R.id.room1Button);
        room2Button = findViewById(R.id.room2Button);
        room3Button = findViewById(R.id.room3Button);
        room4Button = findViewById(R.id.room4Button);
        submitButton = findViewById(R.id.submitButton);

        colorRiddleTextView = findViewById(R.id.colorRiddleTextView);
        sizeRiddleTextView = findViewById(R.id.sizeRiddleTextView);
        imageRiddleTextView = findViewById(R.id.imageRiddleTextView);
        nameRiddleTextView = findViewById(R.id.nameRiddleTextView);

        //set listeners
        Listener listener = new Listener();
        room1Button.setOnClickListener(listener);
        room2Button.setOnClickListener(listener);
        room3Button.setOnClickListener(listener);
        room4Button.setOnClickListener(listener);
        submitButton.setOnClickListener(listener);

        setRiddles();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d(TAG, String.format("Activity returned intent %d and result %d", requestCode, resultCode));
        if (requestCode == SIZE_INTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            if (intent.getIntExtra(EXTRA_USER_ANSWER, -1) == sizeAnswer) {
                Log.d(TAG, String.format("Room 2 has been completed correctly with " + numCompletedDoors + "completed doors"));
                if (numCompletedDoors == 1) {
                    sizeRiddleTextView.setTextColor(getColor(R.color.correctGreen));
                    numCompletedDoors++;
                }
            }
        } else if (requestCode == COLOR_INTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] color = getResources().getStringArray(R.array.colorOptions);
            if (intent.getStringExtra(EXTRA_USER_ANSWER).equals(color[colorAnswer])) {
                Log.d(TAG, String.format("Room 1 has been completed correctly with " + numCompletedDoors + "completed doors"));
                if (numCompletedDoors == 0) {
                    colorRiddleTextView.setTextColor(getColor(R.color.correctGreen));
                    numCompletedDoors++;
                }
            }
        } else if (requestCode == NAME_INTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] nameRiddles = getResources().getStringArray(R.array.nameOptions);
            if (intent.getStringExtra(EXTRA_USER_ANSWER).equalsIgnoreCase(nameRiddles[nameAnswer])) {
                Log.d(TAG, String.format("Room 3 has been completed correctly with " + numCompletedDoors + "completed doors"));
                if (numCompletedDoors == 2) {
                    nameRiddleTextView.setTextColor(getColor(R.color.correctGreen));
                    numCompletedDoors++;
                }
            }
        } else if (requestCode == IMAGE_INTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] imageRiddles = getResources().getStringArray(R.array.imageOptions);
            if (intent.getStringExtra(EXTRA_USER_ANSWER).equalsIgnoreCase(imageRiddles[imageAnswer])) {
                Log.d(TAG, String.format("Room 4 has been completed correctly with " + numCompletedDoors + "completed doors"));
                if (numCompletedDoors == 3) {
                    imageRiddleTextView.setTextColor(getColor(R.color.correctGreen));
                    numCompletedDoors++;
                }
            }
        } else if (requestCode == SUBMIT_INTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            boolean shouldReset = intent.getBooleanExtra(EXTRA_SHOULD_RESET, false);
            Log.d(TAG, "CODE 8888: Puzzles should reset - " + shouldReset);
            if (shouldReset) {
                numCompletedDoors = 0;
                setRiddles();
            }
        }
    }

    private Integer getRandInt(){
        Double rand = Math.random()*3;
        return rand.intValue();
    }

    private void setRiddles() {
        //set riddles
        String[] colorRiddles = getResources().getStringArray(R.array.colorRiddles);
        String[] imageRiddles = getResources().getStringArray(R.array.imageRiddles);
        String[] nameRiddles = getResources().getStringArray(R.array.nameRiddles);
        String[] sizeRiddles = getResources().getStringArray(R.array.sizeRiddles);
        colorAnswer = getRandInt();
        imageAnswer = getRandInt();
        nameAnswer = getRandInt();
        sizeAnswer = getRandInt();
        colorRiddleTextView.setText(colorRiddles[colorAnswer]);
        imageRiddleTextView.setText(imageRiddles[imageAnswer]);
        nameRiddleTextView.setText(nameRiddles[nameAnswer]);
        sizeRiddleTextView.setText(sizeRiddles[sizeAnswer]);
        colorRiddleTextView.setTextColor(getColor(R.color.incorrectRed));
        imageRiddleTextView.setTextColor(getColor(R.color.incorrectRed));
        nameRiddleTextView.setTextColor(getColor(R.color.incorrectRed));
        sizeRiddleTextView.setTextColor(getColor(R.color.incorrectRed));
    }
}
