/*
 * Copyright (C) 2012 Jonathan Eisenbise
 *
 * Software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 * 
 */

package com.eisenbise.fish.florida.activities;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.eisenbise.fish.florida.adapters.InfoAdapter;
import com.eisenbise.fish.florida.adapters.MenuAdapter;

/**
 * Class: FullFledgedFishing
 */
public class FullFledgedFishing extends ListActivity {
	
	InfoAdapter infoAdapter;
	MenuAdapter menuAdapter;
	
    public FullFledgedFishing() {
        super();        
    }

    /** Called with the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // TODO - We'll come back to this...
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        
        infoAdapter = new InfoAdapter(this);
        setListAdapter(infoAdapter);
               
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) 
    {
      ((InfoAdapter)getListAdapter()).newSelection(position);

    }
        
    /**
     * Called when the activity is about to start interacting with the user.
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Called when your activity's options menu needs to be created.
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        //this.setContentView(R.layout.fish_entry_old);
        // TODO - Update what happens when we press the menu.
        // Look into the menu class and addSubMenu options.
        //menu.add(getResources().getString(R.string.disclaimer));
        //this.setContentView(getListView());
        
        Intent intent = new Intent(this, MenuActivity.class);
        this.startActivity(intent);
        return true;
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	return super.onCreateOptionsMenu(menu);
    }


}