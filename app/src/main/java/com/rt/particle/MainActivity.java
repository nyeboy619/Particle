package com.rt.particle;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;


public class MainActivity extends Activity 
{
		private MainPanel mainPanel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		Display display = getWindowManager().getDefaultDisplay();

			

		mainPanel = new MainPanel(this,display);
        setContentView(mainPanel);

    }


		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event)
		{
				// TODO: Implement this method
				if(keyCode==4){
			
						
						AlertDialog.Builder dialog = new AlertDialog.Builder(this);
						dialog.setCancelable(false).setTitle("Exit Game");
						dialog.setMessage("Are you sure you want to quit?");
						dialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
								@Override
								public void onClick(DialogInterface d, int e){
										Toast.makeText(getApplicationContext(),"GameOver!",Toast.LENGTH_LONG).show();
										onDestroy();
										finish();
								}
						});
						dialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
										@Override
										public void onClick(DialogInterface d, int e){
											
										}
								});
								dialog.show();

				}
				
				
				return super.onKeyDown(keyCode, event);
		}
		
}
