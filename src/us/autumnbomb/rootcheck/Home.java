package us.autumnbomb.rootcheck;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.stericson.RootTools.RootTools;


public class Home extends SherlockActivity {

   

    private Button busybox, isBusyBox, isRootAvailable, isAccessGiven;


    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        setContentView(R.layout.main);
        
boolean installed  =   appInstalledOrNot("us.autumnbomb.rootcheckdonate");
        
        
        if(installed)
        {

                  System.out.println("Shooo dang! You supported me! Thanks!");

        }
        else
        {
        	
        	//Request an ad
        	AdView ad = (AdView) findViewById(R.id.adView);
        	ad.loadAd(new AdRequest());
            System.out.println("Techincally, you're still supporting, but through ads...");
        }
        
        


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

    private boolean appInstalledOrNot(String uri)
    {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try
        {
               pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
               app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
               app_installed = false;
        }
        return app_installed ;

        
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate your menu.
        getSupportMenuInflater().inflate(R.menu.menu, menu);

        
        // Set file with share history to the provider and set the share intent.
        MenuItem actionItem = menu.findItem(R.id.menu_item_share_action_provider_action_bar);
        ShareActionProvider actionProvider = (ShareActionProvider) actionItem.getActionProvider();
        actionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
        // Note that you can set/change the intent any time,
        // say when the user has selected an image.
        actionProvider.setShareIntent(createShareIntent());



        return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	   // Handle item selection
	   switch (item.getItemId()) {
	     
	      case R.id.about:
	    	  Intent a = new Intent(this, About.class);
	    	  startActivity(a);
	         return true;
	      default:
	         return super.onOptionsItemSelected(item);
	   }
	}



	

    /**
     * Creates a sharing {@link Intent}.
     *
     * @return The sharing intent.
     */
    private Intent createShareIntent() {
    	Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Holo Root Checker");
        intent.putExtra(Intent.EXTRA_TEXT, "Download 'Holo Root Checker' from Google Play today! http://goo.gl/hzQEF");
        return intent;
    }
}