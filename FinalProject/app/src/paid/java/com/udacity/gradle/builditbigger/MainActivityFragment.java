package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String TAG = MainActivityFragment.class.getSimpleName();
    private RelativeLayout mRelativeLayout;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = root.findViewById(R.id.pb_pause_for_effect);
        mRelativeLayout = root.findViewById(R.id.rl_main_activity);

        hideProgressBar();

        return root;
    }


    /**
     * HIDEPROGRESSBAR - Will hide the progressBar that is shown on the main page. Initially, should be
     * off, but will need to be turned off after user goes to next activity.
     */
    void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRelativeLayout.setVisibility(View.VISIBLE);
    }


    /**
     * ONSTART
     */
    @Override
    public void onStart() {
        super.onStart();
        hideProgressBar();
    }


    /**
     * SHOWPROGRESSBAR - Will show the indeterminate progressbar that is usually hidden, to indicate that
     * we are waiting for the other Activity to start. May take a while because of the need to go to the
     * cloud(if this were an app that used the internet cloud, instead of just local.)
     */
    void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRelativeLayout.setVisibility(View.INVISIBLE);
    }

}

