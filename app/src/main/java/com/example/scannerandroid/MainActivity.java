package com.example.scannerandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBottomTabStrip();
        showSmoothBottomBar();


    }

    private void showSmoothBottomBar() {
        // Link web : https://github.com/ibrahimsn98/SmoothBottomBar
        // Link git : https://github.com/ibrahimsn98/SmoothBottomBar.git
        // Add module : folder lib
        // Clone project : folder app


        SmoothBottomBar smoothBottomBar = findViewById(R.id.bottomBar);
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int pos) {
                Toast.makeText(MainActivity.this, "SmoothBottomBar : "+pos, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void showBottomTabStrip() {
        // Link web : https://github.com/tyzlmjj/PagerBottomTabStrip
        // Link git : https://github.com/tyzlmjj/PagerBottomTabStrip.git
        // Add module : folder pager-bottom-tab-strip
        // Clone project : folder app

        PageNavigationView tab = findViewById(R.id.tab);
        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.ic_restore_gray_24dp, R.drawable.ic_restore_teal_24dp, "Recents"))
                .addItem(newItem(R.drawable.ic_favorite_gray_24dp, R.drawable.ic_favorite_teal_24dp, "Favorites"))
                .addItem(newRoundItem(R.drawable.ic_nearby_gray_24dp, R.drawable.ic_nearby_teal_24dp, "Nearby"))
                .addItem(newItem(R.drawable.ic_favorite_gray_24dp, R.drawable.ic_favorite_teal_24dp, "Favorites"))
                .addItem(newItem(R.drawable.ic_restore_gray_24dp, R.drawable.ic_restore_teal_24dp, "Recents"))
                .build();

        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Toast.makeText(MainActivity.this, "BottomTabStrip : "+index, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRepeat(int index) {

            }
        });

    }

    // tab normal in module pager-bottomtab-strip
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(0xFF888888);
        mainTab.setTextCheckedColor(0xFF009688);
        return mainTab;
    }

    // tab round in module pager-bottomtab-strip
    private BaseTabItem newRoundItem(int drawable, int checkedDrawable, String text) {
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(0xFF888888);
        mainTab.setTextCheckedColor(0xFF009688);
        return mainTab;
    }
}