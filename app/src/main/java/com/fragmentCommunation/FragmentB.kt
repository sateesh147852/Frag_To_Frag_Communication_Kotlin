package com.fragmentCommunation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fragmentCommunation.databinding.FragmentBBinding

class FragmentB : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentBBinding
    private  var fragmentBListener : FragmentBListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        binding.btSubmit.setOnClickListener(this)
        return binding.root
    }

    interface FragmentBListener {
        fun onInputBSent(input: CharSequence)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btSubmit.id -> {
                fragmentBListener?.onInputBSent(binding.etData.text.toString())
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentBListener = context as FragmentBListener
    }

     fun updateText(data: CharSequence){
        binding.etData.setText(data)
    }

    override fun onDetach() {
        super.onDetach()
        fragmentBListener = null
    }
}