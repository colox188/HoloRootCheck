package us.autumnbomb.rootcheck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.stericson.RootTools.RootTools;

public class Home extends Activity {


    private ShareActionProvider mShareActionProvider;

    private Button busybox, isBusyBox, isRootAvailable, isAccessGiven;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Request an ad
        AdView ad = (AdView) findViewById(R.id.adView);
        ad.loadAd(new AdRequest());
        


        busybox = (Button) findViewById(R.id.busybox);
        busybox.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RootTools.offerBusyBox(Home.this);
            }
        });

        isBusyBox = (Button) findViewById(R.id.isbusybox);
        isBusyBox.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RootTools.isBusyboxAvailable()) {
                    makeToast("BusyBox is installed!");
                } else {
                    makeToast("BusyBox is not installed!");
                }
            }
        });

        isRootAvailable = (Button) findViewById(R.id.isRootAvailable);
        isRootAvailable.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RootTools.isRootAvailable()) {
                    makeToast("Your device has root!");
                } else {
                    makeToast("No Root Access!");
                }
            }
        });

        isAccessGiven = (Button) findViewById(R.id.isAccessGiven);
        isAccessGiven.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RootTools.isAccessGiven()) {
                    makeToast("Root access has been granted!");
                } else {
                    makeToast("Root access has not been granted!");
                }
            }
        });

    }


    public void makeToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        /** Inflating the current activity's menu with res/menu/items.xml */
        getMenuInflater().inflate(R.menu.menu, menu);



        /** Getting the actionprovider associated with the menu item whose id is share */
/**        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider(); */


        /** Setting a share intent */
/*        mShareActionProvider.setShareIntent(getDefaultShareIntent()); */


        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.about:
                    Intent about = new Intent(this, About.class);
                    this.startActivity(about);
                    return true;
                             
                             
                case R.id.change:
                    Intent changelog = new Intent(this, ChangeLog.class);
                    this.startActivity(changelog);
                    return true;


            default:
                return super.onOptionsItemSelected(item); }
             

    }

    /** Returns a share intent */
    private Intent getDefaultShareIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Holo Root Check");
        intent.putExtra(Intent.EXTRA_TEXT, "Download 'Holo Root Check' from Google Play today! http://goo.gl/auZld");
        return intent;
    }

}