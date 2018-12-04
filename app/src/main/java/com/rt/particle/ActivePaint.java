package com.rt.particle;

import android.graphics.*;

public class ActivePaint
{
		Paint mPaint;
		int distance;
		public ActivePaint(){
				mPaint = new Paint();
				mPaint.setAntiAlias(true);
				mPaint.setColor(Color.WHITE);
			
		}
		
		public void updateAlpha(int a,int b,int c,int d){
				distance =( Math.max(a,c)-Math.min(a,c))+(Math.max(b,d)-(Math.min(b,d)));
				if(distance>250){
						mPaint.setAlpha(0);
				}
				if(distance<250){
						mPaint.setAlpha(250-distance);
				}
						
				
		}
}
