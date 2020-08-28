package com.guna.multispinner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.guna.libmultispinner.MultiSelectionSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MultiSelectionSpinner.OnMultipleItemsSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] array = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        MultiSelectionSpinner multiSelectionArraySpinner = (MultiSelectionSpinner) findViewById(R.id.spinner_string_array);
        multiSelectionArraySpinner.setItems(array);
        multiSelectionArraySpinner.setSelection(new int[]{2, 6});
        multiSelectionArraySpinner.setListener(this);

        List<String> myList = new ArrayList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        MultiSelectionSpinner multiSelectionListSpinner = (MultiSelectionSpinner) findViewById(R.id.spinner_string_list);
        multiSelectionListSpinner.setItems(myList);
        multiSelectionListSpinner.setSelection(new int[]{0, 2});
        multiSelectionListSpinner.setListener(this);
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

    @Override
    public void selectedIndices(List<Integer> indices, MultiSelectionSpinner spinner) {

    }

    @Override
    public void selectedStrings(List<String> strings, MultiSelectionSpinner spinner) {
        switch (spinner.getId()) {
            case R.id.spinner_string_array:
                Toast.makeText(this, "Array : " + strings.toString(), Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_string_list:
                Toast.makeText(this, "List : " + strings.toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
