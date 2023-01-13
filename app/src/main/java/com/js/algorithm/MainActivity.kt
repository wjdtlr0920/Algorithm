package com.js.algorithm

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    Log.e("zzzzzz", "MainActivity onCreate")

    val fragmentContainer = findViewById<FragmentContainerView>(R.id.containerMain)
    val blankFragment = BlankFragment()
    addFragment(fragmentContainer.id, blankFragment, bundleOf())

  }

  fun AppCompatActivity.addFragment(
    @IdRes layoutId: Int,
    fragment: Fragment,
    extras: Bundle? = null,
    isStack: Boolean = false
  ) {

    extras?.let {
      fragment.arguments = it
    }

    val fm = supportFragmentManager
    val ft = fm.beginTransaction()

    val value = fragment.toString()

    if (isStack) {
      ft.addToBackStack(value)
    }

    ft.add(layoutId, fragment, value)
    ft.commitAllowingStateLoss()
  }
}