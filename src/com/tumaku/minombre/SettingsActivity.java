/*
Written by Javier Montaner montanerj@yahoo.com

This software is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

*/

package com.tumaku.minombre;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SettingsActivity extends Activity {

	  private static Button btnOk, btnReset, btnCancel;

	  private static EditText nameText, surname1Text, surname2Text;
	  
	  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        btnOk = (Button) findViewById(R.id.ok);					
        btnReset = (Button) findViewById(R.id.reset);					
        btnCancel = (Button) findViewById(R.id.cancel);					
        nameText = (EditText) findViewById(R.id.nameString);
        surname1Text = (EditText) findViewById(R.id.surname1String);
        surname2Text = (EditText) findViewById(R.id.surname2String);
	    SharedPreferences settings = getSharedPreferences(getString(R.string.prefsFile), 0);        
        nameText.setText(settings.getString(getString(R.string.name), ""));
        surname1Text.setText(settings.getString(getString(R.string.surname1), ""));
        surname2Text.setText(settings.getString(getString(R.string.surname2), ""));	
        
        
        btnOk.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(getString(R.string.prefsFile), 0);
                SharedPreferences.Editor editor = settings.edit();
            	editor.putString(getString(R.string.name),nameText.getText().toString());
            	editor.putString(getString(R.string.surname1),surname1Text.getText().toString());
            	editor.putString(getString(R.string.surname2),surname2Text.getText().toString());
                editor.commit();
                setResult(Activity.RESULT_OK);
                finish();
                return;
            }
          });
		   
		btnReset.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		    	resetValues();
		    }
          });        

		btnCancel.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
				finish();
				return;		    	
		    }
          });        		
    }
    
    private void resetValues() {
    	nameText.setText(R.string.defaultName);
    	surname1Text.setText(R.string.defaultSurname1);
    	surname2Text.setText(R.string.defaultSurname2);
    }
	
	
}