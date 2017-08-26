package com.eisenbise.fish.florida.activities;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.eisenbise.fish.florida.adapters.MenuAdapter;

public class MenuActivity extends ListActivity {

	MenuAdapter menuAdapter;
	
	public MenuActivity() {
		super();
	}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        menuAdapter = new MenuAdapter(this);
        setListAdapter(menuAdapter);
               
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) 
    {
      ((MenuAdapter)getListAdapter()).newSelection(position);

    }

}
