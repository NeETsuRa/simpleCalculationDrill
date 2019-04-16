package ravnjak.nejc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class NalogaDrilActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Thread nit = new Thread(){
        	@Override
			public void run(){
        		try{
        			sleep(3000);
        			startActivity(new Intent("ravnjak.nejc.naslovnica"));
        		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					finish();
        			
        		}
        	}
        	
        };
        
        nit.start();
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
    
    

}