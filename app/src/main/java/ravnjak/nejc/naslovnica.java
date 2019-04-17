package ravnjak.nejc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class naslovnica extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load the selection view
        setContentView(R.layout.naslovnica);
        // togle full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    // function calls from the view --> starting the correct parts of the "game"
	public void sestevanje (View v) {
		 startActivity(new Intent("ravnjak.nejc.sest"));
		 finish();
	}
	
	public void odstevanje (View v) {
		 startActivity(new Intent("ravnjak.nejc.odst"));
		 finish();
	}
	
	public void mnozenje (View v) {
		 startActivity(new Intent("ravnjak.nejc.mnoz"));
		 finish();
	}
	
	public void deljenje (View v) {
		 startActivity(new Intent("ravnjak.nejc.delj"));
		 finish();
	}
	
	public void mesano (View v) {
		startActivity(new Intent("ravnjak.nejc.glavni"));
		finish();
	}
}
