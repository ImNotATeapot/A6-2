package itp341.piyawiroj.patriya.a6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button room1Button;

    private class Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //create explicity intent
            Intent i = new Intent(getApplicationContext(), ColorActivity.class);//(MainActivity.this, ColorActivity.class.getSimpleName());
            startActivityForResult(i,0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect UI elements
        room1Button = findViewById(R.id.room1Button);

        //set listeners
        Listener listener = new Listener();
        room1Button.setOnClickListener(listener);

//        Intent i = new Intent(this, ColorActivity.class);
////        startActivityForResult(i,0);
//        startActivity(i);
    }
}
