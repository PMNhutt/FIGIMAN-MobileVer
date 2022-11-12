package DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Database.MyDB;
import Model.Cart;

public class CartDAO {
    MyDB myDB;

    public CartDAO (Context context) {
        this.myDB = new MyDB(context);
    }

    public List<Cart> getAllCarts() {
        List<Cart> list = new ArrayList<>();
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from CARTS", null);
        if (cs != null && cs.getCount() > 0) {
            cs.moveToFirst();
            while (!cs.isAfterLast()) {
                int cartId = cs.getInt(0);
                int userId = cs.getInt(1);
                int isPaid = cs.getInt(2);
                String productName = cs.getString(3);
                String img = cs.getString(4);
                Double quantity = cs.getDouble(5);

//                list.add(new Cart(cartId, userId, isPaid));
                cs.moveToNext();
            }
        }
        cs.close();
        db.close();
        return list;
    }
}
