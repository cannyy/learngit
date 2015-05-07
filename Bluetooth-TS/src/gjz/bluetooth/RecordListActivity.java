package gjz.bluetooth;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class RecordListActivity extends Activity{
	private RecordDatabaseHelper dbHelper;

	private Cursor cursor = null;
	private SimpleCursorAdapter adapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dblist);
		ListView list = (ListView) findViewById(R.id.db_list1);
		dbHelper = new RecordDatabaseHelper(this, "Record.db", null, 1);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		cursor = db.rawQuery("SELECT _id,x,y,z from record ORDER BY pt", null);// ʹ��CursorAdapterʱ���������������_idΪ��������
		// ������һ�и�_id
		
		adapter = new SimpleCursorAdapter(this, R.layout.db_item, cursor,
				new String[] { "_id", "x", "y", "z" },// �α����ݵ����ƣ�ʵ����Table������
				new int[] { R.id.point, R.id.x, R.id.y, R.id.z });// ��Ӧ��UI΢����id
		list.setAdapter(adapter);
		

	}
}
