package ee.sinchukov.fourscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class FourthScreen extends FirstScreen {

    TextView textViewName,textViewEmail, textViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_screen);

        // get collected info from EXTRA and from settings
        Intent intent = getIntent();

        String nameFromSettings = getDataFromApplicationSettings(FirstScreen.EXTRA_NAME);
        String nameFromExtra = intent.getStringExtra(FirstScreen.EXTRA_NAME);
        textViewName = (TextView)findViewById(R.id.textView_Name);

        String emailFromSettings = getDataFromApplicationSettings(FirstScreen.EXTRA_EMAIL);
        String emailFromExtra = intent.getStringExtra(FirstScreen.EXTRA_EMAIL);
        textViewEmail = (TextView)findViewById(R.id.textView_Email);

        String phoneFromSettings = getDataFromApplicationSettings(FirstScreen.EXTRA_PHONE);
        String phoneFromExtra = intent.getStringExtra(FirstScreen.EXTRA_PHONE);
        textViewPhone = (TextView)findViewById(R.id.textView_Phone);

        // set collected info to textView elements on screen
        textViewName.setText(" NAME: from settings-"+nameFromSettings + "\n NAME: from extra-"+nameFromExtra);
        textViewEmail.setText("\n EMAIL: from settings-"+emailFromSettings + "\n EMAIL: from extra-"+emailFromExtra);
        textViewPhone.setText("\n PHONE: from settings-"+phoneFromSettings + "\n PHONE: from extra-"+phoneFromExtra);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fourth_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showFirstScreen(View view){
        Intent showFirstScreenIntent = new Intent(this,FirstScreen.class);
        startActivity(showFirstScreenIntent);
    }

}
