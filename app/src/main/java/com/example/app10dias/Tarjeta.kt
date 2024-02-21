import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app10dias.Expandir.ExpandLess
import com.example.app10dias.Expandir.ExpandMore
import com.example.app10dias.R
import com.example.app10dias.model.Libro
import com.example.app10dias.model.RepositorioLibros.Companion.libros
import com.example.app10dias.ui.theme.Libreria
import com.example.app10dias.ui.theme.Shapes

@Composable
fun TarjetaLibro(
    libro: Libro,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var imageExpanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.Very_Small)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(libro.titulo),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(libro.autor),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(Shapes.medium)
                        .size(
                            if (imageExpanded) dimensionResource(R.dimen.Ultra_Big) else dimensionResource(
                                R.dimen.Very_Big
                            )
                        )
                        .clickable {
                            expanded = !expanded
                            imageExpanded = expanded 
                        }
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(libro.imageRes),
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {
                        expanded = !expanded
                        imageExpanded = expanded 
                    },
                    modifier = Modifier.size(dimensionResource(R.dimen.Very_Big))
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = stringResource(R.string.app_name),
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            if (expanded) {
                Text(
                    text = stringResource(libro.descripcion),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}



    @Composable
    fun ListaLibros(
        libros: List<Libro>,
        modifier: Modifier = Modifier,
        contentPadding: PaddingValues = PaddingValues()
    ) {
        LazyColumn(contentPadding = contentPadding) {
            itemsIndexed(libros) { index, libro ->
                TarjetaLibro(
                    libro = libro,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_medium),
                            vertical = dimensionResource(R.dimen.padding_small)
                        )
                )
            }
        }
    }

@Composable
private fun BotonExpandir(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ){
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.autor10),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun TarjetaLibroPreview() {
    Libreria(darkTheme = true) {
        ListaLibros(libros)
    }
}
