package com.example.student.fragmentexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	//http://android-er.blogspot.ca/2011/12/dynamic-change-fragment-using-java-code.html
	//http://stackoverflow.com/questions/20176999/how-to-switch-between-fragments-during-onclick
	//http://www.javacodegeeks.com/2013/06/android-fragment-transaction-fragmentmanager-and-backstack.html
	//http://sapandiwakar.in/replacing-fragments/
	//http://www.tutorialspoint.com/android/android_fragments.htm
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button_1);

        //reference to the activity fragment manager
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();

        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");

	b1.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
		        //reference to the activity fragment manager
		        FragmentManager manager = getFragmentManager();
		        FragmentTransaction transaction = manager.beginTransaction();
		        Fragment one,two;
		        one = new FragmentOne();
		        two = new FragmentTwo();

		        if(check == true){
					    check = false;
		        }
		        else{
		            check = true;
		        }
		        if(check == false){
		            transaction.replace(R.id.fragView, one, "Fragment1");
		            transaction.replace(R.id.fragView, two, "Fragment2");
		        }
		        if(check == true){
		            transaction.replace(R.id.fragView, two, "Fragment2");
		            transaction.replace(R.id.fragView, one, "Fragment1");

              		}
			transaction.commit();
        	}
		
    	});
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
