package com.gamecodeschool.fragmentslider;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    SimpleFragmentPagerAdapter pageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize a list of three fragments
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        // Add three new Fragments to the list
        fragmentList.add(SimpleFragment.newInstance("1"));
        fragmentList.add(SimpleFragment.newInstance("2"));
        fragmentList.add(SimpleFragment.newInstance("3"));

        pageAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);

    }



    private class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
        // A List to hold our fragments
        private List<Fragment> fragments;

        // A constructor to receive a fragment manager and a List
        public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        // Just two methods to override to get the current position of the adapter and the size of the List
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }


}
