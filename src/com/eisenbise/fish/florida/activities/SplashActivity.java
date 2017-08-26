package com.eisenbise.fish.florida.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.eisenbise.fish.florida.views.SplashView;

public class SplashActivity extends Activity {

	SplashView splashView;
	
	static final int DISPLAY_TIME = 3000; 
	
	public SplashActivity() {
		super();
		
		
	}
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		splashView = new SplashView(this.getBaseContext());

        LinearLayout layout = new LinearLayout(this.getBaseContext());

        layout.addView(splashView);
		
        setContentView(layout);

        Thread splashThread = new Thread(new Timer());
        splashThread.start();
	}

	private void done() {
		finish();
	}
	
	class Timer implements Runnable {

		Timer() {
			super();
		}
		
		@Override
		public void run() {

			try {
				Thread.sleep(DISPLAY_TIME);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		done();	
		}
	}
}
