package com.example.mddeloarhossain.bloodbankmanagement;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ContactUsUser extends AppCompatActivity {

    private CardView callButton, messageButton, emailButton;
    private static String call="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_user);

        callButton = findViewById(R.id.ContactMakeCallCardViewId);
        messageButton = findViewById(R.id.ContactSendMessageCardViewId);
        emailButton = findViewById(R.id.ContactSendEmailCardViewId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                call = "01765436702";

                //Toast.makeText(DonorDetails.this, "Clicked on the call button", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                //int CallingNumber = String.toInteger(call);
                Toast.makeText(ContactUsUser.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
                callIntent.setData(Uri.parse("tel:"+call));
                if (ActivityCompat.checkSelfPermission(ContactUsUser.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
                startActivity(callIntent);
                //Toast.makeText(DonorDetails.this, "After startActivity.", Toast.LENGTH_SHORT).show();
            }
        });
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(ContactUsUser.this);
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
                        Intent intent = new Intent(ContactUsUser.this, ContactUsUser.class);
                        //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();





            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    };


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
            Toast.makeText(ContactUsUser.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
