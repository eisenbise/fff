package com.eisenbise.fish.florida.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuView extends LinearLayout {

    private TextView entry = null;
    private TextView entryText = null;
    
    public MenuView(Context context, String title, String dialogue, boolean expanded) {
        super(context);
        
        if (!title.equals("")) {
            this.setOrientation(VERTICAL);
            
            entry = new TextView(context);
            entry.setText(title);
            entry.setTextSize(30);
            
            addView(entry, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            
            entryText = new TextView(context);
            entryText.setText(dialogue);
            entryText.setTextSize(15);
            addView(entryText, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            
            entryText.setVisibility(expanded ? VISIBLE : GONE);
        } 
    }
    
}
