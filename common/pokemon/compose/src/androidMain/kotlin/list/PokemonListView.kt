package list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import list.models.PokemonListEvent
import list.models.PokemonListViewState

@Composable
fun PokemonListView(
    viewState: PokemonListViewState,
    onEvent:(PokemonListEvent) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Text(
                "Pokedex",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                "Search for Pokemon by name or using the National Pokedex number.",
                color = Color.Gray.copy(alpha = 0.8f),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                value = viewState.searchText,
                onValueChange = { onEvent(PokemonListEvent.SearchEntered(it)) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Gray.copy(alpha = 0.12f),
                    textColor = Color.Gray.copy(alpha = 0.8f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                placeholder = {
                    Text(
                        text = "What pokemon are you looking for?",
                        color = Color.Gray.copy(alpha = 0.6f)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
        }

        LazyColumn(
            modifier = Modifier.background(Color.Gray.copy(alpha = 0.08f)).padding(horizontal = 15.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            itemsIndexed(viewState.list){index, item ->
                Card(
                    modifier = Modifier.fillMaxWidth().height(160.dp).clickable {
                        onEvent(PokemonListEvent.PokemonClicked(item.id))
                    }
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxHeight().padding(start = 15.dp)
                        ) {
                            Text(
                                text = "#${item.id}",
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.h5
                            )
                        }

                        SubcomposeAsyncImage(
                            model = item.imageSrc,
                            contentDescription = null,
                            modifier = Modifier.size(140.dp),
                            contentScale = ContentScale.Crop,
                            loading = {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator()
                                }
                            }
                        )

                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                if(viewState.list.isNotEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.onFocusEvent {
                                if(viewState.isLoading.not()) {
                                    onEvent(PokemonListEvent.EndScrolled)
                                }
                            }
                        )
                    }
                }

            }
        }

    }

}