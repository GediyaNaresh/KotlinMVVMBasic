package com.nareshgediya.kotlinmvvmnasic

import androidx.lifecycle.LiveData

class QuoteRepository(val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote) {
        quoteDao.insertQuote(quote)
    }
}