 package com.example.sqlitedatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlitedatabase.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val database = openOrCreateDatabase("mydb", MODE_PRIVATE, null)


//       database.execSQL("create table if not exists student(name text, age integer, id integer primary key autoincrement)")
//       database.execSQL("insert into student(name, age) values('Abu', 10)")
//       database.execSQL("insert into student(name, age) values('Umar', 400)")
//       database.execSQL("insert into student(name, age) values('Zufar', 20)")
//       database.execSQL("insert into student(name, age) values('Abbos', 15)")
//       database.execSQL("insert into student(name, age) values('Abror', 12)")


        //  database.execSQL("update student set age = 40 where name='Abduxalil'")

//        database.execSQL("delete from student where name='Abu' or age=40")
//
//        val cursor = database.rawQuery("select * from student", null)
//        cursor.moveToFirst()
//        var nams=""
//        do {
//            val name = cursor.getString(cursor.getColumnIndex("name"))
//            val age = cursor.getInt(cursor.getColumnIndex("age"))
//            val id = cursor.getInt(cursor.getColumnIndex("id"))
//            nams+="name: $name, age: $age, id: $id \n"
//        } while (cursor.moveToNext())

        val dbManager = MyDbManager(this)
        dbManager.onCreate()

//        dbManager.inserts("Abu", 10, "Tashkent")
//        dbManager.inserts("Umar", 40, "Andijon")
//        dbManager.inserts("Usmon", 20, "Tashkent")
//        dbManager.inserts("Abduxalil", 20, "Qo'qon")

        dbManager.delete(1)
        dbManager.update(2, "Umar", 40, "Andijon")

        val curson = dbManager.fetch()
        if (curson != null) {
            var st = ""
                do {
                    val name = curson.getString(curson.getColumnIndex(SQLiteHelper.name))
                    val age = curson.getInt(curson.getColumnIndex(SQLiteHelper.age))
                    val adress = curson.getString(curson.getColumnIndex(SQLiteHelper.adress))
                    st+="name: $name, age: $age, adress: $adress \n"
                } while (curson.moveToNext())
            binding.textView.text = st
        }
    }
}