package com.supcoder.timqqguide

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * GuideAdapter
 *
 * @author lee
 * @date 2017/10/26
 */

class GuideAdapter (fm: FragmentManager?, var fragmentList: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}