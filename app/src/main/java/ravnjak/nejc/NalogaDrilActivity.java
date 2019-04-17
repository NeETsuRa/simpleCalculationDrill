package ravnjak.nejc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class NalogaDrilActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the intro banner
        setContentView(R.layout.main);
        // define a thread so all the precesses can load
        Thread nit = new Thread(){
        	@Override
			public void run(){
        		try{
        			sleep(3000);
        			//After 3s load the main site
        			startActivity(new Intent("ravnjak.nejc.naslovnica"));
        		} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					finish();
        		}
        	}
        	
        };

        // run the thread
        nit.start();
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}