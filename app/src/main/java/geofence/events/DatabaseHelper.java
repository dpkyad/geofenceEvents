package geofence.events;

// add your package name here

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    //Declare variables:
    public static final String DATABASE_NAME = "events.db";
    public static final String TABLE_NAME = "events_table";
    //each column in table:
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "SET_DATE_TIME"; //When the event was created - TEXT = YYYY-MM-DD HH:MM:SS
    public static final String COL_4 = "ACTIVE_START_DATE_TIME";
    public static final String COL_5 = "ACTIVE_END_DATE_TIME";
    public static final String COL_6 = "GPS_X";
    public static final String COL_7 = "GPS_Y";
    public static final String COL_8 = "RECIPIENTS"; //Not sure if we can make this an array or if we need 3 cols for 3 recipients
    public static final String COL_9 = "STATUS_SET";  //STATUS_... will be 0 = false or 1 = true, only one should be checked at a time
    public static final String COL_10 = "STATUS_ACTIVE";
    public static final String COL_11 = "STATUS_TRIGGERED";
    public static final String COL_12 = "STATUS_COMPLETED";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


        SQLiteDatabase db = this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT UNIQUE ON CONFLICT REPLACE," +
                COL_3 + " TEXT," +
                COL_4 + " TEXT," +
                COL_5 + " TEXT," +
                COL_6 + " REAL," +
                COL_7 + " REAL," +
                COL_8 + " TEXT," +
                COL_9 + " INTEGER," +
                COL_10 + " INTEGER," +
                COL_11 + " INTEGER," +
                COL_12 + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public boolean insertData(String title,String setDateTime,String startDateTime, String endDateTime,
                              double gpsX, double gpsY, String recipients, boolean statusSet, boolean statusActive, boolean statusTriggered, boolean statusComplete) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,setDateTime);
        contentValues.put(COL_4,startDateTime);
        contentValues.put(COL_5,endDateTime);
        contentValues.put(COL_6,gpsX);
        contentValues.put(COL_7,gpsY);
        contentValues.put(COL_8,recipients);
        contentValues.put(COL_9,statusSet);
        contentValues.put(COL_10,statusActive);
        contentValues.put(COL_11,statusTriggered);
        contentValues.put(COL_12,statusComplete);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id, String title,String setDateTime,String startDateTime, String endDateTime,
                              double gpsX, double gpsY, String recipients, boolean statusSet, boolean statusActive, boolean statusTriggered, boolean statusComplete) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,setDateTime);
        contentValues.put(COL_4,startDateTime);
        contentValues.put(COL_5,endDateTime);
        contentValues.put(COL_6,gpsX);
        contentValues.put(COL_7,gpsY);
        contentValues.put(COL_8,recipients);
        contentValues.put(COL_9,statusSet);
        contentValues.put(COL_10,statusActive);
        contentValues.put(COL_11,statusTriggered);
        contentValues.put(COL_12,statusComplete);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    String TAG = "DbHelper";
    // functions omitted


    /**
     * Helper function that parses a given table into a string
     * and returns it for easy printing. The string consists of
     * the table name and then each row is iterated through with
     * column_name: value pairs printed out.
     *
     * @param db the database to get the table from
     * @param tableName the the name of the table to parse
     * @return the table tableName as a string
     *
     * This helper function is copied from the following Stack Overflow post:
     * https://stackoverflow.com/questions/27003486/printing-all-rows-of-a-sqlite-database-in-android
     *
     * It is used simply to easily print entries from our Database to help test
     * if our database was set up properly.
     */
    public String getTableAsString(SQLiteDatabase db, String TABLE_NAME) {
        Log.d(TAG, "getTableAsString called");
        String tableString = String.format("Table %s:\n", TABLE_NAME);
        Cursor allRows  = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name: columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }

        return tableString;
    }







}