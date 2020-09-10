package com.example.mddeloarhossain.bloodbankmanagement;

import android.Manifest;
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

public class DonorHome extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;

    private CardView Dprofile, uBloodStock, uDonorInfo, uUserInfo, uFeedbackInfo, uContactInfo, uAboutInfo;
    private static String call="1";
    private static String value="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home);

        mydatabaseHelper = new MyDatabaseHelper(DonorHome.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();


        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
            //value = bundle.getString("tag");
            String str = bundle.getString("tag");
            //detailsTextview.setText(str);
            String[] splitStr = str.split("\\s+");
            value = splitStr[0];

        }

        Dprofile = findViewById(R.id.DonorProfileInfoCardViewId);
        uBloodStock = findViewById(R.id.DonorUserBloodStockInfoCardViewId);
        uDonorInfo = findViewById(R.id.DonorUserDonorInfoCardViewId);
        uUserInfo = findViewById(R.id.DonorUserUserInfoCardViewId);
        uFeedbackInfo = findViewById(R.id.DonorUserFeedbackInfoCardViewId);
        uContactInfo = findViewById(R.id.DonorUserContactInfoCardViewId);
        uAboutInfo = findViewById(R.id.DonorUserAboutInfoCardViewId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        Dprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = (new Intent(DonorHome.this, TheDonorDetailsDonorProfile.class));
                Toast.makeText(DonorHome.this, "Welcome to your profile", Toast.LENGTH_SHORT).show();

                Toast.makeText(DonorHome.this, "Welcome to your profile", Toast.LENGTH_LONG).show();
                intent.putExtra("tag",value);
                startActivity(intent);

            }
        });

        uBloodStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = (new Intent(DonorHome.this, BloodStockWithoutEdit.class));
                Toast.makeText(DonorHome.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uDonorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorHome.this, AllDonorPlace.class));
                Toast.makeText(DonorHome.this, "Welcome to AllDonorInformation", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorHome.this, UserRequest.class));
                Toast.makeText(DonorHome.this, "Welcome to mUserInfo", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uFeedbackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorHome.this, Feedback.class));
                Toast.makeText(DonorHome.this, "Welcome to Feedback", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorHome.this, ContactUsUser.class));
                Toast.makeText(DonorHome.this, "Welcome to ContactUsUser", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        uAboutInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorHome.this, AboutUs.class));
                Toast.makeText(DonorHome.this, "Welcome to mAboutInfo", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(DonorHome.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(DonorHome.this);
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
                    Intent intent = new Intent(DonorHome.this, DonorHome.class);
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
            Toast.makeText(DonorHome.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(DonorHome.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(DonorHome.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorHome.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorHome.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorHome.this, ContactUs.class));
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
            Toast.makeText(DonorHome.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
