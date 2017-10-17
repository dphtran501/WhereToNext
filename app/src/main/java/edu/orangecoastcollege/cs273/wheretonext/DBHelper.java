package edu.orangecoastcollege.cs273.wheretonext;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class DBHelper extends SQLiteOpenHelper {

    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    static final String DATABASE_NAME = "WhereToNext";
    private static final String DATABASE_TABLE = "Colleges";
    private static final int DATABASE_VERSION = 1;


    //TASK 2: DEFINE THE FIELDS (COLUMN NAMES) FOR THE TABLE
    private static final String KEY_FIELD_ID = "_id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_POPULATION = "population";
    private static final String FIELD_TUITION = "tuition";
    private static final String FIELD_RATING = "rating";
    private static final String FIELD_IMAGE_NAME = "image_name";


    public DBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase database){

        // Write code to create the database
        String createTable = "CREATE TABLE " + DATABASE_TABLE
                + "(" + KEY_FIELD_ID + "INTEGER PRIMARY KEY,"
                + FIELD_NAME + "TEXT,"
                + FIELD_POPULATION + "INTEGER,"
                + FIELD_TUITION + "REAL,"
                + FIELD_RATING + "REAL,"
                + FIELD_IMAGE_NAME + "TEXT";
        database.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {

        // Write code to upgrade the database
        database.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
        onCreate(database);

    }

    //********** DATABASE OPERATIONS:  ADD, GETALL

    public void addCollege(College college) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // TODO:  Write code to add a College to the database
        // TODO:  Return the id assigned by the database
    }

    public ArrayList<College> getAllColleges() {
        ArrayList<College> collegeList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        // TODO:  Write the code to get all the colleges from the database.

        return collegeList;
    }







}
