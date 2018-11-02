package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String TAG = MainActivityFragment.class.getSimpleName();
    private InterstitialAd mInterstitialAd;
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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());  // Loading does not show, large image MUST be loaded before show is called

        // Ad Lifecycle()
        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                // This is a good place to load the next Interstitial
                mInterstitialAd.loadAd(new AdRequest.Builder().build());


                showProgressBar();
                new EndpointsAsyncTask().execute(getActivity());
            }

        });

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


    /**
     * SHOWINTERSTITIAL - Will show the interstitial ad if it is ready to be shown. Otherwise, will
     * log an issue.
     */
    public void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d(TAG, "showInterstitial: The Ad was not ready");
        }
    }

}

