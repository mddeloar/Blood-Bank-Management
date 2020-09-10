package com.example.mddeloarhossain.bloodbankmanagement;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllDonorPlace extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper myDatabaseHelper;
    private SearchView searchView;  //SearchView
    private AlertDialog.Builder alertDialogBuilder;
    private static String call="1";
    private CardView SeeAllCardView, ABPCV,APCV, BPCV, ABNCV, ANCV, BNCV, OPCV, ONCV;
    //int n;
    //String x[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_donor_place);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        listView = findViewById(R.id.ListViewId);
        searchView = findViewById(R.id.SearchViewId);   //SearchView
        SeeAllCardView = findViewById(R.id.UserSeeAllCardViewId);
        ABPCV = findViewById(R.id.ABPUserBloodGroupCardViewId);
        APCV = findViewById(R.id.APUserBloodGroupCardViewId);
        BPCV = findViewById(R.id.BPUserBloodGroupCardViewId);
        ABNCV = findViewById(R.id.ABNUserBloodGroupCardViewId);
        ANCV = findViewById(R.id.ANUserBloodGroupCardViewId);
        BNCV = findViewById(R.id.BNUserBloodGroupCardViewId);
        OPCV = findViewById(R.id.OPUserBloodGroupCardViewId);
        ONCV = findViewById(R.id.ONUserBloodGroupCardViewId);
        myDatabaseHelper = new MyDatabaseHelper(this);
        loadData();
        SeeAllCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, AllDonorInfoUser.class));
                //Toast.makeText(AllDonorPlace.this, "Log in first", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        ABPCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB+");
                startActivity(intent);
            }
        });

        APCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A+");
                startActivity(intent);
            }
        });

        BPCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B+");
                startActivity(intent);
            }
        });

        ABNCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","AB-");
                startActivity(intent);
            }
        });

        ANCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","A-");
                startActivity(intent);
            }
        });

        BNCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","B-");
                startActivity(intent);
            }
        });


        OPCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","O+");
                startActivity(intent);
            }
        });


        ONCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(AllDonorPlace.this, BloodStockBGIDonor.class));
                //Toast.makeText(BloodStockWithoutEdit.this, "Welcome to BloodStock", Toast.LENGTH_SHORT).show();
                intent.putExtra("tag","O-");
                startActivity(intent);
            }
        });

    }

    public void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = myDatabaseHelper.showAllDonorPlaceData();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No data is availabe.", Toast.LENGTH_SHORT).show();
        } else {
            //listData.add("Md Deloar Hosain.");

            //String place;
            //place=cursor.getString(0);
            while (cursor.moveToNext()) {

                //String place;
               /*String place = cursor.getString(0).toString();
                //for (int i=0; i<)

                n++;

                int j=0;
                for(int i=1; i<=n; i++)
                {
                    if(x[i-1]==place)
                    {
                        j=1;
                        //x[i]=place;
                        //listData.add(cursor.getString(0));
                    }


                }
                if(j==0)
                {
                    x[n]=place;
                    listData.add(cursor.getString(0));
                }*/


                listData.add(cursor.getString(0));

            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.donor_list_item, R.id.donorListItemTextViewId, listData);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.donor_list_item, R.id.donorListItemTextViewId, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String selectedValue = adapterView.getItemAtPosition(i).toString();
                Intent intent = (new Intent(AllDonorPlace.this, AllDonorPlacesInfo.class));
                //Toast.makeText(AllDonorPlace.this, "The Donor Details", Toast.LENGTH_SHORT).show();
                //intent.putExtra("tag",IdNumber);
                intent.putExtra("tag", selectedValue);
                startActivity(intent);


            }
        });


        //SearchView Start
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        //SearchView Finish
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
            Toast.makeText(AllDonorPlace.this,"Share is selected.",Toast.LENGTH_SHORT).show();


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

            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AllDonorPlace.this);
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
                    Intent intent = new Intent(AllDonorPlace.this, AllDonorPlace.class);
                    //Toast.makeText(MainActivity.this, "You can Log In Now", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            android.support.v7.app.AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return true;
        }
        if (item.getItemId()==R.id.requestCallId){
            call = "01765436702";
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            //int CallingNumber = String.toInteger(call);
            Toast.makeText(AllDonorPlace.this, "You calling Number is:"+call, Toast.LENGTH_SHORT).show();
            callIntent.setData(Uri.parse("tel:"+call));
            if (ActivityCompat.checkSelfPermission(AllDonorPlace.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(DonorDetails.this, "In if method", Toast.LENGTH_SHORT).show();
                return true;
            }
            //Toast.makeText(DonorDetails.this, "Before startActivity.", Toast.LENGTH_SHORT).show();
            startActivity(callIntent);
            return true;
        }
        if (item.getItemId()==R.id.facebooId){
            Toast.makeText(AllDonorPlace.this,"Facebook is selected.",Toast.LENGTH_SHORT).show();
            //Intent intent = (new Intent(MainActivity.this, UserRequest.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            //startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.FeedbackId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(AllDonorPlace.this, Feedback.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.AboutUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(AllDonorPlace.this, AboutUs.class));
            //Toast.makeText(MainActivity.this, "All Donor Information.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }
        if (item.getItemId()==R.id.ContactUsId){
            //Toast.makeText(MainActivity.this,"Feedback is selected.",Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(AllDonorPlace.this, ContactUs.class));
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
            Toast.makeText(AllDonorPlace.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
