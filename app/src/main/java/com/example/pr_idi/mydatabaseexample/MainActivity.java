package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FilmData filmData;
    List<Film> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //----------------
        filmData = new FilmData(this);
        filmData.open();

        values = filmData.getAllFilms();
        ListView list = (ListView) findViewById(android.R.id.list);

        ArrayAdapter<Film> adapter = new ArrayAdapter<>(this,
                R.layout.listitem, values);
        list.setAdapter(adapter);
        registerForContextMenu(list);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_afegir_peli) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Frag_afegir_peli()).commit();

        } else if (id == R.id.nav_cercar_actors) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Frag_cercar_actors()).commit();
        } else if (id == R.id.nav_modificar_nota) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Frag_modificar_nota()).commit();
        } else if (id == R.id.nav_ordenat_any) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Frag_ordenat_any()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==android.R.id.list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            String[] menuItems = {"Modificar nota"};
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }
}
