package com.example.superheroes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource

@Composable
fun HeroesItem() {

}

/**
 * Composable that displays a SuperHero's name and info
 *
 * @param heroName is the resource ID for the string of the superhero name
 * @param heroInfo is the Int that represents the superhero's infomation
 * @param modifier modifiers to set to this composable
 */
@Composable
fun HeroesInformation(
    heroName: Int,
    heroInfo: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
        )
        Text(
            text = stringResource(heroInfo)
        )
    }
}