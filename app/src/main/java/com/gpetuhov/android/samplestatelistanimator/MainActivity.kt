package com.gpetuhov.android.samplestatelistanimator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gpetuhov.android.samplestatelistanimator.recycler.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val myAdapter = ListAdapter(this)
        recyclerView.adapter = myAdapter

        // Init list
        val myList = MutableList(100) { "This is item number $it" }
        myAdapter.setList(myList)

        // If we can scroll the list up, then set header is selected,
        // otherwise set header not selected
        // (animation is implemented by StateListAnimator).
        recyclerView.setOnScrollChangeListener { _, _, _, _, _ ->
            header.isSelected = recyclerView.canScrollVertically(-1)
        }
    }
}
