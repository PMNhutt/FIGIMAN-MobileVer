package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Database.MyDB;
import Model.Admin;
import Model.User;

public class AdminDAO {
    MyDB myDB;

    public AdminDAO(Context context) {
        this.myDB = new MyDB(context);
    }

    // check user
    public boolean Check(User user){
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from ADMIN where username=? and password=?"
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
        int row = db.update("ADMIN", values, "username=?", new String[]{
                user.getUsername()
        });

        return row > 0;
    }

    //read data
    public ArrayList<Admin> readAll(){
        ArrayList<Admin> data = new ArrayList<>();
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from ADMIN", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String username = cs.getString(0);
            String password = cs.getString(1);
            data.add(new Admin(username, password));
            cs.moveToNext();
        }
        cs.close();

        return data;
    }

    //add
    public boolean create (Admin admin) {
        SQLiteDatabase db = myDB.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", admin.getUsername());
        values.put("password", admin.getPass());
        long row = db.insert("ADMIN", null, values);
        return row > 0;
    }

    //delete
    public boolean delete(String user){
        SQLiteDatabase db = myDB.getReadableDatabase();
        int row = db.delete("ADMIN", "username=?", new String[]{
                user
        });
        return  row > 0;
    }
}
