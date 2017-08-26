package com.eisenbise.fish.florida.views;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class FishView extends LinearLayout {
	
    @SuppressWarnings("unused")
	private ImageView fishImage = null;
    private TextView fishName = null;
    private TextView fishInfo = null;
    private AdView adView = null;
    
    public static final boolean adsEnabled = true;

    public FishView(Activity activity, String title, String dialogue, boolean expanded, int imageResource) {
        super(activity.getBaseContext());
        
        if (!title.equals("")) {
            Context context = activity.getBaseContext();
            this.setOrientation(VERTICAL);

            /*
            fishImage = new ImageView(context);
            fishImage.setImageResource(imageResource);
            addView(fishImage, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            */
            
            fishName = new TextView(context);
            fishName.setText(title);
            fishName.setTextSize(30);
            
            addView(fishName, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            
            fishInfo = new TextView(context);
            fishInfo.setText(dialogue);
            fishInfo.setTextSize(15);
            addView(fishInfo, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            
            fishInfo.setVisibility(expanded ? VISIBLE : GONE);

        } if (expanded && adsEnabled) {
        	 adView = new AdView(activity, AdSize.BANNER, "a14f4030c735ba1");	//AdRequest.TEST_EMULATOR);

             AdRequest adRequest = new AdRequest();
             adRequest.addTestDevice(AdRequest.TEST_EMULATOR);               	// Emulator
             adRequest.addTestDevice("34C06A4B8AFE57C7D19724DC977C9232");  		// Test Android Device
             // Initiate a generic request to load it with an ad
             adView.loadAd(adRequest);
             adView.setVisibility(VISIBLE);
             addView(adView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
    }
    
}