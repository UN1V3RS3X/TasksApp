package com.example.tasksapp.views.ui.tasks

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasksapp.R
import com.example.tasksapp.views.ui.login.LoginActivity
import android.view.View






class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        setSupportActionBar(findViewById(R.id.toolbar));

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item " + i))
        }

        if(data.size == 0){
            //No hay items
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        recyclerview.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                recyclerview,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        // do whatever
                        /*Toast.makeText(
                            applicationContext,
                            "Holos  ${data[position].text}",
                            Toast.LENGTH_SHORT
                        ).show()*/
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        // DELETE TASK
                        Toast.makeText(
                            applicationContext,
                            "Holis ${data[position].text}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_task, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_logout) {

            val pref = getSharedPreferences("taskAppPreferences", MODE_PRIVATE)
            val editor = pref.edit()
            editor.putBoolean("isLogged", false)
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
            finish()
        }
        if(id == R.id.action_add_item){
            Toast.makeText(
                applicationContext,
                "Agregando Item",
                Toast.LENGTH_LONG
            ).show()
        }
        return super.onOptionsItemSelected(item)

    }
}