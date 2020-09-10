package com.example.mddeloarhossain.bloodbankmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by MD. DELOAR HOSSAIN on 24-Feb-18.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Blood_Bank_ManagemenSystem.db";
    private static final String TABLE_NAME = "Donor_details";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String CITY = "City";
    private static final String LOCATION = "Location";
    private static final String GENDER = "Gender";
    private static final String BLOODGROUP = "BloodGroup";
    private static final String BIRTHDATE = "BirthDate";
    private static final String CONTACTNUMBER = "ContactNumber";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String BECOMEDONOR = "BecomeDonor";
    private static final int VERSION_NUMBER = 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(50), "+CITY+" VARCHAR(50), "+LOCATION+" VARCHAR(200), "+GENDER+" VARCHAR(20), "+BLOODGROUP+" VARCHAR(20), "+BIRTHDATE+" VARCHAR(20), "+CONTACTNUMBER+" VARCHAR(20), "+EMAIL+" VARCHAR(50), "+PASSWORD+" VARCHAR(30), "+BECOMEDONOR+" VARCHAR(4));";
    private static final String DROP_TABLE = "DROP TABLE IF EXIST "+TABLE_NAME+";";
    //private static final String DROP_TABLE = "DROP TABLE "+TABLE_NAME+";";


    //Feedback Table Create Start

    private static final String ADMIN_SIGN_TABLE_NAME = "Admin_Sign_details";
    private static final String AUSERNAME = "AUsername";
    private static final String APASSWORD = "APassword";

    private static final String ADMIN_SIGN_CREATE_TABLE = "CREATE TABLE "+ADMIN_SIGN_TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+AUSERNAME+" VARCHAR(50), "+APASSWORD+" VARCHAR(50));";
    private static final String ADMIN_SIGN_DROP_TABLE = "DROP TABLE IF EXIST "+ADMIN_SIGN_TABLE_NAME+";";
    //private static final String FEEDBACK_DROP_TABLE = "DROP TABLE "+FEEDBACK_CREATE_TABLE+";";

    //Feedback Table Create Finish


    //Feedback Table Create Start

    private static final String FEEDBACK_TABLE_NAME = "Feedback_details";
    private static final String FNAME = "Name";
    private static final String FEMAIL = "Email";
    private static final String FEEDBACK = "Feedback";
    private static final String FEEDBACK_CREATE_TABLE = "CREATE TABLE "+FEEDBACK_TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FNAME+" VARCHAR(50), "+FEMAIL+" VARCHAR(50), "+FEEDBACK+" VARCHAR(500));";
    private static final String FEEDBACK_DROP_TABLE = "DROP TABLE IF EXIST "+FEEDBACK_CREATE_TABLE+";";
    //private static final String FEEDBACK_DROP_TABLE = "DROP TABLE "+FEEDBACK_CREATE_TABLE+";";

    //Feedback Table Create Finish

    //Blood Stock Table Create Start

    private static final String BLOOD_STOCK_TABLE_NAME = "Blood_Stock_details";
    private static final String Id = "_id";
    private static final String ABpositive = "ABpositive";
    private static final String Apositive = "Apositive";
    private static final String Bpositive = "Bpositive";
    private static final String ABnegative = "ABnegative";
    private static final String Anegative = "Anegative";
    private static final String Bnegative = "Bnegative";
    private static final String Opositive = "Opositive";
    private static final String Onegative = "Onegative";

    private static final String BLOOD_STOCK_CREATE_TABLE = "CREATE TABLE "+BLOOD_STOCK_TABLE_NAME+" ("+ABpositive+" INTEGER, "+Apositive+" INTEGER, "+Bpositive+" INTEGER, "+ABnegative+" INTEGER, "+Anegative+" INTEGER, "+Bnegative+" INTEGER, "+Opositive+" INTEGER, "+Onegative+" INTEGER);";
    private static final String BLOOD_STOCK_DROP_TABLE = "DROP TABLE IF EXIST "+BLOOD_STOCK_TABLE_NAME+";";

    //Blood Stock Table Create Finish

    //CONTACT_US Table Create Start

    private static final String CONTACT_US_TABLE_NAME = "Contact_Us_details";
    private static final String ADDRESS = "Address";
    //private static final String CEMAIL = "CEmail";
    //private static final String CCONTACTNUMBER = "CContactnumber";
    private static final String CONTACT_US_CREATE_TABLE = "CREATE TABLE "+CONTACT_US_TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ADDRESS+" VARCHAR(500));";
    private static final String CONTACT_US_DROP_TABLE = "DROP TABLE IF EXIST "+CONTACT_US_TABLE_NAME+";";

    //CONTACT_US Table Create Finish

    //CONTACT_US Table Create Start

    private static final String USER_REQUEST_TABLE_NAME = "User_Requset_details";
    private static final String UName = "Uname";
    private static final String UEmail = "Uemail";
    private static final String UContactNumber = "Unumber";
    private static final String UREQUEST = "Request";
    private static final String USER_REQUEST_CREATE_TABLE = "CREATE TABLE "+USER_REQUEST_TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+UName+" VARCHAR(50), "+UContactNumber+" VARCHAR(20), "+UEmail+" VARCHAR(50), "+UREQUEST+" VARCHAR(500));";
    private static final String USER_REQUEST_DROP_TABLE = "DROP TABLE IF EXIST "+USER_REQUEST_TABLE_NAME+";";

    //CONTACT_US Table Create Finish

    //CONTACT_US Table Create Start

    private static final String ABOUT_US_TABLE_NAME = "About_Us_details";
    private static final String ABOUTUS = "Aboutus";
    //private static final String CEMAIL = "CEmail";
    //private static final String CCONTACTNUMBER = "CContactnumber";
    private static final String ABOUT_US_CREATE_TABLE = "CREATE TABLE "+ABOUT_US_TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ABOUTUS+" VARCHAR(2000));";
    private static final String ABOUT_US_DROP_TABLE = "DROP TABLE IF EXIST "+ABOUT_US_TABLE_NAME+";";

    //CONTACT_US Table Create Finish


    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            Toast.makeText(context,"onCreate method is called.",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

            sqLiteDatabase.execSQL(FEEDBACK_CREATE_TABLE);     // For Feedback Table Create
            sqLiteDatabase.execSQL(BLOOD_STOCK_CREATE_TABLE);     // For BLOOD_STOCK_CREATE_TABLE Table Create
            sqLiteDatabase.execSQL(CONTACT_US_CREATE_TABLE);     // For CONTACT_US_CREATE_TABLE Table Create
            sqLiteDatabase.execSQL(ABOUT_US_CREATE_TABLE);     // For ABOUT_US_CREATE_TABLE Table Create
            sqLiteDatabase.execSQL(USER_REQUEST_CREATE_TABLE);     // For USER_REQUEST_CREATE_TABLE Table Create
            sqLiteDatabase.execSQL(ADMIN_SIGN_CREATE_TABLE);     // For ABOUT_US_CREATE_TABLE Table Create

            Toast.makeText(context,"Table Created Successfully.",Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            Toast.makeText(context,"Database is upgrade",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);

            sqLiteDatabase.execSQL(FEEDBACK_DROP_TABLE);  // For Feedback Table Drop
            sqLiteDatabase.execSQL(BLOOD_STOCK_DROP_TABLE);  // For BLOOD_STOCK_DROP_TABLE Table Drop
            sqLiteDatabase.execSQL(CONTACT_US_DROP_TABLE);  // For CONTACT_US_DROP_TABLE Table Drop
            sqLiteDatabase.execSQL(ABOUT_US_DROP_TABLE);  // For ABOUT_US_DROP_TABLE Table Drop
            sqLiteDatabase.execSQL(USER_REQUEST_DROP_TABLE);  // For USER_REQUEST_DROP_TABLE Table Drop
            sqLiteDatabase.execSQL(ADMIN_SIGN_DROP_TABLE);  // For ADMIN_SIGN_DROP_TABLE Table Drop

            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
        }

    }

    public  long InsertData(String name, String city, String location, String bloodgroup, String gender, String birthdate,String contactnumber, String email, String password, String inTheList){



            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(NAME, name);
            contentValues.put(LOCATION, location);
            contentValues.put(CITY, city);
            contentValues.put(GENDER, gender);
            contentValues.put(BLOODGROUP, bloodgroup);
            contentValues.put(BIRTHDATE, birthdate);
            contentValues.put(EMAIL, email);
            contentValues.put(PASSWORD, password);
            contentValues.put(CONTACTNUMBER, contactnumber);
            contentValues.put(BECOMEDONOR, inTheList);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
            return 0;
        }

            long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

            return rowId;


    }



    public  long InsertFeedbackData(String name, String email, String feedback){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FNAME,name);
        contentValues.put(FEMAIL,email);
        contentValues.put(FEEDBACK,feedback);

        long rowId = sqLiteDatabase.insert(FEEDBACK_TABLE_NAME,null,contentValues);

        return rowId;

    }

    public  long InsertUserRequestData(String name, String email, String contactNo, String request){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UName,name);
        contentValues.put(UEmail,email);
        contentValues.put(UContactNumber,contactNo);
        contentValues.put(UREQUEST,request);

        long rowId = sqLiteDatabase.insert(USER_REQUEST_TABLE_NAME,null,contentValues);

        return rowId;

    }


    public  long InsertAdminRegistrationData(String username, String password){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AUSERNAME,username);
        contentValues.put(APASSWORD,password);

        long rowId = sqLiteDatabase.insert(ADMIN_SIGN_TABLE_NAME,null,contentValues);

        return rowId;

    }


    public  long ContactInfo(String contactinfo){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADDRESS,contactinfo);

        long rowId = sqLiteDatabase.insert(CONTACT_US_TABLE_NAME,null,contentValues);

        return rowId;

    }


    public  long BloodStockInputData(String ABp,String Ap,String Bp,String ABn,String An,String Bn,String Op,String On){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(ID,1);
        contentValues.put(ABpositive,ABp);
        contentValues.put(Apositive,Ap);
        contentValues.put(Bpositive,Bp);
        contentValues.put(ABnegative,ABn);
        contentValues.put(Anegative,An);
        contentValues.put(Bnegative,Bn);
        contentValues.put(Opositive,Op);
        contentValues.put(Onegative,On);

        long rowId = sqLiteDatabase.insert(BLOOD_STOCK_TABLE_NAME,null,contentValues);

        return rowId;

    }
    public  long BloodStockEditInputData(String test,String ABp,String Ap,String Bp,String ABn,String An,String Bn,String Op,String On){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(ID,id);
        contentValues.put(ABpositive,ABp);
        contentValues.put(Apositive,Ap);
        contentValues.put(Bpositive,Bp);
        contentValues.put(ABnegative,ABn);
        contentValues.put(Anegative,An);
        contentValues.put(Bnegative,Bn);
        contentValues.put(Opositive,Op);
        contentValues.put(Onegative,On);

        //long rowId = sqLiteDatabase.update(BLOOD_STOCK_TABLE_NAME,null,contentValues);
        long rowId = sqLiteDatabase.update(BLOOD_STOCK_TABLE_NAME,contentValues,ABpositive+" = ?",new String[]{test});

        //Toast.makeText(context,"in BloodStockEditInputData.",Toast.LENGTH_SHORT).show();

        //long rowId=1;
        return rowId;

    }





    public  Cursor RetriveAdminUsernamePassword()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ADMIN_SIGN_TABLE_NAME,null);
        //Toast.makeText(context,"Successfully ADMIN_SIGN_TABLE_NAME cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;
    }

    /*public  Cursor RetriveDonorUsernamePassword()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT "+U+" FROM "+TABLE_NAME,null);
        //Toast.makeText(context,"Successfully ADMIN_SIGN_TABLE_NAME cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;
    }*/


    public  Cursor RetriveBloodStockData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+BLOOD_STOCK_TABLE_NAME,null);
        //Toast.makeText(context,"Successfully BLOOD_STOCK_TABLE_NAME cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;
    }






    public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        //Toast.makeText(context,"Successfully cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;

    }

    public Cursor showAllDonorPlaceData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT "+CITY+" FROM "+TABLE_NAME,null);
        //Toast.makeText(context,"Successfully cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;

    }
    public Cursor showAllUserRequestData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+USER_REQUEST_TABLE_NAME,null);
        //Toast.makeText(context,"Successfully cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;

    }

    public Cursor showAllUserFeedbackData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+FEEDBACK_TABLE_NAME,null);
        //Toast.makeText(context,"Successfully cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;

    }
    /*public Cursor showOneDonorData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ID+"= 1",null);
        Toast.makeText(context,"Successfully cursor return.",Toast.LENGTH_SHORT).show();
        return cursor;

    }*/



    public Cursor showTheDonorData(String Dept)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_id",NAME,CITY,LOCATION,GENDER,BLOODGROUP,BIRTHDATE,CONTACTNUMBER,EMAIL,PASSWORD,BECOMEDONOR};
        Cursor c=db.query(TABLE_NAME, columns, ID+"=?",
                new String[]{Dept}, null, null, null);
        return c;

    }
    public Cursor retrieveDonorPassword(String username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_id",PASSWORD,BECOMEDONOR};
        Cursor c=db.query(TABLE_NAME, columns, EMAIL+"=?",
                new String[]{username}, null, null, null);
        return c;

    }

    public Cursor showBGTheDonorData(String bloodGroup)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_id",NAME,CITY,LOCATION,GENDER,BLOODGROUP,BIRTHDATE,CONTACTNUMBER,EMAIL,PASSWORD,BECOMEDONOR};
        Cursor c=db.query(TABLE_NAME, columns, BLOODGROUP+"=?",
                new String[]{bloodGroup}, null, null, null);
        //Toast.makeText(context,"Successfully return from showBGTheDonorData.",Toast.LENGTH_SHORT).show();
        return c;

    }
    public Cursor showAllDonorPlacesData(String city)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_id",NAME,CITY,LOCATION,GENDER,BLOODGROUP,BIRTHDATE,CONTACTNUMBER,EMAIL,PASSWORD,BECOMEDONOR};
        Cursor c=db.query(TABLE_NAME, columns, CITY+"=?",
                new String[]{city}, null, null, null);
        //Toast.makeText(context,"Successfully return from showBGTheDonorData.",Toast.LENGTH_SHORT).show();
        return c;

    }

    /*public Cursor showAllDonorPlaceData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_id",NAME,CITY,LOCATION,GENDER,BLOODGROUP,BIRTHDATE,CONTACTNUMBER,EMAIL,PASSWORD,BECOMEDONOR};
        Cursor c=db.query(TABLE_NAME, columns, BLOODGROUP+"=?",
                new String[]{bloodGroup}, null, null, null);
        //Toast.makeText(context,"Successfully return from showBGTheDonorData.",Toast.LENGTH_SHORT).show();
        return c;

    }*/


    public  long EditTheDonorData(String id, String name, String city, String location, String bloodgroup, String gender, String birthdate,String contactnumber, String email, String password, String becomeDonor){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(CITY,city);
        contentValues.put(LOCATION,location);
        contentValues.put(GENDER,gender);
        contentValues.put(BLOODGROUP,bloodgroup);
        contentValues.put(BIRTHDATE,birthdate);
        contentValues.put(CONTACTNUMBER,contactnumber);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(BECOMEDONOR,becomeDonor);

        //long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        long rowId = sqLiteDatabase.update(TABLE_NAME,contentValues,ID+" = ?",new String[]{id});

        //Toast.makeText(context,"Successfully return from EditTheDonorData.",Toast.LENGTH_SHORT).show();
        return rowId;

    }



    public long DeleteTheDonorData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long rowId = sqLiteDatabase.delete(TABLE_NAME, ID+" = ?",new String[]{id});
        return rowId;

    }

    /*public long DeleteBloodStockData(String test){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long rowId = sqLiteDatabase.delete(BLOOD_STOCK_TABLE_NAME, ABpositive+" = ?",new String[]{test});
        return rowId;

    }*/










    /*public Cursor showTheDonorData(String Dept)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String [] columns=new String[]{"_fid",FNAME,FEMAIL,FEEDBACK};
        Cursor c=db.query(FEEDBACK_TABLE_NAME, columns, FID+"=?",
                new String[]{Dept}, null, null, null);
        return c;

    }*/



    //public Cursor DonorData()
    /*public Cursor DonorData(Bundle Id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ID+ "=" +Id,null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ID+"="+Id,null);
        return cursor;

    }*/



}

