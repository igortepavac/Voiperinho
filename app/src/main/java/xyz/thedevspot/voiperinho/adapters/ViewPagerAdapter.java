package xyz.thedevspot.voiperinho.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by foi on 10/01/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment ret = null;

        if (fragmentArrayList != null) {
            ret = fragmentArrayList.get(position);
        }

        return ret;
    }

    @Override
    public int getCount() {
        int ret = 0;

        if (fragmentArrayList != null) {
            ret = fragmentArrayList.size();
        }

        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Contacts";
            case 1:
                return "Requests";
        }
        return null;
    }
}
