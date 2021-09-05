package com.example.uipractice.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.uipractice.Fragment.FirstFragment
import com.example.uipractice.Fragment.SecondFragment
import com.example.uipractice.Fragment.ThirdFragment

/*
* Base class providing the adapter to populate pages inside of a ViewPager
*
* fragment – if the ViewPager2 lives directly in a Fragment subclass.
* FragmentStateAdapter(FragmentManager, Lifecycle)
* fragmentManager 	FragmentManager: of ViewPager2's host
* lifecycle 	Lifecycle: of ViewPager2's host
* */
class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> Fragment()
        }
    }
}