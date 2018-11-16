package com.rt.particle;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

public class MainPanel extends SurfaceView implements SurfaceHolder.Callback
{
	private MainThread thread;

	Point touchPoint;


	Context context;
	Display display;
	public MainPanel(Context context,Display display){
		super(context);

		this.context = context;
		getHolder().addCallback(this);
		
		this.display = display;
		touchPoint = new Point();
			
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

					
					
			break;
			case MotionEvent.ACTION_MOVE:

			break;
			case MotionEvent.ACTION_UP:
			
				
				

			break;
			


		}

		return true;
	}

	public void update(){
		

	}

	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);


	}
}
