package com.example.data_kelas;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper {
	
	public static final String DB_NAME = "Dbkelas";
	public static final String DB_TABLE = "kelas";
	public static final int DB_VERSION = 1;
	
	private SQLiteDatabase db;
	private SQLiteHelper DBhelper;
	private Context context;
	
	private static final String CREATE_TABLE = 
			"CREATE TABLE if not exists " + DB_TABLE +
			" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Npm Varchar(10), " +
			"Nama Varchar(50), Kelas Varchar(11));";
	
	public DBHelper(Context c) {
		context = c;
	}
	
	public DBHelper openToRead() throws android.database.SQLException {
		DBhelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
		db = DBhelper.getReadableDatabase();
		return this;
	}
	
	public DBHelper openToWrite() throws android.database.SQLException {
		DBhelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
		db = DBhelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		if (DBhelper != null) {
			DBhelper.close();	
		}
	}
	
	public boolean updateData(String Id, String Npm, String Nama, String Kelas) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("Npm", Npm);
		contentValues.put("Nama", Nama);
		contentValues.put("Kelas", Kelas);
		
		int result = db.update(DB_TABLE, contentValues, "ID=?", new String[]{Id});
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	};
	
	public Integer deleteData(String Id) {
		int i = db.delete(DB_TABLE, "ID=?", new String[]{Id});
		return i;
	}
	
	public long insert(String Npm, String Nama, String Kelas) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("Npm", Npm);
		contentValues.put("Nama", Nama);
		contentValues.put("Kelas", Kelas);
		return db.insert(DB_TABLE, null, contentValues);
	}
	
	public ArrayList<String> getAllList() {
		ArrayList<String> Lists = new ArrayList<String>();
		Cursor res = db.rawQuery("SELECT * FROM kelas", null);
		res.moveToFirst();
		
		while (res.isAfterLast() == false) {
			String x0 = res.getString(res.getColumnIndex("ID"));
			String x1 = res.getString(res.getColumnIndex("Npm"));
			String x2 = res.getString(res.getColumnIndex("Nama"));
			String x3 = res.getString(res.getColumnIndex("Kelas"));
			
			Lists.add("No. ID:"+x0+"\n"+"Npm :"+x1+"\n"+"Nama :"+x2+"\n"+"Kelas :"+x3);
			res.moveToNext();
		}
		
		return Lists;
	}
	
	public class SQLiteHelper extends SQLiteOpenHelper {
		public SQLiteHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(CREATE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
		}
		
	}

}


