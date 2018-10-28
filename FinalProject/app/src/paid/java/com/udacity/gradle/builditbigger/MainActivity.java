package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.jokes.JokeTeller;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    public static final String JOKE_TAG = app.com.vladimirjeune.jokesandroidlib.MainActivity.JOKE_TAG;

    JokeTeller jokeTeller = new JokeTeller();
    String saidJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new EndpointsAsyncTask().execute(this);  // Get joke and display it

    }

}

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;

    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {

        if (myApiService == null ) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")  // - 10.0.2.2 is localhost's IP address in Android emulator
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);  // Turn off compression when run against local devappserver
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = contexts[0];

        try {
            return myApiService.sayJoke().execute().getData();  // TODO: https://www.journaldev.com/9708/android-asynctask-example-tutorial
        } catch (IOException ioe) {
            return ioe.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        String saidJoke = result;
        Intent jokeIntent = new Intent(context, app.com.vladimirjeune.jokesandroidlib.MainActivity.class);
        jokeIntent.putExtra(MainActivity.JOKE_TAG, saidJoke);
        context.startActivity(jokeIntent);
    }

}
