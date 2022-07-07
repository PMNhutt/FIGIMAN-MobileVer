package DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Database.MyDB;
import Model.Product;

public class ProductDAO {
    MyDB myDB;

    public ProductDAO(Context context) {
        this.myDB = new MyDB(context);
    }

    public List<Product> getAllProducts(){
        List<Product> data = new ArrayList<>();
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from PRODUCTS", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int proId = cs.getInt(0);
            String name = cs.getString(1);
            Double price = cs.getDouble(2);
            Double quantity = cs.getDouble(3);
            Double soldQuantity = cs.getDouble(4);
            String description = cs.getString(5);
            String category = cs.getString(6);
            String company = cs.getString(7);
            String material = cs.getString(8);
            String size = cs.getString(9);
            String img = cs.getString(10);
            data.add(new Product(proId, name,price, quantity, soldQuantity,description,category,material,company,img, size));
            cs.moveToNext();
        }
        cs.close();

        return data;
    }

}
