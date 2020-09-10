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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DonorSignIn extends AppCompatActivity {
    MyDatabaseHelper mydatabaseHelper;
    private EditText usernameEdittext, passwordEdittext;
    private CardView loginButton, RegisterRequestButton;
    private TextView textView;
    private static String call="1";
    private String Ausername,Apassword;
    private static String value="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_in);


        mydatabaseHelper = new MyDatabaseHelper(DonorSignIn.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        usernameEdittext = findViewById(R.id.usernameId);
        passwordEdittext = findViewById(R.id.passwordId);
        loginButton = findViewById(R.id.DonorLogInCardViewId);
        textView = findViewById(R.id.AtextViewId);
        RegisterRequestButton = findViewById(R.id.DonorRegisterButtonCardViewId);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdittext.getText().toString();
                String password = passwordEdittext.getText().toString();



                //Here we need to find and match the donor information

                //Cursor cursor = mydatabaseHelper.RetriveDonorUsernamePassword();


                Cursor cursor = mydatabaseHelper.retrieveDonorPassword(username);
                if (cursor.getCount() == -1) {
                    Toast.makeText(DonorSignIn.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //String Ausername,Apassword;
                while(cursor.moveToNext()) {

                    //Ausername = cursor.getString(1);
                    value=cursor.getString(0);
                    Apassword = cursor.getString(1);
                    if(password.equals(Apassword))
                    {
                        Intent intent = (new Intent(DonorSignIn.this, DonorHome.class));
                        Toast.makeText(DonorSignIn.this, "Welcome", Toast.LENGTH_SHORT).show();
                        intent.putExtra("tag",value);
                        startActivity(intent);
                        //mydatabaseHelper = new MyDatabaseHelper(DonorSignIn.this);
                        //SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();
                    }
                    else {
                        textView.setText("Username or Password is incorrect.");

                    }


                }




                /*if(username.equals("Admin")  && password.equals("12345"))
                {
                    Intent intent = (new Intent(DonorSignIn.this, DonorHome.class));
                    Toast.makeText(DonorSignIn.this, "Welcome donor", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    //mydatabaseHelper = new MyDatabaseHelper(DonorSignIn.this);
                    //SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();
                }
                else {
                    textView.setText("Username or Password is incorrect.");

                }*/
            }
        });

        RegisterRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(DonorSignIn.this, DonorRegistration1.class));
                Toast.makeText(DonorSignIn.this, "You are so great", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(DonorSignIn.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(DonorSignIn.this);
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
                    Intent intent = new Intent(DonorSignIn.this, DonorSignIn.class);
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
            Toast.makeText(DonorSignIn.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(DonorSignIn.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(DonorSignIn.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorSignIn.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorSignIn.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(DonorSignIn.this, ContactUs.class));
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
            Toast.makeText(DonorSignIn.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
