package com.example.sqlitedatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context): SQLiteOpenHelper(context, "myDataBase", null, 1) {

    companion object{
        const val TableName = "student"
        const val name = "name"
        const val age = "age"
        const val adress= "adress"
        const val id = "id"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TableName($name text, $age integer,$adress text, $id integer primary key autoincrement)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if exists $TableName")
        onCreate(db)
    }

}