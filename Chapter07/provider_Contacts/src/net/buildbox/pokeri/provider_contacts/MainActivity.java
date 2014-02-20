package net.buildbox.pokeri.provider_contacts;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.support.v4.widget.SimpleCursorAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	// クエリで取得する項目
	private String[] CONTACTS_PROJECTION = new String[] {
			ContactsContract.CommonDataKinds.Phone._ID,
			ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
			ContactsContract.CommonDataKinds.Phone.NUMBER
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 連絡先の情報取得
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
				CONTACTS_PROJECTION, null, null, null);
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2,
				cursor,
				new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
				new int[] {android.R.id.text1, android.R.id.text2}, 0);
		
		ListView lv_contacts = (ListView) findViewById(R.id.lv_contacts);
		lv_contacts.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		ContentValues values = new ContentValues();
		
		switch (item.getItemId()) {
		case R.id.action_insert:	// 連絡先の追加
			// 連絡先の追加
			Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
			
			// 名前の設定
			long rawContactId = ContentUris.parseId(rawContactUri);
			values.clear();
			values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
			values.put(ContactsContract.Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
			values.put(StructuredName.DISPLAY_NAME, "Androidポケリ");
			getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
			
			// 自宅番号の設定
			Uri phoneUri = Uri.withAppendedPath(rawContactUri, ContactsContract.Contacts.Data.CONTENT_DIRECTORY);
			values.clear();
			values.put(Phone.TYPE, Phone.TYPE_HOME);
			values.put(Phone.IS_SUPER_PRIMARY, 1);
			values.put(ContactsContract.Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
			values.put(Phone.NUMBER, "0120345678");
			getContentResolver().insert(phoneUri, values);
			break;
			
		case R.id.action_update:	// 連絡先の更新
		
			break;
		
		case R.id.action_delete:	// 連絡先の削除
			
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
