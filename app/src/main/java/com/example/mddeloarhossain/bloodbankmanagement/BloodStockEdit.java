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
import android.widget.Toast;

public class BloodStockEdit extends AppCompatActivity {

    MyDatabaseHelper mydatabaseHelper;
    private EditText ABpositive, Apositive, Bpositive, ABnegative, Anegative, Bnegative, Opositive, Onegative;
    private CardView saveButton;
    private String test ;
    private static String call="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_stock_edit);


        mydatabaseHelper = new MyDatabaseHelper(BloodStockEdit.this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ABpositive = findViewById(R.id.EditABpb);
        Apositive = findViewById(R.id.EditApb);
        Bpositive = findViewById(R.id.EditBpb);
        ABnegative = findViewById(R.id.EditABnb);
        Anegative = findViewById(R.id.EditAnb);
        Bnegative = findViewById(R.id.EditBnb);
        Opositive = findViewById(R.id.EditOpb);
        Onegative = findViewById(R.id.EditOnb);

        saveButton = findViewById(R.id.EditBloodStockBottolSaveInfoCardViewId);



        Cursor cursor = mydatabaseHelper.RetriveBloodStockData();

        while(cursor.moveToNext()) {
            test = cursor.getString(0);
            ABpositive.setText(cursor.getString(0));
            Apositive.setText(cursor.getString(1));
            Bpositive.setText(cursor.getString(2));
            //RBloodGroupEditText.setText(cursor.getString(5));
            ABnegative.setText(cursor.getString(3));
            Anegative.setText(cursor.getString(4));
            Bnegative.setText(cursor.getString(5));
            Opositive.setText(cursor.getString(6));
            Onegative.setText(cursor.getString(7));
        }



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ABp = ABpositive.getText().toString();
                String Ap = Apositive.getText().toString();
                String Bp = Bpositive.getText().toString();
                String ABn = ABnegative.getText().toString();
                String An = Anegative.getText().toString();
                String Bn = Bnegative.getText().toString();
                String Op = Opositive.getText().toString();
                String On = Onegative.getText().toString();

                //long rowId = mydatabaseHelper.BloodStockEditInputData("1",ABp,Ap,Bp,ABn,An,Bn,Op,On);
                long rowId = mydatabaseHelper.BloodStockEditInputData(test,ABp,Ap,Bp,ABn,An,Bn,Op,On);

                if (rowId == -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BloodStockEdit.this);
                    builder.setTitle("Your data is being insert..");
                    builder.setMessage("Unsuccessfully.");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(BloodStockEdit.this, BloodStockEdit.class);
                            //Toast.makeText(DonorRegistration1.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    //Toast.makeText(getApplicationContext(), "" + rowId + " Unsuccessful.", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(), "" + rowId + " Successfully Inserted.", Toast.LENGTH_SHORT).show();


                    AlertDialog.Builder builder = new AlertDialog.Builder(BloodStockEdit.this);
                    //builder.setTitle("Your data is Successfully inserted.");
                    builder.setMessage("Your data is Successfully inserted.");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(BloodStockEdit.this, BloodStock.class);
                            //Toast.makeText(BloodStockInput.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });



                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

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
            Toast.makeText(BloodStockEdit.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            AlertDialog.Builder builder = new AlertDialog.Builder(BloodStockEdit.this);
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
                    Intent intent = new Intent(BloodStockEdit.this, BloodStockEdit.class);
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
            Toast.makeText(BloodStockEdit.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(BloodStockEdit.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(BloodStockEdit.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockEdit.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockEdit.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(BloodStockEdit.this, ContactUs.class));
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
            Toast.makeText(BloodStockEdit.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
