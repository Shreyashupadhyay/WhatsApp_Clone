package com.example.whatsapp_clone.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.whatsapp_clone.Fregment.CallFragment;
import com.example.whatsapp_clone.Fregment.Chat_Fragment;
import com.example.whatsapp_clone.Fregment.StatusFragment;

public class fragmentAdapter extends FragmentPagerAdapter {
    public fragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Chat_Fragment();
            case 1: return new StatusFragment();
            case 2: return new CallFragment();
            default: return new Chat_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position ==0){
            title = "CHATS";
        }
        if(position ==0){
            title = "STATUS";
        }
        if(position ==0){
            title = "CALLS";
        }
        return title;
    }
}
