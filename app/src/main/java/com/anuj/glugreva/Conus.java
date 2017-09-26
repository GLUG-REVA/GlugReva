package com.anuj.glugreva;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class Conus extends AppCompatActivity {

    public ImageView v;

    private ListView listView;
    private String names[] = {
            "Ujwal",
            "Anuj",
            "Akash",
            "Prof. Manjunath PC",
            "Prof. Ranjitha U.N"
    };

    private String desc[] = {
            " ",
            " ",
            " ",
            " ",
            " "
    };


    private Integer imageid[] = {
            R.drawable.logoo,
            R.drawable.logoo,
            R.drawable.logoo,
            R.drawable.logoo,
            R.drawable.logoo
    };

    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conus);


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(Conus.this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Conus.this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(Conus.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        i);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        CustomList customList = new CustomList(this, names, desc, imageid);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (names[i] == "Ujwal") {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "7019245542", null)));
                }

                if (names[i] == "Anuj") {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9742706888", null)));
                }

                if (names[i] == "Akash") {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "8971358197", null)));
                }

                if (names[i] == "Prof. Manjunath PC") {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9886163804", null)));
                }

                if (names[i] == "Prof. Ranjitha U.N") {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9900499044", null)));
                }



            }
        });


    }

   /* private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    */@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
