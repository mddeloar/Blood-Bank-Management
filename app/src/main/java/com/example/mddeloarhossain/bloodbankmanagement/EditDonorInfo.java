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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class EditDonorInfo extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;
    private RadioGroup RradioGroup,RbecomeDonor;
    private RadioButton RgenderButton,RbecomeDonorButton;
    private EditText RNameEditText, RCityEditText, RLocationEditText, RBloodGroupEditText, RBirthDateEditText, RContactNoEditText, REmailEditText, RPasswordEditText;
    String[] Rbloodgroup;
    private Spinner Rspinner;
    private CardView saveButton;
    private static String value="1";
    private static String call="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_donor_info);



        mydatabaseHelper = new MyDatabaseHelper(EditDonorInfo.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        RradioGroup = findViewById(R.id.EditRegistrationRadioGroupId);
        ///becomeDonor = findViewById(R.id.BecomeDonorRadioGroupId);

        saveButton = findViewById(R.id.EditRegistrationSaveInfoCardViewId);
        //Button showButton = findViewById(R.id.ShowButtonId);
        RNameEditText = findViewById(R.id.EditRegistrationEditTextNameId);
        RCityEditText = findViewById(R.id.EditRegistrationEditTextCityId);
        ///RCityEditText = findViewById(R.id.sityId);
        RLocationEditText = findViewById(R.id.EditRegistrationEditTextLocationId);
        //BloodGroupEditText = findViewById(R.id.rEditTextBloodGroupId);
        RBirthDateEditText = findViewById(R.id.EditRegistrationBirthDateEditTextId);
        RContactNoEditText = findViewById(R.id.EditRegistrationEditTextContactNoId);
        REmailEditText = findViewById(R.id.EditRegistrationEditTextEmailId);
        RPasswordEditText = findViewById(R.id.EditRegistrationEditTextPasswordId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        Bundle bundle = getIntent().getExtras();
        //String v;
        if (bundle!=null){
            value = bundle.getString("tag");
        }

        Cursor cursor = mydatabaseHelper.showTheDonorData(value);

        while(cursor.moveToNext()) {
            RNameEditText.setText(cursor.getString(1));
            RCityEditText.setText(cursor.getString(2));
            RLocationEditText.setText(cursor.getString(3));
            //RBloodGroupEditText.setText(cursor.getString(5));
            RBirthDateEditText.setText(cursor.getString(6));
            RContactNoEditText.setText(cursor.getString(7));
            REmailEditText.setText(cursor.getString(8));
            RPasswordEditText.setText(cursor.getString(9));
        }



        Rbloodgroup = getResources().getStringArray(R.array.BloodGroup);
        Rspinner  = findViewById(R.id.EditRegistrationSpinnerBloodGroupId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.blood_group_sample,R.id.bloodGroupSampleId,Rbloodgroup);
        Rspinner.setAdapter(adapter);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    //Last task
                /*Intent intent = (new Intent(DonorRegistration.this, DonorLogIn.class));
                Toast.makeText(DonorRegistration.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                startActivity(intent);*/


                    int selectedId = RradioGroup.getCheckedRadioButtonId();
                    RgenderButton = findViewById(selectedId);
                    //Here Gender is available in gender variable in below
                    String gender = RgenderButton.getText().toString();

                    /*int selectedBecomeDonorId = becomeDonor.getCheckedRadioButtonId();
                    becomeDonorButton = findViewById(selectedBecomeDonorId);
                    //Here Gender is available in gender variable in below
                    String YesOrNo = becomeDonorButton.getText().toString();
                    int inTheList;
                    if(YesOrNo.equals("Yes"))
                    {
                        inTheList=1;
                    }
                    else {
                        inTheList=0;
                    }*/
                    String inTheList="Yes";


                    String name = RNameEditText.getText().toString();
                    String city = RCityEditText.getText().toString();
                    String location = RLocationEditText.getText().toString();
                    ///String bloodgroup = BloodGroupEditText.getText().toString();
                    String birthdate = RBirthDateEditText.getText().toString();
                    String contactnumber = RContactNoEditText.getText().toString();
                    String email = REmailEditText.getText().toString();
                    String password = RPasswordEditText.getText().toString();
                    String bloodgroup = Rspinner.getSelectedItem().toString();

                    if (view.getId() == R.id.EditRegistrationSaveInfoCardViewId) {

                        long rowId = mydatabaseHelper.EditTheDonorData(value, name, city, location, bloodgroup, gender, birthdate, contactnumber, email, password, inTheList);

                        if (rowId == -1) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(EditDonorInfo.this);
                            builder.setTitle("Your data is being insert..");
                            builder.setMessage("Unsuccessfully.");
                            builder.setCancelable(true);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(EditDonorInfo.this, DonorRegistration1.class);
                                    //Toast.makeText(DonorRegistration1.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            //Toast.makeText(getApplicationContext(), "" + rowId + " Unsuccessful.", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(), "" + rowId + " Successfully Inserted.", Toast.LENGTH_SHORT).show();


                            AlertDialog.Builder builder = new AlertDialog.Builder(EditDonorInfo.this);
                            builder.setTitle("Your edited data is Successfully inserted.");
                            builder.setMessage("Do you want to Log In ?");
                            builder.setCancelable(true);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(EditDonorInfo.this, TheDonorDetailsDonorProfile.class);
                                    Toast.makeText(EditDonorInfo.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    intent.putExtra("tag",value);
                                    startActivity(intent);
                                }
                            });

                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(EditDonorInfo.this, EditDonorInfo.class);
                                    //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });

                            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });


                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();

                        }
                    }
                }catch(Exception e){
                    Toast.makeText(EditDonorInfo.this, "Please enter your information.", Toast.LENGTH_SHORT).show();


                }

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
            Toast.makeText(EditDonorInfo.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(EditDonorInfo.this);
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
                    Intent intent = new Intent(EditDonorInfo.this, EditDonorInfo.class);
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
            Toast.makeText(EditDonorInfo.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(EditDonorInfo.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(EditDonorInfo.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(EditDonorInfo.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(EditDonorInfo.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(EditDonorInfo.this, ContactUs.class));
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
            Toast.makeText(EditDonorInfo.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
