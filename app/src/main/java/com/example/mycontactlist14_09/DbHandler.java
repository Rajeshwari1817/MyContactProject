package com.example.mycontactlist14_09;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    //all constants as they are static and final(Db=Database)
    //Db Version
    private static final int Db_Version=1;
    //Db Name
    private static final String Db_Name="users";
    //table name
    private static final String Table_Name="user";
    //Creating mycontacts Columns
    private static final String User_id="id";
    private static final String User_name="name";
    private static final String User_password="password";
    //constructor here
    public DbHandler(Context context)
    {
        super(context,Db_Name,null,Db_Version);
    }
    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
        String Create_Table="CREATE TABLE " + Table_Name + "(" + User_id
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + User_name + " TEXT," + User_password + " TEXT" + ")";
        db.execSQL(Create_Table);

    }
    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        //create the table again
        onCreate(db);
    }
    //Add new User by calling this method for signup
    public void addUser(String uname, String pass)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(User_name,uname);
        cv.put(User_password,pass);
        //inserting row
        db.insert(Table_Name, null, cv);
        //close the database to avoid any leak
        db.close();
    }
    //checking user sign class
    public boolean checkUser(String user,String pass)
    {
        int id=-1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id FROM user WHERE name=? AND password=?",new String[]{user,pass});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        if(id == -1)
            return false;
        else
            return true;
    }


}
