package com.example.data_kelas;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class Lihat_Data extends ListActivity {
	
	private DBHelper MyDB;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> array_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lihat__data);
		
		MyDB = new DBHelper(this);
		MyDB.openToRead();
		
		array_list = MyDB.getAllList();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_list);
		setListAdapter(adapter);
		
	}
	
	public void onDestroy() {
		super.onDestroy();
		if (MyDB != null) {
			MyDB.close();
		} 
	}
}
