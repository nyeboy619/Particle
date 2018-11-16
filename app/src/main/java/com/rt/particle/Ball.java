package com.rt.particle;

import android.content.*;
import android.graphics.*;
import java.util.*;

public class Ball
{
		RectF mBall;
		Context context;
		Random r;
		int x,y,width,height,direction,xVel,yVel;
		Paint mPaint;
		
		public Ball(Context context){
				this.context = context;
				r = new Random();
				x=r.nextInt(context.getResources().getDisplayMetrics().widthPixels);
				y=r.nextInt(context.getResources().getDisplayMetrics().heightPixels);
				mBall = new RectF();	
				direction = r.nextInt(3);
				mPaint = new Paint();
				mPaint.setAntiAlias(true);
				mPaint.setColor(Color.YELLOW);
				xVel= r.nextInt(10)+5;
				yVel= r.nextInt(10)+5;
				
				
				
				
		}
		
		public void draw(Canvas canvas){
				
				canvas.drawOval(mBall,mPaint);
				
				update();
		}
		public void update(){
				switch(direction){
						case 0:
								x-=xVel;
								y-=yVel;
								break;
						case 1:
								
				}
				
		}
		
		
}
