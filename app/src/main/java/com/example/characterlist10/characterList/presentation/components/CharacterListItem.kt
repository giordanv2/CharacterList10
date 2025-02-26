package com.example.characterlist10.characterList.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.characterlist10.R
import com.example.characterlist10.characterList.domain.models.Character
import com.example.characterlist10.ui.theme.CharacterList10Theme

@Composable
fun CharacterListItem(
    character: Character,
    isFavorite: Boolean,
    onFavoriteToggle: (Character, Boolean) -> Unit,
    checkedIcon: @Composable () -> Unit,
    uncheckedIcon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(4.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        
        AsyncImage(
            model = character.image,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = character.name,
                color = contentColor
            )

            Text(
                text = character.status,
                color = contentColor
            )
        }

        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = { onFavoriteToggle(character, !isFavorite) },
            colors = IconButtonDefaults.iconToggleButtonColors(
                contentColor = contentColor,
                checkedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                checkedContentColor = contentColor
            )
        ) {
            if(isFavorite) checkedIcon() else uncheckedIcon()
        }

        Spacer(modifier = Modifier.size(0.dp))
    }
}

@PreviewLightDark
@Composable
fun CharacterListItemPreview() {
    CharacterList10Theme {
        CharacterListItem(
            character = character,
            isFavorite = true,
            checkedIcon = { Icon(Icons.Filled.Favorite, null) },
            uncheckedIcon = { Icon(Icons.Outlined.FavoriteBorder, null) },
            onFavoriteToggle = { _, _, -> },
        )
    }
}

internal val character = Character(
    id = "1",
    name = "Rick",
    status = "Alive",
    image = "image"
)