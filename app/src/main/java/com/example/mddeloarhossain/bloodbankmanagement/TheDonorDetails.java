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

public class TheDonorDetails extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;
    private CardView callButton, messageButton, emailButton, profileButton,editButton,deleteButton;
    private TextView detailsTextview;
    private static String value="1";
    private static String call="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_donor_details);

        mydatabaseHelper = new MyDatabaseHelper(TheDonorDetails.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //profileButton = findViewById(R.id.ProfileCardViewId);
        callButton = findViewById(R.id.MakeCallCardViewId);
        messageButton = findViewById(R.id.SendMessageCardViewId);
        emailButton = findViewById(R.id.SendEmailCardViewId);
        editButton = findViewById(R.id.EditDonorCardViewId);
        deleteButton = findViewById(R.id.DeleteDonorCardViewId);
        detailsTextview = findViewById(R.id.DetailsTextViewId);



        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
            //value = bundle.getString("tag");
            String str = bundle.getString("tag");
            //detailsTextview.setText(str);
            String[] splitStr = str.split("\\s+");
            value = splitStr[0];

        }





        //////////////////////////////////////////////////////////////////////////////////////



        Cursor cursor = mydatabaseHelper.showTheDonorData(value);

        if (cursor.getCount() == -1) {
            Toast.makeText(TheDonorDetails.this, "No data Found.", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();
        while(cursor.moveToNext()) {

            //stringBuffer.append("ID: " + cursor.getString(0) + "\n");
            //stringBuffer.append("Id: " + cursor.getString(0) + "\n");
            stringBuffer.append("Name            : " + cursor.getString(1) + "\n\n");
            stringBuffer.append("City                : " + cursor.getString(2) + "\n\n");
            stringBuffer.append("Location       : " + cursor.getString(3) + "\n\n");
            stringBuffer.append("Gender          : " + cursor.getString(4) + "\n\n");
            stringBuffer.append("Blood-Group: " + cursor.getString(5) + "\n\n");
            stringBuffer.append("Date of Birth: " + cursor.getString(6) + "\n\n");
            stringBuffer.append("Contact No. : " + cursor.getString(7) + "\n\n");
            stringBuffer.append("Email : " + cursor.getString(8) + "\n\n");
            stringBuffer.append("Is a Donor:" + cursor.getString(10) + "\n\n" + "- - - - - - - - - - - - - -- - - - - - - - - - - - - - - -\n");
        }
        showDonorData("ResultSet", stringBuffer.toString());



        //////////////////////////////////////////////////////////////////////////////////////









        /*******profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(TheDonorDetails.this, "profileButton is clicked.", Toast.LENGTH_SHORT).show();



                //Toast.makeText(DonorDetails.this, "Onclick.", Toast.LENGTH_SHORT).show();
                Cursor cursor = mydatabaseHelper.showTheDonorData(value);
                //Cursor cursor = mydatabaseHelper.showOneDonorData("2");
                //Cursor cursor = mydatabaseHelper.showAllData();
                if (cursor.getCount() == -1) {
                    Toast.makeText(TheDonorDetails.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(DonorDetails.this, "else.", Toast.LENGTH_SHORT).show();
                StringBuffer stringBuffer = new StringBuffer();
                while(cursor.moveToNext()) {
                    //Toast.makeText(DonorDetails.this, "while loop.", Toast.LENGTH_SHORT).show();
                    //call = cursor.getString(7);
                    //Toast.makeText(DonorDetails.this, "Number: "+call, Toast.LENGTH_SHORT).show();
                    stringBuffer.append("ID: " + cursor.getString(0) + "\n");
                    //stringBuffer.append("Id: " + cursor.getString(0) + "\n");
                    stringBuffer.append("Name: " + cursor.getString(1) + "\n");
                    stringBuffer.append("City: " + cursor.getString(2) + "\n");
                    stringBuffer.append("Location: " + cursor.getString(3) + "\n");
                    stringBuffer.append("Gender: " + cursor.getString(4) + "\n");
                    stringBuffer.append("Blood-Group: " + cursor.getString(5) + "\n");
                    stringBuffer.append("Date of Birth: " + cursor.getString(6) + "\n");
                    stringBuffer.append("Contact Number: " + cursor.getString(7) + "\n");
                    stringBuffer.append("Email: " + cursor.getString(8) + "\n");
                    stringBuffer.append("Is a Donor:" + cursor.getString(10));
                    //stringBuffer.append("Password: " + cursor.getString(9) + "\n\n");
                }
                showDonorData("ResultSet", stringBuffer.toString());



            }
        });********/








        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = mydatabaseHelper.showTheDonorData(value);
                if (cursor.getCount() == -1) {
                    Toast.makeText(TheDonorDetails.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(cursor.moveToNext()) {
                    call = cursor.getString(7);
                }



                //Toast.makeText(DonorDetails.this, "Clicked on the call button", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                //int CallingNumber = String.toInteger(call);
                Toast.makeText(TheDonorDetails.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
                callIntent.setData(Uri.parse("tel:"+call));
                if (ActivityCompat.checkSelfPermission(TheDonorDetails.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
                startActivity(callIntent);
                //Toast.makeText(DonorDetails.this, "After startActivity.", Toast.LENGTH_SHORT).show();
            }
        });



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(TheDonorDetails.this, EditDonorInfo.class);
                //Toast.makeText(DonorDetails.this, "Now in EditDonorDetails", Toast.LENGTH_SHORT).show();
                //String value = "v";
                intent.putExtra("tag",value);
                startActivity(intent);


            }
        });



        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
                builder.setTitle("Delete confirmation");
                builder.setMessage("Do you want to delete your information ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long rowId = mydatabaseHelper.DeleteTheDonorData(value);
                        if (rowId == -1) {
                            Toast.makeText(getApplicationContext(), " Unsuccessful.", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext()," Successfully Deleted.", Toast.LENGTH_SHORT).show();



                            AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
                            builder.setTitle("Your data is Successfully Deleted.");
                            builder.setMessage("Do you want to register ?");
                            builder.setCancelable(true);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(TheDonorDetails.this, DonorRegistration1.class);
                                    //Toast.makeText(DonorDetails.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });

                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(TheDonorDetails.this, TheDonorDetails.class);
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
                        //Intent intent = new Intent(TheDonorDetails.this, DonorRegistration1.class);
                        //Toast.makeText(DonorDetails.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                        //startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(TheDonorDetails.this, TheDonorDetails.class);
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



                /*long rowId = mydatabaseHelper.DeleteTheDonorData(value);

                if (rowId == -1) {
                    Toast.makeText(getApplicationContext(), " Unsuccessful.", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext()," Successfully Deleted.", Toast.LENGTH_SHORT).show();



                    AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
                    builder.setTitle("Your data is Successfully Deleted.");
                    builder.setMessage("Do you want to register ?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(TheDonorDetails.this, DonorRegistration1.class);
                            //Toast.makeText(DonorDetails.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(TheDonorDetails.this, TheDonorDetails.class);
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




                }*/
            }
        });




        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
                builder.setTitle("Do you want to send message ?");
                builder.setMessage("Standard Data Charge Apply.");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Cursor cursor = mydatabaseHelper.showTheDonorData(value);
                        if (cursor.getCount() == -1) {
                            Toast.makeText(TheDonorDetails.this, "No data Found.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        while(cursor.moveToNext()) {
                            call = cursor.getString(7);
                        }

                        sendSMS(call);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(TheDonorDetails.this, TheDonorDetails.class);
                        //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                /*Cursor cursor = mydatabaseHelper.showTheDonorData(value);
                if (cursor.getCount() == -1) {
                    Toast.makeText(TheDonorDetails.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(cursor.moveToNext()) {
                    call = cursor.getString(7);
                }

                sendSMS(call);*/

                 /*{
                    //Toast.makeText(getApplicationContext()," Successfully Deleted.", Toast.LENGTH_SHORT).show();



                    AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
                    builder.setTitle("Your data is Successfully Deleted.");
                    builder.setMessage("Do you want to register ?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(TheDonorDetails.this, DonorRegistration1.class);
                            //Toast.makeText(DonorDetails.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(TheDonorDetails.this, TheDonorDetails.class);
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
                    alertDialog.show();*/




            }
        });










        /*callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TheDonorDetails.this, "callButton is clicked.", Toast.LENGTH_SHORT).show();

            }
        });


        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TheDonorDetails.this, "messageButton is clicked.", Toast.LENGTH_SHORT).show();

            }
        });


        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TheDonorDetails.this, "emailButton is clicked.", Toast.LENGTH_SHORT).show();

            }
        });


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TheDonorDetails.this, "editButton is clicked.", Toast.LENGTH_SHORT).show();

            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TheDonorDetails.this, "deleteButton is clicked.", Toast.LENGTH_SHORT).show();

            }
        });*/






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
            Toast.makeText(TheDonorDetails.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(TheDonorDetails.this);
            builder.setTitle("Do you want send message ?");
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
                    Intent intent = new Intent(TheDonorDetails.this, MainActivity.class);
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
            Toast.makeText(TheDonorDetails.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(TheDonorDetails.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(TheDonorDetails.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(TheDonorDetails.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(TheDonorDetails.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(TheDonorDetails.this, ContactUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Option Menu finish---------------------------------------------------
    public void showDonorData(String title, String data){
        Toast.makeText(TheDonorDetails.this, "showdata().", Toast.LENGTH_SHORT).show();
        detailsTextview.setText(data);
    }

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
            Toast.makeText(TheDonorDetails.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }


}
