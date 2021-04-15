package com.fragmentCommunation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fragmentCommunation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener,
    FragmentB.FragmentBListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        fragmentA = FragmentA()
        fragmentB = FragmentB()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_a, fragmentA,"frg1")
            .replace(R.id.container_b, fragmentB,"frg2")
            .commit()

    }

    override fun onInputASent(input: CharSequence) {
        val fragment =  supportFragmentManager.findFragmentByTag("frg2")
        if (fragment != null)
        fragmentB.updateText(input)
    }

    override fun onInputBSent(input: CharSequence) {
        val fragment =  supportFragmentManager.findFragmentByTag("frg1")
        if (fragment != null)
        fragmentA.updateText(input)
    }

}