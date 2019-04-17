package ravnjak.nejc;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// class for multiplication part of the game
public class mnozenje extends Activity {
	int napake=0;
	int pravilni=0;
	int st_nalog=0;
	int res = 2;
	int c=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the correct view in the full screen
        setContentView(R.layout.program);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //start the chalange
        naloga();
    }

	public void preveri (View v) {
		// Check the rsult and proceed to the next chalange
		TextView nal = (TextView)findViewById(R.id.hint);
        nal.setTextColor(Color.WHITE);
        nal.setTextSize(1);
		EditText resitev=(EditText)findViewById(R.id.rezultat);
		
			res=Integer.parseInt(resitev.getText().toString());
		
		if(res==c)
			pravilni++;
		else
			napake++;
		st_nalog++;
		if(st_nalog==10){
			konec();
			return;
		}
		
		naloga();
	}
	
	public void konec(){
		// Show the result of the drill chalange
		setContentView(R.layout.statistika);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		TextView sta = (TextView)findViewById(R.id.statistika);
        sta.setTextColor(Color.BLACK);
        sta.setText("Pravilni: "+String.valueOf(pravilni)+" \n "+"Napaèni: " + String.valueOf(napake));
	}
	
	public void nazaj(View v){
		// return to the main page
		startActivity(new Intent("ravnjak.nejc.naslovnica"));
		finish();
	}
	
	public void naloga(){
		// set the chalange
		final Random naklju = new Random();
        int a=naklju.nextInt(100);
        int b=naklju.nextInt(100);
        EditText resitev=(EditText)findViewById(R.id.rezultat);
        resitev.setText("0");
        TextView nal = (TextView)findViewById(R.id.racun);
        nal.setTextColor(Color.BLACK);

        //calculate the chalange
        nal.setText(String.valueOf(a)+"*"+String.valueOf(b)+"=");
        c=a*b;

        // on long click show the solution
        Button gumb = (Button) findViewById(R.id.button1);
        gumb.setOnLongClickListener(new View.OnLongClickListener() {
			
			public boolean onLongClick(View v) {
				TextView nal = (TextView)findViewById(R.id.hint);
				nal.setText(String.valueOf(c));
		        nal.setTextColor(Color.BLACK);
		        nal.setTextSize(30);
				return false;
			}
		});
	}
}
