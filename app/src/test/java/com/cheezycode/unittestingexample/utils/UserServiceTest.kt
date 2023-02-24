package com.cheezycode.unittestingexample.utils

import com.cheezycode.unittestingexample.mock.LOGIN_STATUS
import com.cheezycode.unittestingexample.mock.UserRepository
import com.cheezycode.unittestingexample.mock.UserService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.SUCCESS)
    }

    @Test
    fun testUserService(){
        val sut = UserService(userRepository)
        val status = sut.loginUser("abc@gmail.com", "111111")
        Assert.assertEquals("Logged in successfully", status)
    }
}

















