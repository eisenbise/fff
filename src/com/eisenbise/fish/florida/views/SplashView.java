package com.eisenbise.fish.florida.views;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;

import com.eisenbise.fish.florida.R;

public class SplashView extends ImageView {

	public SplashView(Context context) {
	
		super(context);
	
		this.setImageResource(R.drawable.fff_logo_2_altered);
		this.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
		this.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}

	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		this.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.fff_logo));
//		canvas.drawColor(75);
	}

	/*
	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
	*/
}
