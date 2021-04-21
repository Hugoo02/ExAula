package com.example.exaula

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {

    var hours : MutableList<Hour> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.Button_plus).setOnClickListener {
            val hour = Hour.addHour(Hour.newDate())

            hours.add(hour)
        }

        val listViewHours = findViewById<ListView>(R.id.listViewHours)
        val hoursAdapter = HoursAdapter()
        listViewHours.adapter = hoursAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    inner class HoursAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return hours.size
        }

        override fun getItem(position: Int): Any {
            return hours[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowView = layoutInflater.inflate(R.layout.row_hours, parent, false)

            val textViewHour = rowView.findViewById<TextView>(R.id.textViewHour)

            textViewHour.text = hours[position].hours

                //val intent = Intent(this@MainActivity, Hour::class.java)
                //intent.putExtra( PostDetailActivity.EXTRA_ARTICLE , posts[position].toJson().toString() )
                //startActivity(intent)

                /*
                val intent = Intent(this@MainActivity, WebViewArticle::class.java)
                intent.putExtra( WebViewArticle.EXTRA_ARTICLE , posts[position].toJson().toString() )
                startActivity(intent)
                */

            return rowView
        }

    }

}



