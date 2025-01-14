package com.recursionlabs.thecommuter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Shubhang on 2/16/2015.
 */
public class AboutFragment extends Fragment {
    int[] images = {R.drawable.red_line, R.drawable.blue_line, R.drawable.brown_line, R.drawable.green_line, R.drawable.orange_line,
            R.drawable.purple_line, R.drawable.pink_line, R.drawable.yellow_line};
    String[] lines = {"Red Line", "Blue Line", "Brown Line", "Green Line", "Orange Line", "Purple Line", "Pink Line", "Yellow Line"};

    ListView list;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;

    @Override
    public void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        mDrawerLayout = (DrawerLayout) rootView.findViewById(R.id.drawer_layout);
        AboutActivity.mDrawerLayout = mDrawerLayout;

        navigationView = (NavigationView) rootView.findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                int id = menuItem.getItemId();
                Intent intent;

                if (id == R.id.nav_favorites) {
                    intent = new Intent(getActivity(), FavoritesActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_home) {
                    intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_settings) {
                    intent = new Intent(getActivity(), SettingsActivity.class);
                    startActivity(intent);
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        TextView international = (TextView) rootView.findViewById(R.id.international_4_0);
        international.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://creativecommons.org/licenses/by-sa/4.0/deed.en"));
                startActivity(intent);
            }
        });

        TextView unported = (TextView) rootView.findViewById(R.id.unported_3_0);
        unported.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://creativecommons.org/licenses/by-sa/3.0/deed.en"));
                startActivity(intent);
            }
        });

        TextView generic_2_5 = (TextView) rootView.findViewById(R.id.generic_2_5);
        generic_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://creativecommons.org/licenses/by-sa/2.5/deed.en"));
                startActivity(intent);
            }
        });

        TextView generic_2_0 = (TextView) rootView.findViewById(R.id.generic_2_0);
        generic_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://creativecommons.org/licenses/by-sa/2.0/deed.en"));
                startActivity(intent);
            }
        });

        TextView generic_1_0 = (TextView) rootView.findViewById(R.id.generic_1_0);
        generic_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://creativecommons.org/licenses/by-sa/1.0/deed.en"));
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("About");
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburger);
        }

        return rootView;
    }
}