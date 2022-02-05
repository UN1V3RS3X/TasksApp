package com.example.tasksapp.views.data

import android.content.Context
import android.util.Log
import com.example.tasksapp.db.DatabaseHelper
import com.example.tasksapp.views.data.model.LoggedInUser
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource{

    private lateinit var databaseHelper: DatabaseHelper

    fun login(username: String, password: String, context: Context): Result<LoggedInUser> {
        try {

            Log.d("yamid", "user: $username password: $password")

            //validacion de la db


            //
            if(username == "yamid" && password == "123456"){
                val user = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
                return Result.Success(user)
            }else{
                return Result.Error(Exception())
            }

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}