package com.example.loginmodule.signUp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.onVisibilityChangedNode

@Composable
fun SignUpScreen(
    onSignUpSuccess: ()-> Unit,
    onNavigateBack: () -> Unit
){
    var uiState by remember { mutableStateOf(SignUpUiState()) }


    SignUpContent(
        state = uiState,
        onNameChange = {uiState = uiState.copy(name = it, nameError = null)},
        onEmailChange = {uiState = uiState.copy(email = it, emailError = null)},
        onPasswordChange = {uiState = uiState.copy(password = it, passwordError = null)},
        onPasswordConfirmChange = {uiState = uiState.copy(confirmPassword = it, confirmPasswordError = null)},
        onPasswordVisibilityChange = {uiState = uiState.copy(isPasswordVisible = !uiState.isPasswordVisible)},
        onSignUpClick = {
            uiState = validateSignUp(uiState)
            if (uiState.nameError == null && uiState.emailError == null &&
                        uiState.passwordError == null && uiState.confirmPasswordError == null){
                onSignUpSuccess()
            }
        },
        onBackClick = onNavigateBack

    )


}
fun validateSignUp(state: SignUpUiState): SignUpUiState{

    val nameError = if (state.name.isBlank())  "Name is required" else null
    val emailError = when{
        state.email.isBlank() -> "Email is required"
        !state.email.contains("@") -> "Enter a valid email"
        else -> null

    }
    val passwordError = when{
        state.password.isBlank() -> "Password is required"
        state.password.length < 6 -> "Password must be at least 6 characters"
        else -> null
    }

    val confirmPasswordError = when{
        state.confirmPassword.isBlank() -> "Please confirm your password"
        state.confirmPassword != state.password -> "Passwords do not match"
        else -> null
    }

    return state.copy(
        nameError = nameError,
        emailError = emailError,
        passwordError = passwordError,
        confirmPasswordError = confirmPasswordError
    )

}