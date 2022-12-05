package com.js.algorithm

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class BlankFragment : Fragment() {

  override fun onAttach(context: Context) {
    super.onAttach(context)
    Log.e("zzzzzz", "BlankFragment onAttach(context) $this")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.e("zzzzzz", "BlankFragment onCreate $this")
  }

  @SuppressLint("MissingInflatedId")
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    Log.e("zzzzzz", "BlankFragment onCreateView $this")

    val rootView = inflater.inflate(R.layout.fragment_blank, container, false)
    rootView.findViewById<TextView>(R.id.tvTest).apply {
      y += Random(System.currentTimeMillis()).nextInt(1, 200)
      text = "asdasdasd"
    }

    return rootView
  }



}