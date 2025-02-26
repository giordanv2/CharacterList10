package com.example.characterlist10.characterList.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.characterList.presentation.components.CharacterListItem
import com.example.characterlist10.ui.theme.CharacterList10Theme

@Composable
fun CharacterListScreen(
    characterListState: CharacterListState,
    onEvent: (CharacterListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.background(Color.Blue)
    ) {
        items(characterListState.characterList) {
            CharacterListItem(
                character = it,
                checkedIcon = { Icon(Icons.Filled.Favorite, null) },
                uncheckedIcon = { Icon(Icons.Outlined.FavoriteBorder, null) },
                isFavorite = it.id in characterListState.favoriteCharacterIds,
                onFavoriteToggle = { character, isFavorite ->
                    onEvent(CharacterListEvent.ToggleFavorite(
                        character = character,
                        isFavorite = isFavorite
                    ))
                }
            )
        }
    }
}

@PreviewLightDark
@Composable
fun CharacterListScreenPreview() {
    CharacterList10Theme { 
        CharacterListScreen(
            characterListState = CharacterListState(characterList = characterList),
            onEvent = { _, -> }
        )
    }
}

internal val characterList = List(20) {
    Character(
        id = "$it",
        name = "Name Rick Morty $it",
        status = "Status $it",
        image = "image"
    )
}