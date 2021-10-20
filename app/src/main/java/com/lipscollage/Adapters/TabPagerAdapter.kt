package com.lipscollage.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lipscollage.Fragments.Profile_ParentsFragment
import com.lipscollage.Fragments.Profile_PersonalFragment

class TabPagerAdapter( fm: FragmentActivity) :
    FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        return if (position == 0) {
            Profile_PersonalFragment()
        } else if (position == 1) {
            Profile_ParentsFragment()
        } else {
            Profile_PersonalFragment()
        }
    }

}