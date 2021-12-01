package com.nareshgediya.kotlinmvvmnasic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Quote::class], version = 2)
abstract class QuoteDatabse : RoomDatabase() {


    abstract fun quoteDao() :QuoteDao
    companion object{
        @Volatile
        private var INSTANCE : QuoteDatabse? = null



        fun getDatabase (context: Context) : QuoteDatabse{
            synchronized(this){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabse::class.java, "QuoteDB"
                    )
                        .createFromAsset("quotes.db")  //prepopulating database
                        .build()
                }
                }
            return INSTANCE!!
            }

        }

    }

