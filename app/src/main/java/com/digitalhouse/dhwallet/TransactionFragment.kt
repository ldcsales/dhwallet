package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.adapter.SpentsAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType
import com.digitalhouse.dhwallet.model.Spents
import com.digitalhouse.dhwallet.model.SpentsType

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_ENTRADA = "arg_entrada"
private const val ARG_SAIDA = "arg_saida"

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionFragment : Fragment(R.layout.fragment_transaction) {
    // TODO: Rename and change types of parameters
    private var entrada: String? = null
    private var saida: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            entrada = it.getString(ARG_ENTRADA)
            saida = it.getString(ARG_SAIDA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entradaView = view.findViewById<TextView>(R.id.entrada)
        entrada?.let{
            entradaView.text = it
        }
        val saidaView = view.findViewById<TextView>(R.id.saida)
        saida?.let{
            saidaView.text = it
        }

        val listSpents = MutableList(3){
            Spents(
                image = "https://cdn3.iconfinder.com/data/icons/picons-social/57/42-dribbble-512.png",
                name = "Dribble Inc.",
                type = SpentsType.PAGAMENTO,
                money = "+R$ 45",

            )
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_transaction)
        recycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = SpentsAdapter(listSpents)
    }

    companion object {
        @JvmStatic


        fun newInstance(paramEntrada: String, paramSaida: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENTRADA, paramEntrada)
                    putString(ARG_SAIDA, paramSaida)
                }
            }
    }
}