package app.com.vladimirjeune.jokedispayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "A_Joke";

    TextView jokeView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);

        Intent intent = getIntent();
        String aJoke = intent.getStringExtra(JOKE_KEY);

        jokeView = findViewById(R.id.tv_joke);
        jokeView.setText(aJoke);
    }
}
