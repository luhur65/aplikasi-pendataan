package com.example.data_kelas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Input_Data extends Activity {
	
	private DBHelper MyDB;
	Button simpan;
	EditText iNpm, iNama, iKelas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input__data);
		
		MyDB = new DBHelper(this);
		MyDB.openToWrite();
		
		iNpm = (EditText) findViewById(R.id.inputNpm);
		iNama = (EditText) findViewById(R.id.inputNama);
		iKelas = (EditText) findViewById(R.id.inputKelas);
		
		simpan = (Button) findViewById(R.id.btnSimpan);
		simpan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String Npm = iNpm.getText().toString();
				String Nama = iNama.getText().toString();
				String Kelas = iKelas.getText().toString();
				
				// insert data
				MyDB.insert(Npm, Nama, Kelas);
				iNpm.setText("");
				iNama.setText("");
				iKelas.setText("");
				Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
