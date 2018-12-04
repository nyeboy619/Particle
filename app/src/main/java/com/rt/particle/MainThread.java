package com.rt.particle;

import android.graphics.*;
import android.view.*;

public class MainThread extends Thread
{

	public static final int MAX_FPS = 30;
	private double averageFps;
	private SurfaceHolder surfaceHolder;
	private MainPanel mainPanel;
	private boolean running;
	public static Canvas canvas;

	public MainThread(SurfaceHolder surfaceHolder,MainPanel mainPanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.mainPanel = mainPanel;
	}

	public void setRunning(boolean running){
		this.running = running;
	}

	@Override
	public void run(){
		long startTime= 0;
		long timeMillis = 1000/MAX_FPS;
		long waitTime;
		int frameCount = 0;
		long totalTime = 0;
		long targetTime = 1000/MAX_FPS;

		while(running){
			startTime = System.nanoTime();
			canvas = null;

			try{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized(surfaceHolder){
					this.mainPanel.update();
					this.mainPanel.draw(canvas);
				}
			}	catch (Exception e)	{	e.printStackTrace();}
				finally {
					if(canvas != null){
						try{



						surfaceHolder.unlockCanvasAndPost(canvas);
					}	
					catch (Exception e) {e.printStackTrace();}

						

				}

			timeMillis = (System.nanoTime() - startTime)/1000000;
			waitTime = targetTime - timeMillis;
			try{
				if(waitTime > 0){
					this.sleep(waitTime+20);
				}
			}	catch(Exception e) { e.printStackTrace();}
			totalTime +=System.nanoTime() - startTime;
			frameCount++;
			if(frameCount == MAX_FPS){
				averageFps = 1000/((totalTime/frameCount)/1000000);
				frameCount = 0;
				totalTime = 0;
				System.out.println(averageFps);
			}
		}	
	}}
}
