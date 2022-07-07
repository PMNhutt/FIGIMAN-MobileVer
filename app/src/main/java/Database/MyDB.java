package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDB extends SQLiteOpenHelper {
    public MyDB(@Nullable Context context) {
        super(context, "FIGIMAN4", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table admin

//        String sql = "CREATE TABLE ADMIN(username Text primary key not null, " +
//                "password Text)";
//        db.execSQL(sql);
//        db.execSQL("INSERT INTO ADMIN values('Nhut', 123)");
//        db.execSQL("INSERT INTO ADMIN values('Admin 2', 111)");
//
//        //create user table
//        sql = "CREATE TABLE USER(username Text primary key not null, " +
//                "password Text)";
//        db.execSQL(sql);
//        db.execSQL("INSERT INTO USER values('user1', 123)");
//        db.execSQL("INSERT INTO USER values('user2', 111)");

        String tblRoles = "CREATE TABLE \"ROLES\" ( \"RoleId\"\tINTEGER NOT NULL, \"RoleName\"\tTEXT NOT NULL UNIQUE, PRIMARY KEY(\"RoleId\") )";
        String tblAccounts = "CREATE TABLE \"ACCOUNTS\" ( \"UserId\"\tINTEGER NOT NULL, \"Username\"\tTEXT NOT NULL, \"Password\"\tTEXT NOT NULL, \"RoleId\"\tINTEGER NOT NULL DEFAULT 1, FOREIGN KEY(\"RoleId\") REFERENCES \"ROLES\"(\"RoleId\"), PRIMARY KEY(\"UserId\") )";
        String tblProducts = "CREATE TABLE \"PRODUCTS\" (\"ProductId\"\tINTEGER NOT NULL, " +
                "\"ProductName\"\tTEXT NOT NULL, " +
                "\"Price\"\tNUMERIC NOT NULL DEFAULT 10000 CHECK(\"Price\" > 1000), " +
                "\"Quantity\"\tINTEGER NOT NULL DEFAULT 0 CHECK(\"Quantity\" > 0), " +
                "\"SoldQuantity\"\tINTEGER NOT NULL DEFAULT 0 CHECK(\"SoldQuantity\" > 0), " +
                "\"Description\"\tTEXT, " +
                "\"Category\"\tTEXT, " +
                "\"Company\"\tTEXT, " +
                "\"Material\"\tTEXT, " +
                "\"Size\"\tTEXT, " +
                "\"Image\"\tTEXT, " +
                "PRIMARY KEY(\"ProductId\"));";

        db.execSQL(tblProducts);
        db.execSQL(tblRoles);
        db.execSQL(tblAccounts);

        db.execSQL("INSERT INTO ROLES VALUES(1, 'USER')");
        db.execSQL("INSERT INTO ROLES VALUES(2, 'ADMIN')");

        db.execSQL("INSERT INTO ACCOUNTS(UserId, Username, Password, RoleId) VALUES(1, 'user', 'user', 1)");
        db.execSQL("INSERT INTO ACCOUNTS(UserId, Username, Password, RoleId) VALUES(2, 'admin', 'admin', 2)");

        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Giyu Tomioka Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC', '15cm', 'pro1');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Hatake Kakashi Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro2');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Katsuki Bakugo Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro3');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Kyojuro Rengoku Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro4');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Nobara Kugisaki Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro5');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Megumi Fushiguro Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro6');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Satoru Gojo Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro7');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Shinobu Kocho Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro8');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Sukuna Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro9');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Yuji Itadori Nendoroid', 515000, 20 , 12,'Mô hình đẹp phù hợp với mọi lứa tuổi','Anime', 'HotToys', 'ABS, PVC','15cm', 'pro10');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ACCOUNTS");
        db.execSQL("DROP TABLE IF EXISTS ROLES");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");
        onCreate(db);
    }
}
