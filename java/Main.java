package com.cam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
    /** Called when the activity is first created. */
	TextView t1,t2;
	final Context context=this;
	String ipvalue="";
	Intent intent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        SpannableString ss=new SpannableString("already have a aaccount?");
//        ss.setSpan(new StyleSpan(Typeface.BOLD),0,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(new URLSpan("tel:446523323"),13,17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t1=(TextView)findViewById(R.id.signin);
        t2=(TextView)findViewById(R.id.signup);
       
        //t1.setText(ss);
//        t1.setMovementMethod(LinkMovementMethod.getInstance());
        t1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			// get prompt dialog
			LayoutInflater li=LayoutInflater.from(context);
			View promptsview=li.inflate(R.layout.prompt,null);
			AlertDialog.Builder builder=new AlertDialog.Builder(context);
			builder.setView(promptsview);
			final EditText ip=(EditText)promptsview.findViewById(R.id.getip);			
			builder.setCancelable(false);
			builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					//
					//ipvalue="192.187";
					ipvalue=ip.getText().toString();	
					 final String URL="http://"+ipvalue+":8080/HeartDisease/";
					 Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(URL));
					//intent=new Intent(getBaseContext(),HealthCare.class);									
					//intent.putExtra("ip",ipvalue);	
					startActivity(intent);
				}
				
			});	
				
			AlertDialog dia=builder.create();
			dia.show();
			
			}
		});
        
        // on click for signup
        t2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent intent=new Intent(getBaseContext(),Register.class);
			startActivity(intent);
			}
		});
    }
}