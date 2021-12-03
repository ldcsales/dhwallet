package com.digitalhouse.dhwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CRIADO FRAGMENT MANAGER

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TransactionFragment.newInstance("R$ 45,35","R$ 536"))
            .addToBackStack("trasaction_fragment")
            .commit()

        findViewById<AppCompatButton>(R.id.btn_next).setOnClickListener{
            navigateToTransfer()
        }
    }

    private fun navigateToTransfer(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TransferFragment())
            .commit()
    }
}

