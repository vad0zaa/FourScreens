package ee.sinchukov.fourscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SecondScreen extends FirstScreen {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // get extras from First Screen
        extras = getIntent().getExtras();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_screen, menu);
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

    public void showThirdScreen(View view){

        // pass second screen data to extra
        Intent intent = new Intent(this,ThirdScreen.class);
        EditText editText = (EditText) findViewById(R.id.edit_email);
        String email = editText.getText().toString();
        intent.putExtra(FirstScreen.EXTRA_EMAIL, email);

        // save second screen data to settings
        saveDataToApplicationSettings(FirstScreen.EXTRA_EMAIL, email);

        // pass first screen data to extra
        String name = extras.getString(FirstScreen.EXTRA_NAME);
        intent.putExtra(FirstScreen.EXTRA_NAME, name);

        // show third screen
        startActivity(intent);
    }
}
