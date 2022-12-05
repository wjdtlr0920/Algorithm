package com.js.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.FileNotFoundException
import java.io.IOException
import java.lang.reflect.Method
import java.util.concurrent.TimeUnit

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