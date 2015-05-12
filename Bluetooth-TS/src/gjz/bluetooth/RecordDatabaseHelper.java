package gjz.bluetooth;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class RecordDatabaseHelper extends SQLiteOpenHelper {
	 private static final String DB_NAME = "record.sqlite";
	    private static final int VERSION = 1;
	    
	    private static final String TABLE_record = "record";
	    private static final String COLUMN_RECORD_ID = "_id";
	    private static final String COLUMN_RECORD_PT = "pt";
	    private static final String COLUMN_RECORD_X = "x";
	    private static final String COLUMN_RECORD_Y = "y";
	    private static final String COLUMN_RECORD_Z = "z";
	    private Context mContext;
	    public RecordDatabaseHelper(Context context,String name, CursorFactory
	    		factory, int version) {
	    	super(context, name, factory, version);
	    	mContext = context;
	    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table record (_id integer primary key autoincrement, pt string, x string, y string,z string,cequ string,ceduan string)");
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
//	 public long insertPoint(String pt,String x, String y,String z) {
//	        ContentValues cv = new ContentValues();
//	        cv.put(COLUMN_RECORD_PT,pt);
//	        cv.put(COLUMN_RECORD_X,x);
//	        cv.put(COLUMN_RECORD_Y,y);
//	        cv.put(COLUMN_RECORD_Z,z);
//	        return getWritableDatabase().insert(TABLE_record, null, cv);
//	    }

}
