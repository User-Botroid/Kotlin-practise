package com.example.loginmodule.signUp

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpContent(
    state: SignUpUiState,
    onNameChange: (String) ->Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange:(String)->Unit,
    onPasswordConfirmChange:(String)->Unit,
    onPasswordVisibilityChange:()->Unit,
    onSignUpClick:()->Unit,
    onBackClick: () -> Unit

){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("")},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ){ paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Create Account",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Sign up to get started",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = state.name,
                onValueChange = onNameChange,
                modifier = Modifier.fillMaxWidth(),
                label = {Text("Full Name")},
                singleLine = true,
                isError = state.nameError != null,
                supportingText = {
                    state.nameError?.let{Text(it)}
                }

            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                label = {Text("Email")},
                singleLine = true,
                isError = state.emailError != null,
                supportingText = {
                    state.emailError?.let{Text(it)}
                }

            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                label = {Text("password")},
                singleLine = true,
                visualTransformation = if (state.isPasswordVisible)
                    VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = onPasswordVisibilityChange) {
                        Icon(
                            imageVector = if (state.isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null
                        )
                    }
                },
                isError = state.passwordError!=null,
                supportingText = {
                    state.passwordError?.let { Text(it) }
                }

            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = state.confirmPassword,
                onValueChange = onPasswordConfirmChange,
                modifier = Modifier.fillMaxWidth(),
                label = {Text("Confirm Password")},
                singleLine = true,
                isError = state.confirmPasswordError!=null,
                supportingText = {
                    state.confirmPassword?.let { Text(it) }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onSignUpClick,
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isLoading
            ) {
                Text(text =  if (state.isLoading) "Creating account..." else "Sign Up")
            }



        }
    }

}

@Preview
@Composable
fun signInContentPreview(){
    MaterialTheme{
        SignUpContent(
            state  = SignUpUiState(),
            onNameChange = {},
        onEmailChange = {},
        onPasswordChange = {},
        onPasswordConfirmChange = {},
            onPasswordVisibilityChange = {},
        onSignUpClick = {},
            onBackClick = {}


        )
    }
}