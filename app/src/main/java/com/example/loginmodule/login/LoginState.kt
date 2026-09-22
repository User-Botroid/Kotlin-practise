package com.example.loginmodule.login

data class LoginUiState (

    val email: String = "",
    val password: String = "",
    val isPasswordVisible:Boolean = false,
    val isLoading:Boolean = false,
    val emailError: String?  = null,
    val passwordError: String? = null



)
