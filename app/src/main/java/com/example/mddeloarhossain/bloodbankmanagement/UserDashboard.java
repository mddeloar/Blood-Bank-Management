package com.example.mddeloarhossain.bloodbankmanagement;

import android.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

public class UserDashboard extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;

    private CardView uBloodStock, uDonorInfo, uUserInfo, uFeedbackInfo, uContactInfo, uAboutInfo;
    private static String call="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);


        mydatabaseHelper = new MyDatabaseHelper(UserDashboard.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();


        uBloodStock = findViewById(R.id.UserBloodStockInfoCardViewId);
        uDonorInfo = findViewById(R.id.UserDonorInfoCardViewId);
        uUserInfo = findViewById(R.id.UserUserInfoCardViewId);
        uFeedbackInfo = findViewById(R.id.UserFeedbackInfoCardViewId);
        uContactInfo = findViewById(R.id.UserContactInfoCardViewId);
        uAboutInfo = findViewById(R.id.UserAboutInfoCardViewId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        uBloodStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = (new Intent(UserDashboard.this, BloodStockWithoutEdit.class));
                Toast.makeText(UserDashboard.this, "Welcome to Blood Stock", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uDonorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(UserDashboard.this, AllDonorPlace.class));
                //Toast.makeText(UserDashboard.this, "Welcome to see All Donor Informations", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(UserDashboard.this, UserRequest.class));
                Toast.makeText(UserDashboard.this, "Request for  blood", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uFeedbackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(UserDashboard.this, Feedback.class));
                Toast.makeText(UserDashboard.this, "Sent you Feedback", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(UserDashboard.this, ContactUsUser.class));
                Toast.makeText(UserDashboard.this, "Contact Us On", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uAboutInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(UserDashboard.this, AboutUs.class));
                Toast.makeText(UserDashboard.this, "About Us On", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
    //Option Menu start---------------------------------------------------


    /**********public boolean onCreateOptionsMenu(Menu menu){
     MenuInflater menuInflater = getMenuInflater();
     menuInflater.inflate(R.menu.menu,menu);
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
    /********** return super.onCreateOptionsMenu(menu);
     }

     public boolean onOptionsItemSelected(MenuItem item){
     /*if (item.getItemId()==R.id.settingItemID){
     Toast.makeText(MainActivity.this,"Setting is selected.",Toast.LENGTH_SHORT).show();
     Intent intent = (new Intent(MainActivity.this, AllDonorInformation.class));
     Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
     startActivity(intent);
     return true;
     }*/
    /**********if (item.getItemId()==R.id.shareItemID){
     Toast.makeText(UserHome.this,"Share is selected.",Toast.LENGTH_SHORT).show();


     Intent intent = new Intent(Intent.ACTION_SEND);
     intent.setType("text/plain");
     String subject = "Blook Bank Management app.";
     String body = "This is very usefull.\ncom.example.mddeloarhossain.donordemo";
     intent.putExtra(Intent.EXTRA_SUBJECT, subject);
     intent.putExtra(Intent.EXTRA_TEXT, body);
     startActivity(Intent.createChooser(intent,"share with"));


     return true;
     }
     if (item.getItemId()==R.id.feedbackItemID){
     Toast.makeText(UserHome.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
     Intent intent = (new Intent(UserHome.this, Feedback.class));
     //Toast.makeText(UserHome.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
     startActivity(intent);
     return true;
     }
     if (item.getItemId()==R.id.aboutUsItemID){
     Toast.makeText(UserHome.this,"About Us is selected.",Toast.LENGTH_SHORT).show();
     return true;
     }
     if (item.getItemId()==R.id.contactUsItemID){
     Intent intent = (new Intent(UserHome.this, ContactUs.class));
     //Toast.makeText(UserHome.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
     startActivity(intent);
     //Toast.makeText(UserHome.this,"Contact Us is selected.",Toast.LENGTH_SHORT).show();
     return true;
     }
     return super.onOptionsItemSelected(item);
     }

     //Option Menu finish---------------------------------------------------
     */



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
            Toast.makeText(UserDashboard.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(UserDashboard.this);
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
                    Intent intent = new Intent(UserDashboard.this, UserDashboard.class);
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
            Toast.makeText(UserDashboard.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(UserDashboard.this,
                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(UserDashboard.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(UserDashboard.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(UserDashboard.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(UserDashboard.this, ContactUsUser.class));
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
            Toast.makeText(UserDashboard.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}

