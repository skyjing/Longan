@file:Suppress("unused")

package com.dylanc.grape

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * @author Dylan Cai
 */

fun FragmentStateAdapter(fragmentActivity: FragmentActivity, fragmentList: List<Fragment>) =
  object : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]
  }

fun FragmentStateAdapter(fragment: Fragment, fragmentList: List<Fragment>) =
  object : FragmentStateAdapter(fragment) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]
  }

fun FragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, itemCount: Int, createFragment: (Int) -> Fragment) =
  object : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = itemCount
    override fun createFragment(position: Int) = createFragment(position)
  }

fun FragmentStateAdapter(fragmentActivity: FragmentActivity, itemCount: Int, createFragment: (Int) -> Fragment) =
  object : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = itemCount
    override fun createFragment(position: Int) = createFragment(position)
  }

fun FragmentStateAdapter(fragment: Fragment, itemCount: Int, createFragment: (Int) -> Fragment) =
  object : FragmentStateAdapter(fragment) {
    override fun getItemCount() = itemCount
    override fun createFragment(position: Int) = createFragment(position)
  }

fun FragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, fragmentList: List<Fragment>) =
  object : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]
  }