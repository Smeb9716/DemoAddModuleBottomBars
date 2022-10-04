package com.example.scannerandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBottomTabStrip();


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