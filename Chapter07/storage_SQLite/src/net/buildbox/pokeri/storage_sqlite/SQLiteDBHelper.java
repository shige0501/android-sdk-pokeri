package net.buildbox.pokeri.storage_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper extends SQLiteOpenHelper {
	private static SQLiteDBHelper instance = null;
	
	private static final String DB_NAME = "pokeri.db";	// DB名
	private static final int    DB_VERSION = 1;			// バージョン
	public static final String DB_TABLE = "tblBooks";
	
	public static final String[] POKERI_PROJECTION = new String[] {
		"_id",
		"book",
		"type"
	};
	
	public static SQLiteDBHelper getInstance(Context context) {
		if (instance == null) {
			instance = new SQLiteDBHelper(context);
		}
		
		return instance;
	}
	
	public SQLiteDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// テーブルの生成
		db.execSQL("create table if not exists "
				+ DB_TABLE
				+ "(_id integer primary key autoincrement, "
				+ "book text, "
				+ "type text)");
		
		// 初期データの登録
		db.execSQL("insert into " + DB_TABLE + "(book, type) values ('Android SDKポケリ', '書籍');");
		db.execSQL("insert into " + DB_TABLE + "(book, type) values ('Software　Design', '雑誌');");
		db.execSQL("insert into " + DB_TABLE + "(book, type) values ('Android技術者養成読本', 'ムック本');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// テーブルの再生成処理を実施
		db.execSQL("drop table if exists " + DB_TABLE);
		onCreate(db);
	}
}
