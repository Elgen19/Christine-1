package com.pepito.demo.dialogs

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pepito.demo.dialogs.databinding.ActivityMainBinding


import com.pepito.demo.dialogs.dialogs.CustomDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleContentDialog.setOnClickListener { nameDialog() }
        binding.timePickerDialog.setOnClickListener { selectTimeDialog() }
        binding.customDialog.setOnClickListener { customDialog() }
    }

    private fun nameDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Hello! My name is Christine.")
            .setCancelable(false) // Set this to true if you dialog can be closed via tapping outside.
            .setPositiveButton("Okay") { dialog, _ -> dialog.dismiss() }

        val alert = dialogBuilder.create()
        alert.setTitle("Welcome")
        alert.show()
    }


    private fun selectTimeDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                Toast.makeText(this, "You set the time to $selectedTime", Toast.LENGTH_SHORT).show()
            }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun customDialog() {
        val customDialog = CustomDialog(this)
        customDialog.show()
    }
}