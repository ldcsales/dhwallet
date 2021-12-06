package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType

class TransferFragment : Fragment(R.layout.fragment_transfer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profile = view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener{
            //parentFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, TransactionFragment.newInstance("R$45,35","R$536"))
                //.commit()
            val intent = Intent(it.context, MinhaActivity::class.java)
            startActivity(intent)
        }

        val listContact = MutableList(10){
            Contact(
                image = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
                name = "Cristiano",
                type = ContactType.IRMAO
            )
        }

        //CRIACAO DO RECYCLER


        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = ContactAdapter(listContact)

    }


}