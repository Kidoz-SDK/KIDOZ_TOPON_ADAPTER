package com.kidoz.sdk.sample.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoListener;

public class SampleActivity extends Activity {

    private static String TAG = "SampleActivity";

    public static final String appid = "a5fa96afc6b5c7";
    public static final String appKey = "a8b845c24aa4c5dd7493597cd6426770";

    public static final String interstitialPlacement = "b5fa96b1d684e5";
    public static final String rewardedPlacement = "b5faa8e83006cb";
    public static final String bannerPlacement = "b5fabf0b320e7c";


    private TextView mFeedbackTV;
    private Button mInterstitialLoad;
    private Button mInterstitialShow;
    private Button mRewardedLoad;
    private Button mRewardedShow;
    private Button mBannerLoad;
    private Button mBannerClose;

    private ATInterstitial mInterstitialAd;
    private ATRewardVideoAd mRewardVideoAd;
    private ATBannerView mBannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sample);

        findViews();
        setButtons();

        ATSDK.init(getApplicationContext(), appid, appKey);

        initInterstitial();
        initRewarded();
        initBanner();

    }

    private void findViews() {
        mFeedbackTV = (TextView) findViewById(R.id.feedback_tv);
        mInterstitialLoad = (Button) findViewById(R.id.interstitial_load);
        mInterstitialShow = (Button) findViewById(R.id.interstitial_show);
        mRewardedLoad = (Button) findViewById(R.id.rewarded_load);
        mRewardedShow = (Button) findViewById(R.id.rewarded_show);
        mBannerLoad = (Button) findViewById(R.id.banner_load);
        mBannerClose = (Button) findViewById(R.id.banner_close);
    }


    private void setButtons() {
        mInterstitialLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInterstitialAd.load();
            }
        });

        mInterstitialShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInterstitialAd.show(SampleActivity.this);
            }
        });

        mRewardedLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRewardVideoAd.load();
            }
        });

        mRewardedShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRewardVideoAd.show(SampleActivity.this);
            }
        });

        mBannerLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBannerView.loadAd();
            }
        });

        mBannerClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBannerView != null) {
                    mBannerView.destroy();
                }
            }
        });
    }

    public void showFeedBackText(String text) {
        if (!TextUtils.isEmpty(text)) {
            mFeedbackTV.setText(text);
        }
    }

    private void initInterstitial() {

        mInterstitialAd = new ATInterstitial(this, interstitialPlacement);
        mInterstitialAd.setAdListener(new ATInterstitialListener() {

            @Override
            public void onInterstitialAdLoaded() {
                Log.i(TAG, "onInterstitialAdLoaded");
                Toast.makeText(SampleActivity.this, "onInterstitialAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdLoadFail(AdError adError) {
                Log.i(TAG, "onInterstitialAdLoadFail:\n" + adError.printStackTrace());
                Toast.makeText(SampleActivity.this, "onInterstitialAdLoadFail:" + adError.printStackTrace(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdClicked(ATAdInfo entity) {
                Log.i(TAG, "onInterstitialAdClicked:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onInterstitialAdClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdShow(ATAdInfo entity) {
                Log.i(TAG, "onInterstitialAdShow:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onInterstitialAdShow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdClose(ATAdInfo entity) {
                Log.i(TAG, "onInterstitialAdClose:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onInterstitialAdClose", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdVideoStart(ATAdInfo entity) {
                Log.i(TAG, "onInterstitialAdVideoStart:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onInterstitialAdVideoStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdVideoEnd(ATAdInfo entity) {
                Log.i(TAG, "onInterstitialAdVideoEnd:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onInterstitialAdVideoEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdVideoError(AdError adError) {
                Log.i(TAG, "onInterstitialAdVideoError:\n" + adError.printStackTrace());
                Toast.makeText(SampleActivity.this, "onInterstitialAdVideoError", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void initRewarded() {
        mRewardVideoAd = new ATRewardVideoAd(this, rewardedPlacement);
        mRewardVideoAd.setAdListener(new ATRewardVideoListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.i(TAG, "onRewardedVideoAdLoaded");
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdFailed(AdError errorCode) {
                Log.i(TAG, "onRewardedVideoAdFailed error:" + errorCode.printStackTrace());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdFailed:" + errorCode.printStackTrace(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayStart(ATAdInfo entity) {
                Log.i(TAG, "onRewardedVideoAdPlayStart:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdPlayStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayEnd(ATAdInfo entity) {
                Log.i(TAG, "onRewardedVideoAdPlayEnd:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdPlayEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayFailed(AdError errorCode, ATAdInfo entity) {
                Log.i(TAG, "onRewardedVideoAdPlayFailed error:" + errorCode.printStackTrace());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdPlayFailed:" + errorCode.printStackTrace(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed(ATAdInfo entity) {
                Log.i(TAG, "onRewardedVideoAdClosed:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayClicked(ATAdInfo entity) {
                Log.i(TAG, "onRewardedVideoAdPlayClicked:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onRewardedVideoAdPlayClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReward(ATAdInfo entity) {
                Log.e(TAG, "onReward:\n" + entity.toString());
                Toast.makeText(SampleActivity.this, "onReward", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initBanner(){
        mBannerView = new ATBannerView(this);
        mBannerView.setPlacementId(bannerPlacement);
        FrameLayout frameLayout = findViewById(R.id.adview_container);
        frameLayout.addView(mBannerView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, dip2px(300)));

        mBannerView.setBannerAdListener(new ATBannerListener() {
            @Override
            public void onBannerLoaded() {
                Log.i("BannerAdActivity", "onBannerLoaded");
                Toast.makeText(SampleActivity.this, "onBannerLoaded", Toast.LENGTH_SHORT).show();
                mBannerView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onBannerFailed(AdError adError) {
                Log.i("BannerAdActivity", "onBannerFailed：" + adError.printStackTrace());
                Toast.makeText(SampleActivity.this, "onBannerFailed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClicked(ATAdInfo entity) {
                Log.i("BannerAdActivity", "onBannerClicked:" + entity.toString());
                Toast.makeText(SampleActivity.this, "onBannerClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerShow(ATAdInfo entity) {
                Log.i("BannerAdActivity", "onBannerShow:"  + entity.toString());
                Toast.makeText(SampleActivity.this, "onBannerShow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClose(ATAdInfo entity) {
                Log.i("BannerAdActivity", "onBannerClose:"  + entity.toString());
                Toast.makeText(SampleActivity.this, "onBannerClose", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerAutoRefreshed(ATAdInfo entity) {
                Log.i("BannerAdActivity", "onBannerAutoRefreshed:"  + entity.toString());
            }

            @Override
            public void onBannerAutoRefreshFail(AdError adError) {
                Log.i("BannerAdActivity", "onBannerAutoRefreshFail");

            }
        });

    }

    public int dip2px(float dipValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
