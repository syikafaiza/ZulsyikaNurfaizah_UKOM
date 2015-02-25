package app.healthcompanion.heco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zulsyika Nurfaizah on 2/15/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "heco.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME1      = "heco";
    public static final String TABLE_NAME2      = "login";

    public static final String COLUMN_ID       = "_id";
    public static final String COLUMN_SAKIT    = "sakit";
    public static final String COLUMN_LIHAT    = "anjuran";
    public static final String COLUMN_GEJALA1  = "gejala1";
    public static final String COLUMN_GEJALA2  = "gejala2";
    public static final String COLUMN_GEJALA3  = "gejala3";
    public static final String COLUMN_GEJALA4  = "gejala4";
    public static final String COLUMN_GEJALA5  = "gejala5";
    public static final String COLUMN_HERBAL   = "herbal";
    public static final String COLUMN_SINTETIS = "sintetis";
    public static final String COLUMN_TIPS     = "tips";

    public static final String COLUMN_UNAME    = "uname";
    public static final String COLUMN_PASS     = "pass";

    public static final String CREATE_TABLE_HECO =
            "create table if not exists " + TABLE_NAME1 + " (" + COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_SAKIT + " text, " + COLUMN_LIHAT + " text, " + COLUMN_GEJALA1 + " text, " +
                    COLUMN_GEJALA2 + " text, " +COLUMN_GEJALA3 + " text, " + COLUMN_GEJALA4 + " text, " +
                    COLUMN_GEJALA5 + " text, " + COLUMN_HERBAL + " text, " + COLUMN_SINTETIS + " text, " + COLUMN_TIPS + " text)";

    public static final String CREATE_TABLE_LOGIN =
            "create table if not exists " + TABLE_NAME2 + " (" + COLUMN_UNAME + " text, " + COLUMN_PASS + " text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TOO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE_HECO);
        db.execSQL(CREATE_TABLE_LOGIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w(DatabaseHelper.class.getName(), "Upgrading database from" +
                oldVersion + " to " + newVersion +
                ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public void save(Heco heco) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LIHAT, heco.getLihat());
        values.put(COLUMN_GEJALA1, heco.getGejala1());
        values.put(COLUMN_GEJALA2, heco.getGejala2());
        values.put(COLUMN_GEJALA3, heco.getGejala3());
        values.put(COLUMN_GEJALA4, heco.getGejala4());
        values.put(COLUMN_GEJALA5, heco.getGejala5());
        values.put(COLUMN_HERBAL, heco.getHerbal());
        values.put(COLUMN_SINTETIS, heco.getSintetis());
        values.put(COLUMN_TIPS, heco.getTips());

        db.insert(TABLE_NAME1, null, values);
        db.close();
    }

    public void update(Heco heco) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LIHAT, heco.getLihat());
        values.put(COLUMN_GEJALA1, heco.getGejala1());
        values.put(COLUMN_GEJALA2, heco.getGejala2());
        values.put(COLUMN_GEJALA3, heco.getGejala3());
        values.put(COLUMN_GEJALA4, heco.getGejala4());
        values.put(COLUMN_GEJALA5, heco.getGejala5());
        values.put(COLUMN_HERBAL, heco.getHerbal());
        values.put(COLUMN_SINTETIS, heco.getSintetis());
        values.put(COLUMN_TIPS, heco.getTips());

        db.update(TABLE_NAME1, values, COLUMN_ID + " = " + heco.getId(), null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME1, COLUMN_ID + " = " + id, null);

    }

    public Heco getHeco(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME1, new String[]{COLUMN_ID, COLUMN_LIHAT, COLUMN_SAKIT,
                        COLUMN_GEJALA1, COLUMN_GEJALA2, COLUMN_GEJALA3, COLUMN_GEJALA4, COLUMN_GEJALA5,
                        COLUMN_HERBAL, COLUMN_SINTETIS, COLUMN_TIPS}, COLUMN_ID + " + " + id, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Heco heco = new Heco();
        heco.setId(Integer.parseInt(cursor.getString(0)));
        heco.setSakit(cursor.getString(1));
        heco.setLihat(cursor.getString(2));
        heco.setGejala1(cursor.getString(3));
        heco.setGejala2(cursor.getString(4));
        heco.setGejala3(cursor.getString(5));
        heco.setGejala4(cursor.getString(6));
        heco.setGejala5(cursor.getString(7));
        heco.setHerbal(cursor.getString(8));
        heco.setSintetis(cursor.getString(9));
        heco.setTips(cursor.getString(10));
        return heco;
    }

    public List<Heco> getAllHeco() {
        List<Heco> listheco = new ArrayList<>();
        String selectQueary = "SELECT * FROM " + TABLE_NAME1;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueary, null);

        if (cursor.moveToFirst()) {
            do {
                Heco heco = new Heco();
                heco.setId(Integer.parseInt(cursor.getString(0)));
                heco.setSakit(cursor.getString(1));
                heco.setLihat(cursor.getString(2));
                heco.setGejala1(cursor.getString(3));
                heco.setGejala2(cursor.getString(4));
                heco.setGejala3(cursor.getString(5));
                heco.setGejala4(cursor.getString(6));
                heco.setGejala5(cursor.getString(7));
                heco.setHerbal(cursor.getString(8));
                heco.setSintetis(cursor.getString(9));
                heco.setTips(cursor.getString(10));

                listheco.add(heco);
            }
            while (cursor.moveToNext());
        }
        return listheco;
    }

    public void insert(String uname, String kpass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_UNAME, uname);
        values.put(COLUMN_PASS, kpass);
        db.insert(TABLE_NAME2, null, values);
    }

    public String getSignInId (String uname) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME2, null, "uname=?", new String[]{uname}, null, null, null);
        if (cursor.getCount()<1) {
            cursor.close();
            return "NOT EXIST";
        }

        cursor.moveToFirst();
        String pass = cursor.getString(cursor.getColumnIndex("pass"));
        cursor.close();
        return pass;
    }
}
