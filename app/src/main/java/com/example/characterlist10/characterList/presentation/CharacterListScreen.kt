package com.example.characterlist10.characterList.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.characterList.presentation.components.CharacterListItem
import com.example.characterlist10.ui.theme.CharacterList10Theme

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    characterList: List<Character>
) {
    LazyColumn { 
        items(characterList) {
            CharacterListItem(
                character = it,
                isChecked = false, //change flag
                checkedIcon = { Icon(Icons.Filled.Favorite,null) },
                uncheckedIcon = { Icon(Icons.Outlined.FavoriteBorder,null) }
            )
        }
    }
}

@PreviewLightDark
@Composable
fun CharacterListScreenPreview() {
    CharacterList10Theme { 
        CharacterListScreen(
            characterList = characterList
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