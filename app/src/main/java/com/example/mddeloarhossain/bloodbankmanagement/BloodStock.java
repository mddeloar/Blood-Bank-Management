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

public class BloodStock extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;
    //private CardView ABpositive, Apositive, Bpositive, ABnegative, Anegative, Bnegative, Opositive, Onegative;
    private TextView ABPositive, APositive, BPositive, ABNegative, ANegative, BNegative, OPositive, ONegative;
    private String ABpositive, Apositive, Bpositive, ABnegative, Anegative, Bnegative, Opositive, Onegative;
    private CardView ABnpositivee, Anpositivee, Bnpositivee, ABnnegativee, Annegativee, Bnnegativee, Onpositivee, Onnegativee;
    private CardView editCardView, deleteCardView;
    private String test;
    private static String call="1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_stock);


        mydatabaseHelper = new MyDatabaseHelper(BloodStock.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        ABPositive = findViewById(R.id.ABPb);
        APositive = findViewById(R.id.APb);
        BPositive = findViewById(R.id.BPb);
        ABNegative = findViewById(R.id.ABNb);
        ANegative = findViewById(R.id.ANb);
        BNegative = findViewById(R.id.BNb);
        OPositive = findViewById(R.id.OPb);
        ONegative = findViewById(R.id.ONb);

        ABnpositivee = findViewById(R.id.ABpositiveeCardViewId);
        Anpositivee = findViewById(R.id.ApositiveeCardViewId);
        Bnpositivee = findViewById(R.id.BpositiveeCardViewId);
        ABnnegativee = findViewById(R.id.ABnegativeeCardViewId);
        Annegativee = findViewById(R.id.AnegativeeCardViewId);
        Bnnegativee = findViewById(R.id.BnegativeeCardViewId);
        Onpositivee = findViewById(R.id.OpositiveeCardViewId);
        Onnegativee = findViewById(R.id.OnegativeeCardViewId);


        editCardView = findViewById(R.id.EditEditBloodStockId);
        deleteCardView = findViewById(R.id.EditDeleteBloodStockId);

        //showBottal = findViewById(R.id.BloodStockBottolShowCardViewId);


        /*showBottal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {


                    Cursor cursor = mydatabaseHelper.RetriveBloodStockData();

                    if (cursor.getCount() == -1) {
                        Toast.makeText(BloodStock.this, "No data Found.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //String Ausername,Apassword;
                    while (cursor.moveToNext()) {

                        ABpositive = cursor.getString(0);
                        Apositive = cursor.getString(1);
                        Bpositive = cursor.getString(2);
                        ABnegative = cursor.getString(3);
                        Anegative = cursor.getString(4);
                        Bnegative = cursor.getString(5);
                        Opositive = cursor.getString(6);
                        Onegative = cursor.getString(7);

                    }
                }catch (Exception e){
                    Toast.makeText(BloodStock.this, "Exception"+e, Toast.LENGTH_LONG).show();
                }


                ABPositive.setText(ABpositive);
                APositive.setText(Apositive);
                BPositive.setText(Bpositive);
                ABNegative.setText(ABnegative);
                ANegative.setText(Anegative);
                BNegative.setText(Bnegative);
                OPositive.setText(Opositive);
                ONegative.setText(Onegative);

            }
        });*/


        Cursor cursor = mydatabaseHelper.RetriveBloodStockData();

        if (cursor.getCount() == -1) {
            Toast.makeText(BloodStock.this, "No data Found.", Toast.LENGTH_SHORT).show();
            return;
        }
        //String Ausername,Apassword;
        while(cursor.moveToNext()) {


                        ABpositive = cursor.getString(0);
                        test=ABpositive;
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



        ABnpositivee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB+");
                startActivity(intent);
            }
        });

        Anpositivee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A+");
                startActivity(intent);
            }
        });

        Bnpositivee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B+");
                startActivity(intent);
            }
        });

        ABnnegativee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB-");
                startActivity(intent);
            }
        });

        Annegativee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A-");
                startActivity(intent);
            }
        });

        Bnnegativee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B-");
                startActivity(intent);
            }
        });


        Onpositivee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","O+");
                startActivity(intent);
            }
        });


        Onnegativee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(BloodStock.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","O-");
                startActivity(intent);
            }
        });



        editCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Cursor cursor = mydatabaseHelper.RetriveBloodStockData();
                if (cursor.getCount() == -1) {
                    Toast.makeText(BloodStock.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(cursor.moveToNext()) {

                    ABpositive = cursor.getString(0);
                    /*Apositive = cursor.getString(1);
                    Bpositive = cursor.getString(2);
                    ABnegative = cursor.getString(3);
                    Anegative = cursor.getString(4);
                    Bnegative = cursor.getString(5);
                    Opositive = cursor.getString(6);
                    Onegative = cursor.getString(7);*/

                /*}*/

                /*if (ABpositive.equals("")) {
                    Toast.makeText(BloodStock.this, "No data Found.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BloodStock.this, BloodStockInput.class);
                    startActivity(intent);
                    return;
                }*/
               // else {


                    Intent intent = new Intent(BloodStock.this, BloodStockEdit.class);
                    startActivity(intent);
                //}


            }
        });


        deleteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                AlertDialog.Builder builder = new AlertDialog.Builder(BloodStock.this);
                builder.setTitle("Delete confirmation");
                builder.setMessage("Do you want to delete this information ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long rowId = mydatabaseHelper.BloodStockEditInputData(test,"0","0","0","0","0","0","0","0");
                        if (rowId == -1) {
                            Toast.makeText(getApplicationContext(), " Unsuccessful.", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext()," Successfully Deleted.", Toast.LENGTH_SHORT).show();



                            AlertDialog.Builder builder = new AlertDialog.Builder(BloodStock.this);
                            builder.setTitle("Your data is Successfully Deleted.");
                            //builder.setMessage("Do you want to register ?");
                            builder.setCancelable(true);
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(BloodStock.this, BloodStock.class);
                                    //Toast.makeText(DonorDetails.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });

                            /*builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(BloodStock.this, BloodStock.class);
                                    //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            });

                            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });*/

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
                        Intent intent = new Intent(BloodStock.this, TheDonorDetails.class);
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
            Toast.makeText(BloodStock.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(BloodStock.this);
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
                    Intent intent = new Intent(BloodStock.this, BloodStock.class);
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
            Toast.makeText(BloodStock.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(BloodStock.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(BloodStock.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStock.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStock.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStock.this, ContactUs.class));
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
            Toast.makeText(BloodStock.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
