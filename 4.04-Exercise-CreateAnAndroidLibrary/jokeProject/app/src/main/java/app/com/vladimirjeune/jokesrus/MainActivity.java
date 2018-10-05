package app.com.vladimirjeune.jokesrus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vladimirjeune.jokesrus.JokeSmith;

import app.com.vladimirjeune.jokedispayer.JokeDisplayerActivity;

public class MainActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "A_Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getJoke(View view) {
        JokeSmith jokeSmith = new JokeSmith();
        String aJoke = jokeSmith.getJoke();

        Intent jokeIntent = new Intent(this, JokeDisplayerActivity.class);
        jokeIntent.putExtra(JOKE_KEY, aJoke);  // You have to do something with name
        startActivity(jokeIntent);
    }
}
