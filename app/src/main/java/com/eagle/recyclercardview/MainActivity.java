package com.eagle.recyclercardview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.eagle.recyclercardview.adapter.RecyclerAdapter;
import com.eagle.recyclercardview.model.Lamp;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    Toolbar toolbar;

    private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.setting);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setIntent("This is example text");
        return true;
    }

    private void setIntent(String s) {
       if (mShareActionProvider == null) Log.d(TAG, "actionProvider = null");
        if (mShareActionProvider != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, s);
            mShareActionProvider.setShareIntent(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg = "";

        switch (item.getItemId()){

                    case R.id.discard:
                        msg = "Delete";
                        startOrderActivity(this);
                        break;

                    case R.id.edit:
                        msg = "Edit";
                        break;

                    case R.id.exit:
                        msg = "Exit";
                        break;

                    case R.id.search:
                        msg = "Search";
                        break;

                    case R.id.setting:
                        msg = "Setting";
                        break;
                }

        Toast.makeText(this, msg + " clicked", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

    public static void startOrderActivity(Context context) {
        Intent starter = new Intent(context, ActivityOrder.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("Home Page!");

//        getSupportActionBar().setSubtitle("Folks!");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Lamp.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }





}
