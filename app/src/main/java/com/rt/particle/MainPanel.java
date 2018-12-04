package com.rt.particle;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.accessibilityservice.*;

public class MainPanel extends SurfaceView implements SurfaceHolder.Callback
{
	private MainThread thread;

	Point touchPoint;
	
	ArrayList<Ball> balls;
	
	


	Context context;
	Display display;
	Ball ball;
	Ball temp;
	Lines line;
	int count;
	
	
	public MainPanel(Context context,Display display){
		super(context);
		this.context = context;
		getHolder().addCallback(this);
		this.display = display;
		touchPoint = new Point();
		balls = new ArrayList<>();
		line = new Lines(context);
		for(int i=0;i<1;i++){
				
				Ball b = new Ball(context);	
				balls.add(b);
		}		
		thread = new MainThread(getHolder(),this);

		setFocusable(true);
		
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
		thread = new MainThread(getHolder(),this);

		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){

		boolean retry = true;
		while(retry){
			try{
				thread.setRunning(false);
				thread.join();
			}	catch (Exception e) {	e.printStackTrace();}
			retry = false;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
			touchPoint.set((int)event.getX(),(int)event.getY());
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
					if(count<25){
							spawn(touchPoint.x,touchPoint.y);
					}
		
			break;
			case MotionEvent.ACTION_MOVE:
					

			break;
			case MotionEvent.ACTION_UP:
			
				
				

			break;
			


		}

		return true;
	}

	public void update(){
	   ifCollide();

	}
//particle molecular structure
	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);
		
		
			for(Iterator<Ball> iter =balls.iterator();iter.hasNext();){
				ball = iter.next();
				ball.draw(canvas);
				for(int i=0;i<balls.size();i++){
				temp = balls.get(i);
				//	pts[count].x= ball.x;
					//pts[count].y=ball.y;
			  canvas.drawLine(ball.x+ball.size/2,ball.y+ball.size/2,temp.x+temp.size/2,temp.y+temp.size/2,ball.mPaint);
				}
		}
	}
	// particles Only
/*
		@Override
		public void draw(Canvas canvas){
				super.draw(canvas);


				for(Iterator<Ball> iter =balls.iterator();iter.hasNext();){
						ball = iter.next();
						ball.draw(canvas);
								
				}
		}
		*/
	
	
	
	
	
	
	void ifCollide(){
			RectF temp = new RectF();
			for(Iterator<Ball> iter =balls.iterator();iter.hasNext();){
					Ball ball = iter.next();
					temp.set(ball.mBall);
					
			/*		while(iter.hasNext()){
							if(temp.contains(ball.mBall)){
									iter.remove();
							}
					}
				*/	
			
			
			if(ball.mBall.top<=0){
					ball.collided=true;
					ball.collide=0;
			}
			if(ball.mBall.right>=display.getWidth()){
					ball.collide=1;
					ball.collided=true;
			}
			if(ball.mBall.bottom>=display.getHeight()){
					ball.collide=2;
					ball.collided=true;
			}
			if(ball.mBall.left<=0){
					ball.collide=3;
					ball.collided=true;
			}
			
			
			}
	}
	
	void spawn(int x,int y){
			
			count++;
			
					Ball ball = new Ball(context);
					ball.setXY(x,y);
					balls.add(ball);
			
	}
}
