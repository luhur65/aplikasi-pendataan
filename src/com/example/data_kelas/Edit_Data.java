package com.example.data_kelas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Edit_Data extends Activity {

	private DBHelper MyDB;
	Button update;
	EditText eID, eNpm, eNama, eKelas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit__data);
		
		MyDB = new DBHelper(this);
		MyDB.openToWrite();
		
		eID = (EditText) findViewById(R.id.editID);
		eNpm = (EditText) findViewById(R.id.editNpm);
		eNama = (EditText) findViewById(R.id.editNama);
		eKelas = (EditText) findViewById(R.id.editKelas);
		
		update = (Button) findViewById(R.id.btnEdit);
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String Id = eID.getText().toString();
				String Npm = eNpm.getText().toString();
				String Nama = eNama.getText().toString();
				String Kelas = eKelas.getText().toString();
				MyDB.updateData(Id, Npm, Nama, Kelas);
				
				Toast.makeText(getApplicationContext(), "Berhasil Diedit!", Toast.LENGTH_SHORT).show();
			}
		});
		
	}

}
