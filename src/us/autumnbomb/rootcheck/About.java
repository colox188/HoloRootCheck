package us.autumnbomb.rootcheck;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class About extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        TextView apache = (TextView) findViewById(R.id.apache);
        apache.setMovementMethod(LinkMovementMethod.getInstance());

        TextView apache2 = (TextView) findViewById(R.id.apache2);
        apache2.setMovementMethod(LinkMovementMethod.getInstance());

    }
}