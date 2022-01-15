package com.example.data_kelas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toast;

public class MainActivity extends Activity {
	
	ListView xlv;
	String[] menu = {
		"Input data siswa", 
		"Lihat data",
		"Hapus data",
		"Edit data",
		"About",
		"Keluar"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		xlv = (ListView) findViewById(R.id.Lv);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, menu);
		xlv.setAdapter(adapter);
		xlv.setOnItemClickListener(new OnItemClickListener() {
			Intent i = null;
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				int index=arg2;
				
				switch (index) {
				case 0:
					i = new Intent(MainActivity.this, Input_Data.class);
					startActivity(i);
					break;
				case 1:
					i = new Intent(MainActivity.this, Lihat_Data.class);
					startActivity(i);
					break;
				case 2:
					i = new Intent(MainActivity.this, Hapus_Data.class);
					startActivity(i);
					break;
				case 3:
					i = new Intent(MainActivity.this, Edit_Data.class);
					startActivity(i);
					break;
				case 4:
					i = new Intent(MainActivity.this, About.class);
					startActivity(i);
					break;
				case 5:
					MainActivity.this.finish();
					break;

				default:
					break;
				}
			}
			
		});
		
	}

}
