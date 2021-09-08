package com.example.uipractice

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.example.uipractice.databinding.FragmentHomeBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*


class homeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.btnCal.setOnClickListener {
            openTimePicker()
        }
        return binding.root
    }
    private fun openTimePicker() {
        val is24System = DateFormat.is24HourFormat(requireContext())
        val clockFormat = if(is24System) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Alarm")
            .build()
        picker.show(childFragmentManager,"TAG")

        picker.addOnPositiveButtonClickListener {
            val h = picker.hour
            val min = picker.minute
            binding.tvCal.text = "Time - $h:$min"
            Log.d("Krish","$h $min")
        }

    }
}