package eric.siemens;

import java.io.*;
import java.net.*;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




public class SiemensActivity extends Activity {	
    Switch r = new Switch();
    
    private static  String IP_ADDRESS;
    private static int PORT; 
    private    OutputStream dout;
    
    //Create a socket that listens to a port

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	
		
    	 
        Button confirm = (Button)findViewById(R.id.Ok);
        confirm.setOnClickListener(onSave);
       
			
        
        
    }
    
    private View.OnClickListener onSave = new View.OnClickListener() {
    	
    	public void onClick(View arg0) {        			
        	

    		TextView ipaddress = (TextView) findViewById(R.id.IPaddressField);
    		TextView portnumber =  (TextView) findViewById(R.id.PortField);
    		
    		//The ip address and the port of the connection
    		IP_ADDRESS = ipaddress.getText().toString();
    		PORT =  32;
        	
        	RadioGroup groups= (RadioGroup) findViewById(R.id.types);
        	
        	 try {
           		
           		Socket s = new Socket("192.168.43.68",8001);
            		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
          		writer.write("ON");
          		s.close();
           	
           	    
           	 }
           	catch(IOException io){
           		io.printStackTrace();
           	}
           	catch(Exception io){
           		io.printStackTrace();
           	}
    
    	}  	
  };
}
 
