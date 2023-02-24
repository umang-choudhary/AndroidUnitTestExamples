package com.cheezycode.unittestingexample.mock

import com.cheezycode.unittestingexample.mock.LOGIN_STATUS.*

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when(status){
            INVALID_USER -> "User does not exist"
            INVALID_PASSWORD -> "Password is invalid"
            UNKNOWN_ERROR -> "Unknown error occurred"
            SUCCESS -> "Logged in successfully"
        }
    }
}