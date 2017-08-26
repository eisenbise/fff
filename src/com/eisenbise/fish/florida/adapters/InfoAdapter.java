package com.eisenbise.fish.florida.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.eisenbise.fish.florida.R;
import com.eisenbise.fish.florida.views.FishView;


public class InfoAdapter extends BaseAdapter {
    Activity activity = null;
    int currentSelection = -1;
    
    private String fishName[];
    private String fishDescription[];
    private boolean isVisable[];
    int imageArray[] = new int[100];
    
    public InfoAdapter(Activity a) {
        
    	// The only reason we need the activity is for the AdView.
    	activity = a;

    	// Load the data for the fish.  All done through configuration 
    	// files.
        initFish(a.getBaseContext());
        
    }

    /*
     * Method: initFish
     * 
     * Description: Initializes the data for the fish.  All data is loaded
     * via the strings.xml file.
     */
    private void initFish(Context context) {
    	
    	// The fish name and the fish description are both loaded from the 
    	// strings.xml.  They are both loaded as string arrays, but they are
    	// not connected.  So order is very important.
        fishName = 
            context.getResources().getStringArray(R.array.fish_list);
        fishDescription = 
        	context.getResources().getStringArray(R.array.fish_description);
        
        //  Allows only one item to be viewable at a time.
        isVisable = new boolean[fishName.length];
        for (int i = 0; i < isVisable.length - 1 ; i++) {
            isVisable[i] = false;
        }
        
        // The images are not used at the moment due to licensing issues.  
        // If that ever gets resolved then this is how it would go.
        imageArray[0] = R.drawable.red_fish;
        imageArray[1] = R.drawable.spec;
        
    }
    
    @Override
    public int getCount() {
        return fishName.length + 1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        if (position >= fishName.length) {
        	
        	ret = new FishView(
        			activity,
        			"",
        			"",
        			true,
        			0);
        } else {
        	if (position == currentSelection) {
                if (isVisable[position] == true) {
                	isVisable[position] = false;
                } else { 
                	isVisable[position] = true;
                }
            } else {
                isVisable[position] = false;
            } 
            ret = new FishView(
                    activity, 
                    fishName[position],
                    fishDescription[position],
                    isVisable[position],
                    imageArray[position]);
        }
        return ret;
    }
    public void newSelection(int selection) {
        currentSelection = selection;
        notifyDataSetChanged();
    }
}
