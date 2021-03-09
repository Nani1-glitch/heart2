/**
 * 
 */
package com.cam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Activity{
	EditText username,password,confirm,address,telephone,secretkey,serip;
	TextView submit;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.registration);
	        username=(EditText)findViewById(R.id.createuser);
	        password=(EditText)findViewById(R.id.createpass);
	        confirm=(EditText)findViewById(R.id.confirmpass);
	        address=(EditText) findViewById(R.id.editText1);
	        telephone=(EditText) findViewById(R.id.editText2);
	        secretkey=(EditText)findViewById(R.id.secretkey);
	        serip=(EditText)findViewById(R.id.serip);
	        submit=(TextView)findViewById(R.id.submit);
	        submit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String user=username.getText().toString();
					String pass=password.getText().toString();
					String confirmpass=confirm.getText().toString();
					String addr=address.getText().toString();
					String tele=telephone.getText().toString();
					String secret=secretkey.getText().toString();
					if(!(pass.equals(confirmpass))){
						Toast.makeText(getApplicationContext(),"password and confirm password did not matched", Toast.LENGTH_SHORT).show();
						password.setText("");
						confirm.setText("");
							}
					else if(!(user.length()>0 || pass.length()>0 || confirmpass.length()>0|| address.length()>0 || tele.length()>0 || secretkey.length()>0))
					{
						Toast.makeText(getApplicationContext(),"Enter data in all fields", Toast.LENGTH_SHORT).show();
					}
					else if(secretkey.length()!=16) {
						Toast.makeText(getApplicationContext(),"secret key must be of 16 bit length", Toast.LENGTH_SHORT).show();
					}
					else
					{
						try {
							Class.forName("com.mysql.jdbc.Driver");
							String ip=serip.getText().toString();
							Connection con=DriverManager.getConnection("jdbc:mysql://"+ip+":3306/heartdisease","root","password");
							PreparedStatement ps=con.prepareStatement("INSERT INTO register(username,password,address,telephone,secret) VALUES(?,?,?,?,?)");
							ps.setString(1,user);
							ps.setString(2,pass);
							ps.setString(3,addr);
							ps.setString(4, tele);
							ps.setString(5,secret);
							int i=ps.executeUpdate();
							if(i>0)
							{
								Toast.makeText(getApplicationContext(),"Account created successfully", Toast.LENGTH_SHORT).show();
								Intent intent=new Intent(getBaseContext(),Main.class);
								//intent.putExtra("username",user);
								startActivity(intent);
							}
						}
						catch (ClassNotFoundException e) {							
							Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
						} catch (SQLException e) {							
							Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
						}
					}
				}
			});
	    }

}
