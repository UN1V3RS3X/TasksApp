package com.example.tasksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapp.db.DatabaseHelper
import com.example.tasksapp.views.ui.tasks.TaskActivity
import com.example.tasksapp.views.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializar base de datos
        initializeDatabase()

        //Seleccionar vista inicial
        selectInitialView()

    }

    private fun initializeDatabase(){
        databaseHelper = DatabaseHelper(this@MainActivity)
        databaseHelper.writableDatabase
    }

    private fun selectInitialView(){

        //Setear tipo de configuracion: Tipo "Mesa" o "Puesto"
        val pref = getSharedPreferences("taskAppPreferences", MODE_PRIVATE)
        val data = pref.getBoolean("isLogged", false)
        if (data) {
            goToTask()
        }else{
            goToLogin()
        }
//        goToTask()
//        goToLogin()
    }


    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    private fun goToTask() {
        val intent = Intent(this, TaskActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

}