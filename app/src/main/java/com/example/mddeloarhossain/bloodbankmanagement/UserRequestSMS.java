package com.example.mddeloarhossain.bloodbankmanagement;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class UserRequestSMS extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    MyDatabaseHelper mydatabaseHelper;
    private RadioGroup SRradioGroup;
    private RadioButton SRTimeButton;
    private EditText SRNameEditText, SRCityEditText, SRLocationEditText, SRBloodGroupEditText;
    String[] SRbloodgroup;
    private Spinner SRspinner;
    private CardView sendButton;
    private static String call="1";
    ///private static String name,time,bloodgroup,city,location;
    String name,city,location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_request_sms);


        mydatabaseHelper = new MyDatabaseHelper(UserRequestSMS.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        SRradioGroup = findViewById(R.id.SMSRegistrationRadioGroupId);
        ///becomeDonor = findViewById(R.id.BecomeDonorRadioGroupId);

        sendButton = findViewById(R.id.SMSRegistrationSaveInfoCardViewId);
        //Button showButton = findViewById(R.id.ShowButtonId);
        SRNameEditText = findViewById(R.id.SMSRegistrationEditTextNameId);
        SRCityEditText = findViewById(R.id.SMSRegistrationEditTextCityId);
        ///RCityEditText = findViewById(R.id.sityId);
        SRLocationEditText = findViewById(R.id.SMSRegistrationEditTextLocationId);
        //BloodGroupEditText = findViewById(R.id.rEditTextBloodGroupId);

        SRbloodgroup = getResources().getStringArray(R.array.BloodGroup);
        SRspinner  = findViewById(R.id.SMSRegistrationSpinnerBloodGroupId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.blood_group_sample,R.id.bloodGroupSampleId,SRbloodgroup);
        SRspinner.setAdapter(adapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = SRradioGroup.getCheckedRadioButtonId();
                SRTimeButton = findViewById(selectedId);
                //Here Gender is available in gender variable in below
                /*String time = SRTimeButton.getText().toString();
                String name = SRNameEditText.getText().toString();
                String city = SRCityEditText.getText().toString();
                String location = SRLocationEditText.getText().toString();
                String bloodgroup = SRspinner.getSelectedItem().toString();*/
                /*time = SRTimeButton.getText().toString();
                name = SRNameEditText.getText().toString();
                city = SRCityEditText.getText().toString();
                location = SRLocationEditText.getText().toString();
                bloodgroup = SRspinner.getSelectedItem().toString();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(UserRequestSMS.this);
                builder.setTitle("Do you want send message ?");
                builder.setMessage("Standard Data Charge Apply.");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        call = "01765436702";

                        ///////sendSMS(call);
                        //sendSMS(call,time);
                        sendSMSMessage();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(UserRequestSMS.this, MainActivity.class);
                        //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                //return true;


            }
        });


    }





    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //protected void sendSMS(String number, String time) {
   /****** protected void sendSMS(String number) {

        int selectedId = SRradioGroup.getCheckedRadioButtonId();
        SRTimeButton = findViewById(selectedId);
        //Here Gender is available in gender variable in below
        /*String time = SRTimeButton.getText().toString();
        String name = SRNameEditText.getText().toString();
        String city = SRCityEditText.getText().toString();
        String location = SRLocationEditText.getText().toString();
        String bloodgroup = SRspinner.getSelectedItem().toString();*/

    /******Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String (number));
        smsIntent.putExtra("sms_body"  , "Number collected from PUST BBMS");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(UserRequestSMS.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }******/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////






    protected void sendSMSMessage() {
        //phoneNo = txtphoneNo.getText().toString();
        //message = txtMessage.getText().toString();


         //time = SRTimeButton.getText().toString();
        name = SRNameEditText.getText().toString();
        city = SRCityEditText.getText().toString();
        location = SRLocationEditText.getText().toString();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        Toast.makeText(getApplicationContext(), "Come in", Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    //Toast.makeText(getApplicationContext(), "Come in", Toast.LENGTH_SHORT).show();
                    smsManager.sendTextMessage(call, null, city, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }


}
