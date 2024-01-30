@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalComposeUiApi::class)

package com.example.material3app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material3app.ui.theme.Material3AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Checkboxes()
                }
            }
        }
    }
}

@Composable
fun Checkboxes() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }
}


@Composable
fun TextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var filledText by remember {
            mutableStateOf("")
        }
        val keyboardController =
            LocalSoftwareKeyboardController.current
        OutlinedTextField(
            value = filledText,
            onValueChange = {
                if(it.length <= 3) filledText = it
            },
            enabled = true,
            readOnly = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right,
            ),
            label = {
                Text(text = "Enter your weight")
            },
            placeholder = {
                Text(text = "Weight")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.MonitorWeight,
                    contentDescription = "Weight"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Person"
                )
            },
            prefix = {
                Text(text = "$")
            },
            suffix = {
                Text(text = "Kg")
            },
            supportingText = {
                Text(
                    text = "${filledText.length} / 3",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    println("Close the keyboard!")
                    keyboardController?.hide()
                }
            ),
            singleLine = true,
//            isError = false,
//            visualTransformation = PasswordVisualTransformation(),
        )
    }
}

@Composable
fun Buttons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Confirm")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add to card",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Add to cart")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Open in browser")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Back")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn more")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Material3AppTheme {
        Checkboxes()
    }
}