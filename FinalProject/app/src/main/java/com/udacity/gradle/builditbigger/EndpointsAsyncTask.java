package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

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
