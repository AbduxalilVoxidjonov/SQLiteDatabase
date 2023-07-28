package com.example.sqlitedatabase

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabaseLockedException

class MyDbManager(private val context: Context) {
    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var sqliteData: SQLiteDatabase

    fun onCreate(){
        sqLiteHelper = SQLiteHelper(context)
        sqliteData=sqLiteHelper.writableDatabase
    }

    fun inserts(name:String,age:Int,adress:String){
        val content = ContentValues()
        content.put(SQLiteHelper.name,name)
        content.put(SQLiteHelper.age,age)
        content.put(SQLiteHelper.adress,adress)
        sqliteData.insert(SQLiteHelper.TableName,null,content)
    }
    @SuppressLint("Recycle")
    fun fetch():Cursor?{
        val cursor = sqliteData.query(SQLiteHelper.TableName, arrayOf(SQLiteHelper.name,SQLiteHelper.age,SQLiteHelper.adress,SQLiteHelper.id),null,null,null,null,null)
        return if (cursor.moveToFirst()){
            cursor
        }   else
            null
    }

    fun update(id:Int,name:String,age:Int,adress:String):Int{
        val content = ContentValues()
        content.put(SQLiteHelper.name,name)
        content.put(SQLiteHelper.age,age)
        content.put(SQLiteHelper.adress,adress)

      return  sqliteData.update(SQLiteHelper.TableName,content,"${SQLiteHelper.id} = $id", null)
    }

    fun delete(id:Int):Int{
        return sqliteData.delete(SQLiteHelper.TableName,"${SQLiteHelper.id} = $id",null)
    }
}