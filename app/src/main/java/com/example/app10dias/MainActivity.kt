package com.example.app10dias

import ListaLibros
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app10dias.Expandir.ExpandLess
import com.example.app10dias.Expandir.ExpandMore
import com.example.app10dias.model.RepositorioLibros
import com.example.app10dias.ui.theme.Libreria

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Libreria {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Libreria()
                }
            }
        }
    }
}

@Composable
fun Libreria() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BarraSuperior()
        }
    ) {
        val libros = RepositorioLibros.libros
        ListaLibros(libros = libros, contentPadding = it)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row() {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                )
                Image(
                    painter = painterResource(R.drawable.librobarrasuperior),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.BarraSuperior))
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LibreriaPreview() {
    Libreria(darkTheme = true) {
        Libreria()
    }
}
