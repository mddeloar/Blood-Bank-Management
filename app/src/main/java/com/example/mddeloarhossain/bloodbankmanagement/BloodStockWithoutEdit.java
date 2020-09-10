package com.example.mddeloarhossain.bloodbankmanagement;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BloodStockWithoutEdit extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;
    //private CardView ABpositive, Apositive, Bpositive, ABnegative, Anegative, Bnegative, Opositive, Onegative;
    private TextView ABPositive, APositive, BPositive, ABNegative, ANegative, BNegative, OPositive, ONegative;
    private String ABpositive, Apositive, Bpositive, ABnegative, Anegative, Bnegative, Opositive, Onegative;
    private CardView ABnpositive, Anpositive, Bnpositive, ABnnegative, Annegative, Bnnegative, Onpositive, Onnegative;
    //private CardView editCardView, deleteCardView;
    //private String test;
    private static String call="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_stock_without_edit);


        mydatabaseHelper = new MyDatabaseHelper(BloodStockWithoutEdit.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        ABPositive = findViewById(R.id.UserABPb);
        APositive = findViewById(R.id.UserAPb);
        BPositive = findViewById(R.id.UserBPb);
        ABNegative = findViewById(R.id.UserABNb);
        ANegative = findViewById(R.id.UserANb);
        BNegative = findViewById(R.id.UserBNb);
        OPositive = findViewById(R.id.UserOPb);
        ONegative = findViewById(R.id.UserONb);


        ABnpositive = findViewById(R.id.ABpositiveCardViewId);
        Anpositive = findViewById(R.id.ApositiveCardViewId);
        Bnpositive = findViewById(R.id.BpositiveCardViewId);
        ABnnegative = findViewById(R.id.ABnegativeCardViewId);
        Annegative = findViewById(R.id.AnegativeCardViewId);
        Bnnegative = findViewById(R.id.BnegativeCardViewId);
        Onpositive = findViewById(R.id.OpositiveCardViewId);
        Onnegative = findViewById(R.id.OnegativeCardViewId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);







        Cursor cursor = mydatabaseHelper.RetriveBloodStockData();

        if (cursor.getCount() == -1) {
            Toast.makeText(BloodStockWithoutEdit.this, "No data Found.", Toast.LENGTH_SHORT).show();
            return;
        }
        //String Ausername,Apassword;
        while(cursor.moveToNext()) {


            ABpositive = cursor.getString(0);
            //test=ABpositive;
            Apositive = cursor.getString(1);
            Bpositive = cursor.getString(2);
            ABnegative = cursor.getString(3);
            Anegative = cursor.getString(4);
            Bnegative = cursor.getString(5);
            Opositive = cursor.getString(6);
            Onegative = cursor.getString(7);

        }


        ABPositive.setText(ABpositive);
        APositive.setText(Apositive);
        BPositive.setText(Bpositive);
        ABNegative.setText(ABnegative);
        ANegative.setText(Anegative);
        BNegative.setText(Bnegative);
        OPositive.setText(Opositive);
        ONegative.setText(Onegative);

        ABnpositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB+");
                startActivity(intent);
            }
        });

        Anpositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A+");
                startActivity(intent);
            }
        });

        Bnpositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B+");
                startActivity(intent);
            }
        });

        ABnnegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB-");
                startActivity(intent);
            }
        });

        Annegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A-");
                startActivity(intent);
            }
        });

        Bnnegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B-");
                startActivity(intent);
            }
        });


        Onpositive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                        //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                        intent.putExtra("tag","O+");
                        startActivity(intent);
                    }
                });


        Onnegative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = (new Intent(BloodStockWithoutEdit.this, BloodStockBGIDonor.class));
                        //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                        intent.putExtra("tag","O-");
                        startActivity(intent);
                    }
                });




    }

    //Option Menu start---------------------------------------------------


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        /*MenuItem menuItem = menu.getItem(R.id.searchViewItemID);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        /*if (item.getItemId()==R.id.settingItemID){
            Toast.makeText(MainActivity.this,"Setting is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(MainActivity.this, AllDonorInformation.class));
            Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }*/
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        if (item.getItemId()==R.id.shareId){
            Toast.makeText(BloodStockWithoutEdit.this,"Share is selected.",Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "Blook Bank Management app.";
            String body = "This is very usefull.\ncom.example.mddeloarhossain.bloodbankmanagement";
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent,"share with"));


            return true;
        }
        if (item.getItemId()==R.id.requestId){

            AlertDialog.Builder builder = new AlertDialog.Builder(BloodStockWithoutEdit.this);
            builder.setTitle("Do you want to send message ?");
            builder.setMessage("Standard Data Charge Apply.");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    call = "01765436702";

                    sendSMS(call);
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(BloodStockWithoutEdit.this, BloodStockWithoutEdit.class);
                    //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return true;
        }
        if (item.getItemId()==R.id.requestCallId){
            call = "01765436702";
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            //int CallingNumber = String.toInteger(call);
            Toast.makeText(BloodStockWithoutEdit.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(BloodStockWithoutEdit.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(BloodStockWithoutEdit.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockWithoutEdit.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockWithoutEdit.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockWithoutEdit.this, ContactUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Option Menu finish---------------------------------------------------

    protected void sendSMS(String number) {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String (number));
        smsIntent.putExtra("sms_body"  , "Number Collected From Pust Blood Bank.\n");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(BloodStockWithoutEdit.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
