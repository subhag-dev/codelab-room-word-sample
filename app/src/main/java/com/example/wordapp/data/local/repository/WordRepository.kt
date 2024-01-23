package com.example.wordapp.data.local.repository

import androidx.annotation.WorkerThread
import com.example.wordapp.data.local.dao.WordDao
import com.example.wordapp.data.local.entity.Word
import kotlinx.coroutines.flow.Flow

class WordRepository constructor(
    private val wordDao: WordDao
) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

}