package com.example.projetandroid2015.tables;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ObjectEntry {
	// Database Table
	public static final String TABLE_NAME = "ObjectEntry";
	public static final String COLUMN_ID = "_id";
	public static final String VALUE = "value";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME
			+ "(" + COLUMN_ID + " INTEGER NOT NULL, " + VALUE
			+ " VARCHAR(50) NOT NULL, PRIMARY KEY (" + COLUMN_ID
			+ "), FOREIGN KEY (" + COLUMN_ID + ") REFERENCES Entry(" + COLUMN_ID
			+ "), FOREIGN KEY (" + VALUE + ") REFERENCES Object(" + COLUMN_ID
			+ "));";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(RootObjectTable.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
