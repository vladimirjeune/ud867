package app.com.vladimirjeune.jokesandroidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String JOKE_TAG = "app.com.vladimirjeune.jokesandroidlib.JOKE_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_TAG);

        TextView jokeTextView = findViewById(R.id.tv_joke);
        jokeTextView.setText(joke);

    }
}
