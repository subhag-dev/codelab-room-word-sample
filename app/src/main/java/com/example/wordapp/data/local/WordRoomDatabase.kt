package com.example.wordapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wordapp.data.local.dao.WordDao

abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context,
                    WordRoomDatabase::class.java,
                    "word_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }

    }

}