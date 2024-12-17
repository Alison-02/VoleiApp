package com.example.appvoleitimes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.viewModels
import com.example.appvoleitimes.ui.theme.AppVoleiTimesTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SortTeamsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppVoleiTimesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: SortTeamsViewModel) {
    Column(modifier = modifier.padding(16.dp)) {
        // Botão de Adicionar Jogador
        Button(
            onClick = { /* Adicionar jogador */ },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Adicionar Jogador")
        }

        // Lista de jogadores (exemplo)
        // Aqui você pode adicionar a implementação para a ListView de jogadores.

        Spacer(modifier = Modifier.height(16.dp))

        // Botões para "Salvar" e "Carregar"
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // Botão Salvar
            Button(
                onClick = { viewModel.savePlayers(LocalContext.current) },
                modifier = Modifier.weight(1f)
            ) {
                Text("Salvar Jogadores")
            }

            // Botão Carregar
            Button(
                onClick = { viewModel.loadPlayers(LocalContext.current) },
                modifier = Modifier.weight(1f)
            ) {
                Text("Carregar Jogadores")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppVoleiTimesTheme {
        MainScreen(viewModel = SortTeamsViewModel())
    }
}
