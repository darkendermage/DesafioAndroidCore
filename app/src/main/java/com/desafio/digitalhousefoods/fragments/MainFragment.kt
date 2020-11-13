package com.desafio.digitalhousefoods.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.Restaurante.Restaurante
import com.desafio.digitalhousefoods.Restaurante.RestauranteAdapter
import java.util.ArrayList
import com.desafio.digitalhousefoods.R


class MainFragment : Fragment(), RestauranteAdapter.OnClickRestauranteListener {
    private val listaRestaurantes = getRestaurantes(4)
    private val adapter: RestauranteAdapter = RestauranteAdapter(listaRestaurantes, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.rvRestaurantes)
        recycler.adapter = adapter
        recycler.setHasFixedSize(true)

        return view
    }

    companion object{
        fun newInstance() = MainFragment()
    }


    fun getRestaurantes(size: Int): ArrayList<Restaurante> {
        val lista = ArrayList<Restaurante>()

        for (i in 0..size){
            when(i%4){
                0 -> lista.add(Restaurante("Tony Roma's", "Avenida Lavandisca, 717 - Indianópolis, São Paulo", "Fecha ás 22:00",R.drawable.image1))
                1 -> lista.add(Restaurante("Aoyama - Moema", "Alameda Dos Arapanés, 532 - Moema", "Fecha ás 00:00",R.drawable.image4,))
                2 -> lista.add(Restaurante("Outback - Moema", "Av. Moaci, 187 - Moema, São Paulo", "Fecha ás 00:00",R.drawable.image5))
                3 -> lista.add(Restaurante("Sí Senõr!", "Alameda juaperi, 626 - Moema", "Fecha ás 01:00",R.drawable.image3))
            }
        }
        return lista
    }

    override fun OnClickRestaurante(position: Int) {
        val restaurante = listaRestaurantes.get(position)
        adapter.notifyItemChanged(position)

        val bundle = bundleOf("amount" to restaurante.img, "nome" to restaurante.nome)

        findNavController().navigate(R.id.action_mainFragment_to_restauranteFragment, bundle)
    }


}