package com.cheezycode.unittestingexample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        // Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Act
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_ValidJSON_expected_Count() {
        // Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Act
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        // Assert
        assertEquals(9, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is second quote", "2"),
                Quote("This is third quote", "3")
            )
        )
        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assert
        assertEquals("1", quote.author)

    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is second quote", "2"),
                Quote("This is third quote", "3")
            )
        )
        //Act
        val quote = quoteManager.getNextQuote()
        //Assert
        assertEquals("2", quote.author)
        assertEquals("This is second quote", quote.text)

    }


}













