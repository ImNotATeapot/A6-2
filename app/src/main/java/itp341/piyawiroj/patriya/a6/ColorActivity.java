package itp341.piyawiroj.patriya.a6;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    private int seekR, seekG, seekB;
    SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    View view;
    TextView redTextcode;
    TextView greenTextcode;
    TextView blueTextcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        view = findViewById(R.id.view);
        redSeekBar = findViewById(R.id.seekBarR);
        greenSeekBar = findViewById(R.id.seekBarG);
        blueSeekBar = findViewById(R.id.seekBarB);
        redTextcode = findViewById(R.id.redTextView);
        greenTextcode = findViewById(R.id.greenTextView);
        blueTextcode = findViewById(R.id.blueTextView);
        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        redTextcode.setText(String.format(getResources().getString(R.string.R), 0));
        greenTextcode.setText(String.format(getResources().getString(R.string.G), 0));
        blueTextcode.setText(String.format(getResources().getString(R.string.B), 0));

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
        private void updateBackground()
        {
            seekR = redSeekBar.getProgress();
            seekG = greenSeekBar.getProgress();
            seekB = blueSeekBar.getProgress();
            Double red = Math.ceil(seekR*2.55);
            Double green = Math.ceil(seekG*2.55);
            Double blue = Math.ceil(seekB*2.55);
            view.setBackgroundColor(Color.argb(255, red.intValue(), green.intValue(), blue.intValue()));
            redTextcode.setText(String.format(getResources().getString(R.string.R), (red.intValue())));
            greenTextcode.setText(String.format(getResources().getString(R.string.G), (green.intValue())));
            blueTextcode.setText(String.format(getResources().getString(R.string.B), (blue.intValue())));
        }
    };
}


