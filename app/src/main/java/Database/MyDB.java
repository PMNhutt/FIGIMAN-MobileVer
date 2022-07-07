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
                " VALUES('Giyu Tomioka Nendoroid', 355000, 20 , 12," +
                "'Giyu Tomioka từ Demon Slayer: Kimetsu no Yaiba sẽ tham gia Nendoroid Swacchao mới! hàng loạt! Nendoroid Swacchao! figure có Nendoroid đang ngồi trên ghế, giúp bạn dễ dàng trưng bày chúng trên bàn, kệ hoặc những khu vực chật hẹp về không gian. Các số liệu thậm chí có thể được hiển thị trên các cạnh của bàn hoặc kệ của bạn, vì vậy hãy tận hưởng thu thập và trưng bày chúng ở mọi nơi.'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC', '9 cm', 'pro1');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Hatake Kakashi Nendoroid', 425000, 20 , 12," +
                "'Từ loạt phim hoạt hình nổi tiếng Naruto Shippuden, Nendoroid của Kakashi Hatake từ thời của anh ấy trong Anbu Black Ops! Anh ấy đi kèm với hai tấm che mặt có thể hoán đổi cho nhau, một tấm che mặt tiêu chuẩn và một tấm che mặt lóa. Mặt nạ cáo của anh ấy cũng có thể tháo rời.'," +
                "'Anime', 'HotToys', 'ABS, PVC','9 cm', 'pro2');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Katsuki Bakugo Nendoroid', 520000, 20 , 12," +
                "'Từ loạt phim hoạt hình nổi tiếng My Hero Academia, Nendoroid của nhân vật chính là bạn thời thơ ấu của Deku và là đối thủ của Katsuki Bakugo trong trang phục mùa đông của anh ấy! Anh ấy có ba biểu cảm khuôn mặt bao gồm biểu cảm cười toe toét, biểu cảm chiến đấu và biểu cảm sửng sốt! Các bộ phận hiệu ứng để tái hiện Cú cười bùng nổ của anh ấy cùng với bảng chữ BOOOM cũng được bao gồm để tạo ra các tư thế hành động ấn tượng hơn nữa! Thích tạo tất cả các loại cảnh khác nhau từ bộ truyện!'," +
                "'Anime', 'Takara Tomy', 'ABS, PVC','10 cm', 'pro3');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Kyojuro Rengoku Nendoroid', 325000, 20 , 12," +
                "'Kyojuro Rengoku từ Demon Slayer: Kimetsu no Yaiba sẽ gia nhập Nendoroid Swacchao mới! hàng loạt! Nendoroid Swacchao! figure có Nendoroid đang ngồi trên ghế, giúp bạn dễ dàng trưng bày chúng trên bàn, kệ hoặc những khu vực chật hẹp về không gian. Các số liệu thậm chí có thể được hiển thị trên các cạnh của bàn hoặc kệ của bạn, vì vậy hãy tận hưởng thu thập và trưng bày chúng ở mọi nơi.'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro4');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Nobara Kugisaki Nendoroid', 325000, 20 , 12," +
                "'Nobara Kugisaki từ Jujutsi Kaisen sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro5');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Megumi Fushiguro Nendoroid', 325000, 20 , 12," +
                "'Megumi Fushiguro từ Jujutsi Kaisen sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro6');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Satoru Gojo Nendoroid', 325000, 20 , 12," +
                "'Satoru Gojo từ Jujutsi Kaisen sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro7');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Shinobu Kocho Nendoroid', 350000, 20 , 12," +
                "'Shinobu Kocho từ Demon Slayer: Kimetsu no Yaiba sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro8');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Sukuna Nendoroid', 350000, 20 , 12," +
                "'Sukuna từ Jujutsu Kaisen sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro9');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Yuji Itadori Nendoroid', 350000, 20 , 12," +
                "'Yuji Itadori từ Jujutsu Kaisen sẽ gia nhập Nendoroid Swacchao mới! hàng loạt!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','10 cm', 'pro10');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ACCOUNTS");
        db.execSQL("DROP TABLE IF EXISTS ROLES");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");
        onCreate(db);
    }
}
