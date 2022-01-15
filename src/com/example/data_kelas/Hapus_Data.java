package com.example.data_kelas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Hapus_Data extends Activity {
	
	private DBHelper MyDB;
	Button hapus;
	EditText xID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hapus__data);
		
		xID = (EditText) findViewById(R.id.eHapus);
		MyDB = new DBHelper(this);
		MyDB.openToWrite();
		
		hapus = (Button) findViewById(R.id.btnHapus);
		hapus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String Id = xID.getText().toString();
				MyDB.deleteData(Id);
				Toast.makeText(getApplicationContext(), "Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
				xID.setText("");
			}
		});
		
	}

}
