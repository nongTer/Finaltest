package com.example.finaltest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,1) {


    companion object{
        val DATABASE_NAME= "Student.db"
        val TABLE_NAME="student_table"
        val  Col1 ="ID"
        val  Col2 ="NAME"
        val  Col3 ="LATE_NAME"
        val  Col4 ="NICK_NAME"
        val  Col5 ="NUMBER"
    }
    override fun onCreate(db: SQLiteDatabase) {
      db.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_NAME(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME  TEXT , PROFESSION TEXT , SALARY INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
       db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun intertData(name: String,latename:String,nickname:String,student:String):Boolean?{
        val db =this.writableDatabase
        val cv =ContentValues()
        cv.put(Col2,name)
        cv.put(Col3,latename)
        cv.put(Col4,nickname)
        cv.put(Col5,student)
        val  res =db.insert(TABLE_NAME,null,cv)
        return !res.equals(-1)
    }
}