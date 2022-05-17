package com.example.proiect

import RecyclerAdapter
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recycler_view_page.*
import java.util.*

class RecyclerViewPage : Fragment()
{

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var myList = mutableListOf<String>()
    private var displayList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_recycler_view_page, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(itemView, savedInstanceState)

        myList.add("One")
        myList.add("Two")
        myList.add("Three")
        myList.add("Four")
        myList.add("Five")
        myList.add("Six")

        displayList.addAll(myList)

        recyclerView = requireView().findViewById(R.id.recyclerViewItem)
        recyclerAdapter = RecyclerAdapter(displayList)

        recyclerView.adapter = recyclerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {

        inflater.inflate(R.menu.menu_item, menu)

        var item: MenuItem = menu!!.findItem(R.id.search_action)

        if(item != null)
        {
            var searchView = item.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
            {
                override fun onQueryTextSubmit(query: String?): Boolean
                {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean
                {

                    if(newText!!.isNotEmpty())
                    {
                        displayList.clear()
                        var search = newText.lowercase(Locale.getDefault())

                        for(item in myList)
                        {
                            if(item.lowercase(Locale.getDefault()).contains(search))
                            {
                                displayList.add(item)
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }
                    }
                    else
                    {
                        displayList.clear()
                        displayList.addAll(myList)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }

        super.onCreateOptionsMenu(menu, inflater)

    }

}