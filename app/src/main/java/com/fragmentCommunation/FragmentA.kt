package com.fragmentCommunation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fragmentCommunation.databinding.FragmentABinding

class FragmentA : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentABinding
    private var fragmentAListener: FragmentAListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.btSubmit.setOnClickListener(this)
        return binding.root
    }

    interface FragmentAListener {
        fun onInputASent(input: CharSequence)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btSubmit.id -> {
                fragmentAListener?.onInputASent(binding.etData.text.toString())
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentAListener = context as FragmentAListener
    }

    fun updateText(data: CharSequence) {
        binding.etData.setText(data)
    }

    override fun onDetach() {
        super.onDetach()
        fragmentAListener = null
    }
}