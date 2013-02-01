package us.autumnbomb.rootcheck;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class RootToolsLicense extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roottools);
	

    TextView apache = (TextView) findViewById(R.id.apache);
    apache.setMovementMethod(LinkMovementMethod.getInstance());

}
}