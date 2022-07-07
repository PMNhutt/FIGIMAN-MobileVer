package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Database.MyDB;
import Model.Admin;
import Model.User;

public class UserDAO {
    MyDB myDB;

    public UserDAO(Context context) {
        this.myDB = new MyDB(context);
    }

    // check user
    public boolean Check(User user){
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from ACCOUNTS where Username=? and Password=?"
                , new String []{
                        user.getUsername(), user.getPass()
                });
        if (cs.getCount() <= 0){
            return false;
        }
        return  true;
    }

    //update pass
    public boolean UpdatePass(User user){
        SQLiteDatabase db = myDB.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", user.getPass());
        int row = db.update("ACCOUNTS", values, "Username=?", new String[]{
                user.getUsername()
        });

        return row > 0;
    }

    //read data
    public ArrayList<User> readAll(){
        ArrayList<User> data = new ArrayList<>();
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from ACCOUNTS", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String username = cs.getString(0);
            String password = cs.getString(1);
            data.add(new User(username, password));
            cs.moveToNext();
        }
        cs.close();

        return data;
    }

    //add
    public boolean create (User user) {
        SQLiteDatabase db = myDB.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("password", user.getPass());
        long row = db.insert("ACCOUNTS", null, values);
        return row > 0;
    }

    //delete
    public boolean delete(String user){
        SQLiteDatabase db = myDB.getReadableDatabase();
        int row = db.delete("ACCOUNTS", "Username=?", new String[]{
                user
        });
        return  row > 0;
    }
}
