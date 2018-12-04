package com.rt.particle;

import android.content.*;
import android.graphics.*;

public class Lines
{
		Context context;
		float points[] = {1,4,60,90,7,69,07,4};
		Paint mPaint;
		Path path;
		
		public Lines(Context context){
				this.context = context;
				
				path = new Path();
				path.setFillType(Path.FillType.EVEN_ODD);
				mPaint = new Paint();
				
				mPaint.setAntiAlias(true);
				mPaint.setColor(Color.WHITE);
				mPaint.setStrokeWidth(10);
		    mPaint.setStyle(Paint.Style.STROKE);
				
				
				
				
				
		}
		
		public void draw(Canvas canvas){
				//canvas.drawLines(pts,mPaint);
				
				canvas.drawPath(path,mPaint);
		}
		
		public void updatePath(Point[] pts){
				for(int i=0;i<pts.length;i++){
						if(i==0){
								path.moveTo(pts[i].x,pts[i].y);
						}
						if(i>0){
								path.lineTo(pts[i].x,pts[i].y);
								}
				}
		}
		
	
}
