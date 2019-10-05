package itp341.piyawiroj.patriya.a6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button room1Button;
    private Button room2Button;
    private Button room3Button;
    private Button room4Button;
    private Button submitButton;

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.room1Button:
                    Intent colorIntent = new Intent(getApplicationContext(), ColorActivity.class);
                    startActivityForResult(colorIntent,0);
                    break;
                case R.id.room2Button:
                    Intent sizeIntent = new Intent(getApplicationContext(), SizeActivity.class);
                    startActivityForResult(sizeIntent,0);
                    break;
                case R.id.room3Button:
                    Intent nameIntent = new Intent(getApplicationContext(), NameActivity.class);
                    startActivityForResult(nameIntent,0);
                    break;
                case R.id.room4Button:
                    Intent imageIntent = new Intent(getApplicationContext(), ImageActivity.class);
                    startActivityForResult(imageIntent,0);
                    break;
                case R.id.submitButton:
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
        room2Button = findViewById(R.id.room1Button);
        room3Button = findViewById(R.id.room1Button);
        room4Button = findViewById(R.id.room1Button);
        submitButton = findViewById(R.id.submitButton);

        //set listeners
        Listener listener = new Listener();
        room1Button.setOnClickListener(listener);
        room2Button.setOnClickListener(listener);
        room3Button.setOnClickListener(listener);
        room4Button.setOnClickListener(listener);
        submitButton.setOnClickListener(listener);

    }
}
