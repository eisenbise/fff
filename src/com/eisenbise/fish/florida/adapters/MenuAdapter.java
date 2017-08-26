package com.eisenbise.fish.florida.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.eisenbise.fish.florida.R;
import com.eisenbise.fish.florida.views.MenuView;

public class MenuAdapter extends BaseAdapter {

	Activity parentActiviy;
	
	int currentSelection = -1;
	int previousSelection = -1;
	
	static final int elements = 2;
	
    private boolean isVisable[];

    String menuElements[];
    String menuEntries[];
	
	public MenuAdapter(Activity a) {
		super();

		parentActiviy = a;
		
		isVisable = new boolean[elements];
	    menuElements = new String[elements];
	    menuEntries = new String[elements];


	    menuElements[0] = "Disclaimer";
	    menuEntries[0] = parentActiviy.getBaseContext().getResources().getString(R.string.disclaimer);
	    
	    menuElements[1] = "Credits";
	    menuEntries[1] = parentActiviy.getBaseContext().getResources().getString(R.string.credits);
	    
		for (@SuppressWarnings("unused") boolean v: isVisable) {
			v = false;
		}
		
	
	}
	
	@Override
	public int getCount() {
		return elements;
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

        if (position >= elements) {
 
        	
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
            ret = new MenuView(
            		parentActiviy.getBaseContext(),
            		menuElements[position],
            		menuEntries[position],
            		isVisable[position]);
        }
        return ret;
    }
	
	// Called from main activity class when a selection is made.
    public void newSelection(int selection) {
        currentSelection = selection;
        notifyDataSetChanged();
    }
}
