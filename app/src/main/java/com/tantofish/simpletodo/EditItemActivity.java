package com.tantofish.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {

    String itemText;
    Integer itemPos;
    EditText etItem;
    Button saveBtn;

    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItem = (EditText) findViewById(R.id.etItem);
        saveBtn = (Button) findViewById(R.id.btnSave);

        getData();
        etItem.setText(itemText);


    }

    private void getData() {
        Bundle bundle = this.getIntent().getExtras();
        itemText = bundle.getString("itemText");
        itemPos  = bundle.getInt("itemPos");
    }

    public void onSave(View v) {
        itemText = etItem.getText().toString();

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("itemText", itemText);
        bundle.putInt("itemPos", itemPos);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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
