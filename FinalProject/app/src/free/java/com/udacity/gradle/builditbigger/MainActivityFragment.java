package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

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

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                // This is a good place to load the next Interstitial
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

                // TODO: See if this works
                new EndpointsAsyncTask().execute(getActivity());
            }

        });

        return root;
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

