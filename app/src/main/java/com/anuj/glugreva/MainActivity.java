package com.anuj.glugreva;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView slidingimage, banner, intr1, intr2, intr3 ;
    ArrayList<String> slid= new ArrayList<String>();
    public int index=0,i;
    Button b,im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null)
                && (wifi.isConnected() | datac.isConnected())) {
            //connection is avlilable
            //Toast.makeText(getApplicationContext(),"Available",Toast.LENGTH_SHORT).show();
        }else{

            Intent i = new Intent(MainActivity.this,Cnctnlst.class);
            startActivity(i);
            finish();
            //no connection

        }

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout1);

        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle("GLUG-REVA");

        slid.add("http://s17.postimg.org/iqqpfppzz/billi.jpg");
        slid.add("http://s17.postimg.org/3w241jgf3/cpp.jpg");
        slid.add("http://s17.postimg.org/86ldavavz/foot.jpg");
        slid.add("http://s17.postimg.org/dw1lv6h27/html.jpg");
        slid.add("http://s17.postimg.org/valu3ge73/joomla.jpg");
        slid.add("http://s17.postimg.org/nj544wa1r/js.jpg");
        slid.add("http://s17.postimg.org/n7nns4tlr/python.jpg");
        slid.add("http://s17.postimg.org/jck9pkafz/ubuntu.jpg");


        final Handler mHandler = new Handler();
        //   Toast.makeText(getApplicationContext(), (CharSequence) namecity,Toast.LENGTH_LONG).show();
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };

        int delay = 3000; // delay for 1 sec.

        int period = 3500; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);


        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSdTlH3HNtiWc8V7CwdeMRZTrsh0uAkudLlUS3Ppt2J8bJYODA/viewform";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        banner= (ImageView) findViewById(R.id.imageView);
        intr1=(ImageView)findViewById(R.id.int1);
        intr2=(ImageView)findViewById(R.id.int2);
        intr3=(ImageView)findViewById(R.id.im);
        //Glide.with(getApplicationContext()).load("https://s13.postimg.org/56d0yf0vb/background1.jpg").into(banner);
        Glide.with(getApplicationContext()).load("http://s22.postimg.org/w4d53vty9/intro.jpg").into(intr1);
        Glide.with(getApplicationContext()).load("https://s16.postimg.org/km5bd22b9/fsmk.jpg").into(intr2);
        Glide.with(getApplicationContext()).load("https://s21.postimg.org/6om4tszdj/revan.png").into(intr3);
    }

    private void AnimateandSlideShow() {


        slidingimage = (ImageView) findViewById(R.id.slidingimagee);
        Glide.with(getApplicationContext()).load(slid.get(index)).into(slidingimage);
        index++;

        if (index == 6) {
            index = 0;
        }
        Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        slidingimage.startAnimation(rotateimage);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();


        }
    }

    @Override
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.conus) {

            Intent i = new Intent(MainActivity.this,Conus.class);
            startActivity(i);

        } else if (id == R.id.abtus) {

            Intent b = new Intent(MainActivity.this,About_us.class);
            startActivity(b);

        }  else if (id == R.id.share) {

            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.SEND_SMS)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.SEND_SMS },
                            i);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, " ");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.fbk) {
            Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Glug-REVA");
            intent.setData(Uri.parse("mailto:glugreva@gmail.com")); // or just "mailto:" for blank
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
