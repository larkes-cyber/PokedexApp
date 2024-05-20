package detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import detail.models.PokemonDetailEvent
import detail.models.PokemonDetailViewState

@Composable
fun PokemonDetailView(
    viewState: PokemonDetailViewState,
    onEvent:(PokemonDetailEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xfff2f2f2)).padding(top = 27.dp)
    ) {
        if(viewState.isLoading){
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if(viewState.pokemonAboutInfo != null) {
            Box {
                Text(
                    viewState.pokemonAboutInfo!!.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp).clickable {
                            onEvent(PokemonDetailEvent.BackArrowClicked)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        if(viewState.pokemonAboutInfo != null) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp)
            ) {
                item {
                    SectionBox(title = "Props", items = listOf(
                        "height: ${viewState.pokemonAboutInfo?.height}",
                        "weight: ${viewState.pokemonAboutInfo?.weight}"
                    ))
                    Spacer(modifier = Modifier.height(15.dp))
                }
                item {
                    SectionBox(title = "Types", items = viewState.pokemonAboutInfo!!.types)
                    Spacer(modifier = Modifier.height(15.dp))
                }
                item {
                    SectionBox(title = "Abilities", items = viewState.pokemonAboutInfo!!.abilities)
                    Spacer(modifier = Modifier.height(15.dp))
                }
                item {
                    SectionBox(title = "Stats", items = viewState.pokemonAboutInfo!!.stat.map { "${it.first}: ${it.second}" })
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }

}

@Composable
fun SectionBox(title:String, items: List<String>) {
    Text(
        title,
        style = MaterialTheme.typography.h6,
        color = Color.Gray.copy(alpha = 0.9f)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier.padding(top = 8.dp, bottom = 10.dp)){
            ItemsBox(items)
        }
    }
}

@Composable
fun ItemsBox(list: List<String>) {
    Column {
        list.forEach {
            Text(
                it,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            if(it != list.last()) {
                Box(modifier = Modifier.padding(vertical = 12.dp)){
                    Divider(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xfff2f2f2).copy(alpha = 0.6f)))
                }
            }
        }
    }
}