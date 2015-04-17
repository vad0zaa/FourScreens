package ee.sinchukov.fourscreens;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class FirstScreen extends Activity {


    public static final String SETTINGS_NAME = "FourScreenSettings";

    public static final String EXTRA_NAME = "ee.sinchukov.fourscreens.NAME";
    public static final String EXTRA_EMAIL = "ee.sinchukov.fourscreens.EMAIL";
    public static final String EXTRA_PHONE = "ee.sinchukov.fourscreens.PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_screen, menu);
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

    public void showSecondScreen(View view){

        // save editText data
        Intent intent = new Intent(this,SecondScreen.class);
        EditText editText = (EditText) findViewById(R.id.edit_name);
        String name = editText.getText().toString();
        intent.putExtra(FirstScreen.EXTRA_NAME, name);

        // save data to settings
        saveDataToApplicationSettings(FirstScreen.EXTRA_NAME, name);

        //show second screen
        startActivity(intent);
    }

    public void saveDataToApplicationSettings(String key, String value){

        // save key-value to application settings
        SharedPreferences settings = getSharedPreferences(SETTINGS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key,value);
        editor.commit();

    }

    public String getDataFromApplicationSettings(String key){

        String value;
        // save key-value to application settings
        SharedPreferences settings = getSharedPreferences(SETTINGS_NAME, 0);
        value = settings.getString(key, "not found");
        return value;
    }


}
