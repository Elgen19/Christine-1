package com.pepito.demo.dialogs.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.pepito.demo.dialogs.databinding.DialogCustomBinding

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var binding: DialogCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDialog()

        binding.save.setOnClickListener {
           Toast.makeText(context, "Your new name is " + binding.nameEditText.text, Toast.LENGTH_LONG).show()
        }
    }

    private fun showDialog() {
        val window: Window? = this.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}