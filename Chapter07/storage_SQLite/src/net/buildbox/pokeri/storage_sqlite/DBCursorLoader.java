package net.buildbox.pokeri.storage_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBCursorLoader extends SimpleCursorLoader {

	public DBCursorLoader(Context context) {
		super(context);
	}

	@Override
	public Cursor loadInBackground() {
		SQLiteDBHelper dbHelper = SQLiteDBHelper.getInstance(getContext());
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(
				SQLiteDBHelper.DB_TABLE, SQLiteDBHelper.POKERI_PROJECTION, null, null, null, null, null, null);
		return cursor;
	}

}
