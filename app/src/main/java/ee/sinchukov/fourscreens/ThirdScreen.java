package ee.sinchukov.fourscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ThirdScreen extends FirstScreen {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        // get extras from Second Screen
        extras = getIntent().getExtras();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third_screen, menu);
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

    public void showFourthScreen(View view){

        // pass third screen data to extra
        Intent intent = new Intent(this,FourthScreen.class);
        EditText editText = (EditText) findViewById(R.id.edit_phone);
        String phone = editText.getText().toString();
        intent.putExtra(FirstScreen.EXTRA_PHONE, phone);

        // save third screen data to settings
        saveDataToApplicationSettings(FirstScreen.EXTRA_PHONE, phone);

        // pass first screen data to extra
        String name = extras.getString(FirstScreen.EXTRA_NAME);
        intent.putExtra(FirstScreen.EXTRA_NAME, name);

        // pass second screen data to extra
        String email = extras.getString(FirstScreen.EXTRA_EMAIL);
        intent.putExtra(FirstScreen.EXTRA_EMAIL, email);


        // show fourth screen
        startActivity(intent);
    }
}
