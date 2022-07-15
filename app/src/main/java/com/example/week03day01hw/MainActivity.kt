package com.example.week03day01hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private var editTextSearch:EditText? = null
    private var listViewItems:ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        prepareListView()
    }

    // this function connect the Views in the xml file into variables to manipulate the values
    private fun connectViews() {
        editTextSearch = findViewById(R.id.et_search_activity_main)
        listViewItems = findViewById(R.id.lv_items_activity_main)
    }

    // this function prepare the listView to show to the user in the screen
    private fun prepareListView() {

        // the array will hold the items which will appear in the list view
        val arrayItems:ArrayList<String> = ArrayList()
        arrayItems.add("Orange")
        arrayItems.add("Berry")
        arrayItems.add("Apple")
        arrayItems.add("Banana")
        arrayItems.add("Pineapple")
        arrayItems.add("Carrot")
        arrayItems.add("Cucumber")
        arrayItems.add("Tomato")
        arrayItems.add("Onion")
        arrayItems.add("Garlic")
        arrayItems.add("Watermelon")
        arrayItems.add("Grape")
        arrayItems.add("Peach")

        // the adapter which will make the listView appear in the screen with data array - and using built in layout from kotlin
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayItems)

        listViewItems?.adapter = arrayAdapter

        // this function listen the item selected in the array and get the position to make the message for the user
        listViewItems?.setOnItemClickListener { adapterView, view, i, l ->

            // make toast message to the user showing what item has selected
            Toast.makeText(this, "${arrayItems.get(i)} Item selected", Toast.LENGTH_SHORT).show()

            // remove item selected
            arrayItems.removeAt(i)

            // update the listView
            arrayAdapter.notifyDataSetChanged()
        }

        // tis function filtering what item match the text in editText
        editTextSearch?.addTextChangedListener {
            arrayAdapter.filter.filter(it)
        }
    }

}