package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit  var binding: ActivityMainBinding
    private val contactList = ArrayList<Contact>()
    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnAdd.setOnClickListener {
            if (binding.editTextName.text.isEmpty()) {
                binding.editTextName.error = getString(R.string.errorMessage)
                return@setOnClickListener
            }

            if (binding.editTextName.text.isEmpty()) {
                binding.editTextName.error = getString(R.string.errorMessage)
                return@setOnClickListener
            }

            val newContact =
                Contact(binding.editTextName.text.toString(), binding.editTextPhone.text.toString())
            contactList.add(newContact)


        }

        binding.btnNext.setOnClickListener() {
            if (contactList.size > 0 && index < contactList.size - 1) {
                index += 1
                showRecord(contactList.get(index))

            }

        }

        binding.btnPrevious.setOnClickListener() {
            if (contactList.size > 0 && index >= 0) {
                index -= 1
                showRecord(contactList.get(index))
            }

        }
    }

    private fun showRecord(contact:Contact){
    /*    binding.myContact = contact
        binding.invalidateAll()// refreshing the variables*/
        binding.apply{
            myContact=contact
            invalidateAll()
        }
    }
}