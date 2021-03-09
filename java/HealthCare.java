/**
 * 
 */
package com.cam;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HealthCare extends Activity{
	WebView web;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.result);
	        
	        //initializing web view
	        web=(WebView)findViewById(R.id.WebEngine);
	        String url=getIntent().getStringExtra("ip");
	        // specifying url
	        final String URL="http://"+url+":8080/HeartDisease/";
	                     
	        // loading url
	        web.loadUrl(URL);
	        
	        // getting webview settings
	        WebSettings settings=web.getSettings();
	        
	        // enabling javascript in web view
	        settings.setJavaScriptEnabled(true);
	        settings.setJavaScriptCanOpenWindowsAutomatically(true);
	        
	        web.setDownloadListener(new DownloadListener() {
				
				@Override
				public void onDownloadStart(String path, String userAgent,
						String contentDisposition, String mimetype, long contentLength) {
					try {
						Toast.makeText(getApplicationContext(), "download started", Toast.LENGTH_LONG).show();
						URL url = new URL(URL);
						System.out.println("}}}}}}"+path);
						InputStream ins = url.openStream();
						File rootDir = android.os.Environment.getExternalStorageDirectory();
						System.out.println("????????????"+rootDir.getAbsolutePath());
						File saveDir = new File(rootDir.getAbsolutePath()+"/healthcare/");
						if(!(saveDir.exists())) {
							saveDir.mkdir();
						}
						String filename = path.substring(path.lastIndexOf("/"));
						File file = new File(saveDir.getAbsolutePath(),filename);
						 OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			                for (int b; (b = ins.read()) != -1; ) {
			                	 out.write(b);
			                }
			                out.close();
						    ins.close();
						
						Toast.makeText(getApplicationContext(), "download finished", Toast.LENGTH_LONG).show();
					} catch (MalformedURLException e) {			
						e.printStackTrace();
					} catch (IOException e) {			
						e.printStackTrace();
					}
					
				}
			});
	        // load the updated url
	        web.setWebViewClient(new WebViewClient(){
	        	  public boolean shouldOverrideUrlLoading(WebView view, String url){
		    		  web.loadUrl(url); 
		    		  return true;
	        	  }	        	
	        });
	        web.requestFocus(View.FOCUS_DOWN);
	        web.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch(event.getAction())
					{
					
					case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                        if (!v.hasFocus())
                        {
                            v.requestFocus();
                        }
                        break;
					}
					return false;
				}
			});
	 }

}
