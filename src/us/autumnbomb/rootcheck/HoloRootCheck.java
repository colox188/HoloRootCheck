package us.autumnbomb.rootcheck;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HoloRootCheck extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.holorootcheck);
	

    TextView apache2 = (TextView) findViewById(R.id.apache2);
    apache2.setMovementMethod(LinkMovementMethod.getInstance());

}
}