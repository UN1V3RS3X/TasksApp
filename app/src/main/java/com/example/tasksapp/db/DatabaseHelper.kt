package com.example.tasksapp.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.ArrayList

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // create table sql query


    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")

    private val CREATE_USER_TASK = ("CREATE TABLE " + TABLE_USER_TASK + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY ," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")

    // drop table sql query
    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
        Log.d("yamid", "db creada")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE)
        // Create tables again
        onCreate(db)

        val values = ContentValues()
        values.put(COLUMN_USER_ID, 1)
        values.put(COLUMN_USER_NAME, "Yamid")
        values.put(COLUMN_USER_EMAIL, "yamid@gmail.com")
        values.put(COLUMN_USER_PASSWORD, "12345")
        db.insert(TABLE_USER, null, values)
    }

    private fun registerNewTask(){

    }

    private fun getUser(username: String, password: String, db: SQLiteDatabase): Boolean {

        val query = " select * " +
                "  from " + TABLE_USER +
                " where " + COLUMN_USER_EMAIL + " = '" + username + "'" +
                " AND " + COLUMN_USER_PASSWORD + " = '" + password + "'"

        db.rawQuery(query, null).use { c ->
           if (c.moveToNext()) {
             return true
            } else {
                c.close()
               return false
            }
        }


    }

    companion object {
        // Database Version
        private val DATABASE_VERSION = 1
        // Database Name
        private val DATABASE_NAME = "users.db"
        // User table name
        private val TABLE_USER = "user"
        private val TABLE_USER_TASK = "task"
        // User Table Columns names
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"
    }
}


