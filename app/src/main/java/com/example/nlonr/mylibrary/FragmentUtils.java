package com.example.nlonr.mylibrary;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import java.util.List;

public class FragmentUtils {

    public static void showHideFragment(FragmentManager fragmentManager, Fragment showFragment) {
        showHideFragmentTransaction(fragmentManager, showFragment);
    }

    public static void loadRootFragment(int containerViewId,FragmentManager fragmentManager,List<Fragment> fragments) {
        loadFragmentsTransaction(containerViewId, 0, fragmentManager, fragments);
    }

    public static void loadFragments(int containerViewId,int showPosition,FragmentManager fragmentManager,List<Fragment> fragments) {
        loadFragmentsTransaction(containerViewId, showPosition, fragmentManager, fragments);
    }

    private static void loadFragmentsTransaction(int containerViewId, int showPosition, FragmentManager fragmentManager, List<Fragment> fragments) {

        if (!fragments.isEmpty()) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                ft.add(containerViewId, fragment, String.valueOf(fragment.getClass()));
                if (showPosition == i) {
                    ft.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
                } else {
                    ft.hide(fragment);
                    ft.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
                }
            }
            ft.commit();

        } else {
            throw new IllegalStateException("fragments must not empty");
        }
    }

    private static void showHideFragmentTransaction(FragmentManager fragmentManager, Fragment showFragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.show(showFragment);
        ft.setMaxLifecycle(showFragment, Lifecycle.State.RESUMED);
        List<Fragment> fragments = fragmentManager.getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            if (showFragment != fragments.get(i)) {
                ft.hide(fragments.get(i));
                ft.setMaxLifecycle(fragments.get(i), Lifecycle.State.STARTED);
            }
        }
        ft.commit();
    }


}
