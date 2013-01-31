package us.autumnbomb.rootcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class About extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        View showHoloRootCheck = findViewById(R.id.showHoloRootCheck);
    	showHoloRootCheck.setOnClickListener(this);
    	
        View showRootTools = findViewById(R.id.showRootTools);
        showRootTools.setOnClickListener(this);
    	
    }
    	
		@Override
		public void onClick(View v) {
	      switch (v.getId()) {
	      case R.id.showHoloRootCheck:
	    	  Intent i = new Intent(this, HoloRootCheck.class);
	    	  startActivity(i);
	    	  break;
	    	  
	      case R.id.showRootTools:
	    	  Intent r = new Intent(this, RootTools.class);
	    	  startActivity(r);
	    	  break;
	      }

    
		
	}
}