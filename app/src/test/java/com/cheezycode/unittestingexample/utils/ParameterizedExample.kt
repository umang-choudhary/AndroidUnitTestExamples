package com.cheezycode.unittestingexample.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(private val input: String, private val expectedValue: Boolean) {

    @Test
    fun testLogic() {
        // Arrange
        val helper = Helper()
        // Act
        val result = helper.isPallindrome(input)
        // Assert
        assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun dataSource(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }

}