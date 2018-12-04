package com.rt.particle;

import android.content.*;
import android.graphics.*;
import java.util.*;

public class Ball
{
		RectF mBall;
		Context context;
		Random r;
		int x,y,width,height,direction,xVel,yVel,collide,size,time;
		Paint mPaint;

		boolean collided;
		
		public Ball(Context context){
				this.context = context;
				r = new Random();
				//size = r.nextInt(100);
				size =5;
				
				
			x=r.nextInt(context.getResources().getDisplayMetrics().widthPixels);
			  y=r.nextInt(context.getResources().getDisplayMetrics().heightPixels);
				mBall = new RectF(x,y,size,size);	
				direction = r.nextInt(3);
				
				mPaint = new Paint();
				mPaint.setAntiAlias(true);
				mPaint.setStrokeWidth(r.nextInt(1));
				mPaint.setColor(Color.rgb( r.nextInt(255)+200,r.nextInt(255)+200,r.nextInt(255)+200));
				xVel= r.nextInt(2)+1;
				yVel= r.nextInt(2)+1;
				
				
				
				
				
		}
		
		public void draw(Canvas canvas){
				
				update();
				
				canvas.drawOval(mBall,mPaint);
				
				
				
				checkCollision();
				
		}
		public void update(){
				time++;
				
				
				
						if(direction==0){
								x-=xVel;
								y-=yVel;
								}
				if(direction==1){
								x+=xVel;
								y-=yVel;
								}
				if(direction==2){
								x+=xVel;
								y+=yVel; 
								}
				if(direction==3){
								x-=xVel;
								y+=yVel;
								}
				
				mBall.set(x,y,size+x,size+y);
				
		}
		
		public void checkCollision(){
				if(collided){
						//mPaint.setAlpha(r.nextInt(50)+100);
				if(collide==0){
						if(direction==0){
								direction=3;
						}
						if(direction==1){
								direction=2;
						}
				}
				if(collide==1){
						if(direction==2){
								direction=3;
						}
						if(direction==1){
								direction=0;
						}
				}
				if(collide==2){
						if(direction==3){
								direction=0;
						}
						if(direction==2){
								direction=1;
						}
				}
				if(collide==3){
						if(direction==0){
								direction=1;
						}
						if(direction==3){
								direction=2;
						}
				}
				
				collided=false;
				}
				
		}
		void setXY(int x, int y){
				this.x=x;
				this.y=y;
				mBall.set(x,y,size+x,size+y);
		}
		
		
}
