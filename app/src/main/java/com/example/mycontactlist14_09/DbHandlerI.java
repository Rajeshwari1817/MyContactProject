package com.example.mycontactlist14_09;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandlerI {
/*    //all constants as they are static and final(Db=Database)
    //Db Version
    private static final int Db_Version=1;
    //Db Name
    private static final String Db_Name="users";
    //table name
    private static final String Table_Name="user_contacts";
    //Creating mycontacts Columns
    private static final String User_id="id";
    private static final String User_name="name";
    private static final String User_lname="lname";
    private static final String main_user_name="mainUser";

    private static final String User_email="email";
    private static final String User_ph="ph";
    //constructor here
    public DbHandlerI(Context context)
    {
        super(context,Db_Name,null,Db_Version);
    }
    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
        String Create_Table="CREATE TABLE " + Table_Name + "(" + User_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + main_user_name + " TEXT," + User_name + " TEXT,"+ User_lname + " TEXT," + User_email + " TEXT," + User_ph + " TEXT" + ")";
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
    public void addUser(String mainuser ,String uname,String lname, String email,String ph)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(User_id,usr.getId());
        cv.put(main_user_name,mainuser);
        cv.put(User_name,uname);
        cv.put(User_lname,lname);
        cv.put(User_email,email);
        cv.put(User_ph,ph);


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
    }*/


}
