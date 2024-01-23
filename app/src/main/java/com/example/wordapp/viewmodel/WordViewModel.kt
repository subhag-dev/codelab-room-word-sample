package com.example.wordapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.wordapp.data.local.entity.Word
import com.example.wordapp.data.local.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel constructor(
    private val wordRepository: WordRepository
) : ViewModel() {

    val words: LiveData<List<Word>> = wordRepository.allWords.asLiveData()

    suspend fun insertWord(word: Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }

}