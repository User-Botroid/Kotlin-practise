package com.example.loginmodule.login

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(){
    var uiState by remember {
        mutableStateOf(LoginUiState())
    }

    LoginContent(
        state = uiState,
        onEmailChange = { newEmail ->
            uiState = uiState.copy(
                email = newEmail,
                emailError = null
            )

        },
        onPasswordChange = { newPassword ->
            uiState = uiState.copy(
                password = newPassword,
                passwordError = null
            )

        },

        onPasswordVisibilityChange  = {
            uiState = uiState.copy(
                isPasswordVisible = !uiState.isPasswordVisible
            )
        },
        onLoginClick = {

            uiState = validateLogin(uiState)

            if (uiState.emailError == null && uiState.passwordError ==null){

            }

        }



    )
}

@Preview
@Composable
fun LoginScreenPreview(){
    MaterialTheme{
        LoginScreen()
    }
}

fun validateLogin(state: LoginUiState): LoginUiState{
    val emailError = when{
        state.email.isBlank() -> "Email is required"
        !state.email.contains("@") -> "Enter a valid email"
        else -> null
    }

    val passwordError = when{
        state.password.isBlank() -> "Password is required"
        state.password.length < 6 -> "Password must contain at least 6 characters"
        else -> null
    }

    return state.copy(
        emailError = emailError,
        passwordError = passwordError
    )

}