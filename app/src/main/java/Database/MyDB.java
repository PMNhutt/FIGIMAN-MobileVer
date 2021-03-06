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
                "'Giyu Tomioka t??? Demon Slayer: Kimetsu no Yaiba s??? tham gia Nendoroid Swacchao m???i! h??ng lo???t! Nendoroid Swacchao! figure c?? Nendoroid ??ang ng???i tr??n gh???, gi??p b???n d??? d??ng tr??ng b??y ch??ng tr??n b??n, k??? ho???c nh???ng khu v???c ch???t h???p v??? kh??ng gian. C??c s??? li???u th???m ch?? c?? th??? ???????c hi???n th??? tr??n c??c c???nh c???a b??n ho???c k??? c???a b???n, v?? v???y h??y t???n h?????ng thu th???p v?? tr??ng b??y ch??ng ??? m???i n??i.'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC', '9 cm', 'pro1');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Hatake Kakashi Nendoroid', 425000, 20 , 12," +
                "'T??? lo???t phim ho???t h??nh n???i ti???ng Naruto Shippuden, Nendoroid c???a Kakashi Hatake t??? th???i c???a anh ???y trong Anbu Black Ops! Anh ???y ??i k??m v???i hai t???m che m???t c?? th??? ho??n ?????i cho nhau, m???t t???m che m???t ti??u chu???n v?? m???t t???m che m???t l??a. M???t n??? c??o c???a anh ???y c??ng c?? th??? th??o r???i.'," +
                "'Anime', 'HotToys', 'ABS, PVC','9 cm', 'pro2');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Katsuki Bakugo Nendoroid', 520000, 20 , 12," +
                "'T??? lo???t phim ho???t h??nh n???i ti???ng My Hero Academia, Nendoroid c???a nh??n v???t ch??nh l?? b???n th???i th?? ???u c???a Deku v?? l?? ?????i th??? c???a Katsuki Bakugo trong trang ph???c m??a ????ng c???a anh ???y! Anh ???y c?? ba bi???u c???m khu??n m???t bao g???m bi???u c???m c?????i toe to??t, bi???u c???m chi???n ?????u v?? bi???u c???m s???ng s???t! C??c b??? ph???n hi???u ???ng ????? t??i hi???n C?? c?????i b??ng n??? c???a anh ???y c??ng v???i b???ng ch??? BOOOM c??ng ???????c bao g???m ????? t???o ra c??c t?? th??? h??nh ?????ng ???n t?????ng h??n n???a! Th??ch t???o t???t c??? c??c lo???i c???nh kh??c nhau t??? b??? truy???n!'," +
                "'Anime', 'Takara Tomy', 'ABS, PVC','10 cm', 'pro3');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Kyojuro Rengoku Nendoroid', 325000, 20 , 12," +
                "'Kyojuro Rengoku t??? Demon Slayer: Kimetsu no Yaiba s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t! Nendoroid Swacchao! figure c?? Nendoroid ??ang ng???i tr??n gh???, gi??p b???n d??? d??ng tr??ng b??y ch??ng tr??n b??n, k??? ho???c nh???ng khu v???c ch???t h???p v??? kh??ng gian. C??c s??? li???u th???m ch?? c?? th??? ???????c hi???n th??? tr??n c??c c???nh c???a b??n ho???c k??? c???a b???n, v?? v???y h??y t???n h?????ng thu th???p v?? tr??ng b??y ch??ng ??? m???i n??i.'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro4');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Nobara Kugisaki Nendoroid', 325000, 20 , 12," +
                "'Nobara Kugisaki t??? Jujutsi Kaisen s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro5');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Megumi Fushiguro Nendoroid', 325000, 20 , 12," +
                "'Megumi Fushiguro t??? Jujutsi Kaisen s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro6');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Satoru Gojo Nendoroid', 325000, 20 , 12," +
                "'Satoru Gojo t??? Jujutsi Kaisen s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro7');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Shinobu Kocho Nendoroid', 350000, 20 , 12," +
                "'Shinobu Kocho t??? Demon Slayer: Kimetsu no Yaiba s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro8');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Sukuna Nendoroid', 350000, 20 , 12," +
                "'Sukuna t??? Jujutsu Kaisen s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
                "'Anime', 'Good Smile Company', 'ABS, PVC','9 cm', 'pro9');");
        db.execSQL("insert into PRODUCTS(ProductName, Price, Quantity, SoldQuantity, Description, Category, Company, Material, Size, Image)" +
                " VALUES('Yuji Itadori Nendoroid', 350000, 20 , 12," +
                "'Yuji Itadori t??? Jujutsu Kaisen s??? gia nh???p Nendoroid Swacchao m???i! h??ng lo???t!'," +
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
