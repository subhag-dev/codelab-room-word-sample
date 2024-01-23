package com.example.wordapp

import android.app.Application
import com.example.wordapp.data.local.WordRoomDatabase
import com.example.wordapp.data.local.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.getWordDao()) }

}