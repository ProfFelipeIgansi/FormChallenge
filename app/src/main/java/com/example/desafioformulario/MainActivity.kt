package com.example.desafioformulario

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desafioformulario.ui.theme.DesafioFormularioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesafioFormularioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormularioDesafio(paddingValues = innerPadding)
                }
            }
        }
    }
}


@Composable
fun FormularioDesafio(paddingValues: PaddingValues) {
    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var numerodoc by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.login_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .padding(10.dp),
                    tint = Color.Gray
                )
            }

            Row {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text(text = "Nome") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                OutlinedTextField(
                    value = sobrenome,
                    onValueChange = { sobrenome = it },
                    label = { Text(text = "Sobrenome") },
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = rua,
                onValueChange = { rua = it },
                label = { Text(text = "Rua") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = estado,
                onValueChange = { estado = it },
                label = { Text(text = "Estado") },
                modifier = Modifier.fillMaxWidth()
            )

            Row {
                OutlinedTextField(
                    value = numero,
                    onValueChange = { numero = it },
                    label = { Text(text = "Numero") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                OutlinedTextField(
                    value = complemento,
                    onValueChange = { complemento = it },
                    label = { Text(text = "Complemento") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(5.dp))

                OutlinedTextField(
                    value = cep,
                    onValueChange = { cep = it },
                    label = { Text(text = "CEP") },
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = numerodoc,
                onValueChange = { numerodoc = it },
                label = { Text(text = "Numero doc (RG/CPF)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    Log.i(
                        "form informations",
                        "FormularioDesafio: \n " +
                                "nome: $nome \n " +
                                "sobrenome: $sobrenome \n " +
                                "rua: $rua \n " +
                                "estado: $estado \n " +
                                "numero: $numero \n " +
                                "complemento: $complemento \n " +
                                "cep: $cep \n " +
                                "numerodoc: $numerodoc"
                    )
                }) {
                    Text(text = "Cadastrar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesafioFormularioTheme {
        FormularioDesafio(paddingValues = PaddingValues(0.dp))
        }
}