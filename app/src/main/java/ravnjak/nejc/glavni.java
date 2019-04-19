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

// drill calculation for all the matematical functions
public class glavni extends Activity {
	int napake=0;
	int pravilni=0;
	int st_nalog=0;
	int res = 2;
	int c=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// set the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // start the calculation game
        naloga();
    }

	public void preveri (View v) {
		// check the result
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
		// present the finall ressults
		setContentView(R.layout.statistika);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		TextView sta = (TextView)findViewById(R.id.statistika);
        sta.setTextColor(Color.BLACK);
        sta.setText("Pravilni: "+String.valueOf(pravilni)+" \n "+"Napaèni: " + String.valueOf(napake));
	}
	
	public void nazaj(View v){
		//Back to main site
		startActivity(new Intent("ravnjak.nejc.naslovnica"));
		finish();
	}

	public void naloga(){
		// the main function of the drill game
		final Random naklju = new Random();
        int a=naklju.nextInt(100);
        int b=naklju.nextInt(100);
        int o=naklju.nextInt(3);
        EditText resitev=(EditText)findViewById(R.id.rezultat);
        resitev.setText("0");
        TextView nal = (TextView)findViewById(R.id.racun);
        nal.setTextColor(Color.BLACK);
        // select randomly witch calculation should be done and present it to the user
        if (o==0){
        	nal.setText(String.valueOf(a)+"+"+String.valueOf(b)+"=");
        	c=a+b;
        	
        	}
        if (o==1){
        	c=a+b;
        	nal.setText(String.valueOf(c)+"-"+String.valueOf(b)+"=");
        	c=a;
        	}
        if (o==2){
        	c=a*b;
        	nal.setText(String.valueOf(c)+"/"+String.valueOf(b)+"=");
        	c=a;
        	}
        if (o==3){
        	nal.setText(String.valueOf(a)+"*"+String.valueOf(b)+"=");
        	c=a*b;
        	}
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
