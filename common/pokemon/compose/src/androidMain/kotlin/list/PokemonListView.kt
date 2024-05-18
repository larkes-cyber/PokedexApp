package list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import list.models.PokemonListEvent
import list.models.PokemonListViewState

@Composable
fun PokemonListView(
    viewState: PokemonListViewState,
    onEvent:(PokemonListEvent) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            if(viewState.isLoading){
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
        itemsIndexed(viewState.list){index, item ->
            Text(text = item.name)
        }
        item {
            Text(
                text = viewState.error,
                color = Color.Red
            )
        }
    }

}