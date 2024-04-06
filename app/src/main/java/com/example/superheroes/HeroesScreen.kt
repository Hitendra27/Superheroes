package com.example.superheroes

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import com.example.superheroes.model.HeroesRepository

/**
 * Composable that displays an an bar and a list of superheroes.
 */
//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun HeroesList(
//    heroes: List<Hero>,
//    modifier: Modifier = Modifier,
//    contentPadding: PaddingValues = PaddingValues(0.dp),
//) {
//    val visibleState = remember {
//        MutableTransitionState(false).apply {
//            // Start the animation immediately.
//            targetState = true
//        }
//    }
//
//    // Fade in entry animation for the entire list
//    AnimatedVisibility(
//        visibleState = visibleState,
//        enter = fadeIn(
//            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
//        ),
//        exit = fadeOut(),
//        modifier = modifier
//    ) {
//        LazyColumn(contentPadding = contentPadding) {
//            itemsIndexed(heroes) { index, hero ->
//                HeroesItem(
//                    hero = hero,
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp, vertical = 8.dp)
//                        // Animate each list item to slide in vertically
//                        .animateEnterExit(
//                            enter = slideInVertically(
//                                animationSpec = spring(
//                                    stiffness = StiffnessVeryLow,
//                                    dampingRatio = DampingRatioLowBouncy
//                                ),
//                                initialOffsetY = { it * (index + 1) } // staggered entrance
//                            )
//                        )
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun HeroesItem(
//    hero: Hero,
//    modifier: Modifier = Modifier
//) {
//    Card (
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        modifier = modifier
//    ){
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .sizeIn(minHeight = 72.dp)
//
//        ) {
//            HeroesInformation(
//                heroName = hero.nameRes,
//                heroInfo = hero.descriptionRes
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Box(
//                modifier = Modifier
//                    .size(72.dp)
//                    .clip(RoundedCornerShape(8.dp))
//            ) {
//                //HeroIcon(heroIcon = hero.imageRes)
//                Image(
//                    painter = painterResource(hero.imageRes),
//                    contentDescription = null,
//                    alignment = Alignment.TopCenter,
//                    contentScale = ContentScale.FillWidth
//                )
//            }
//        }
//    }
//
//}
//
///**
// * Composable that displays a photo of a Superhero
// *
// *@param heroIcon is the resource ID for the image of the superher
// * @param modifier modifiers to set to this composable
// */
//@Composable
//fun HeroIcon(
//   @DrawableRes heroIcon: Int,
//   modifier: Modifier = Modifier
//) {
//    Image(
//        painter = painterResource(heroIcon) ,
//        contentDescription = null,
//        alignment = Alignment.TopCenter,
//        contentScale = ContentScale.FillWidth,
//        modifier = modifier
//            .size(72.dp)
//            .padding(start = 16.dp)
//    )
//}
//
///**
// * Composable that displays a SuperHero's name and info
// *
// * @param heroName is the resource ID for the string of the superhero name
// * @param heroInfo is the Int that represents the superhero's infomation
// * @param modifier modifiers to set to this composable
// */
//@Composable
//fun HeroesInformation(
//    heroName: Int,
//    heroInfo: Int,
//    modifier: Modifier = Modifier
//) {
//    Column(modifier = modifier) {
//        Text(
//            text = stringResource(heroName),
//            style = MaterialTheme.typography.displaySmall
//        )
//        Text(
//            text = stringResource(heroInfo),
//            style = MaterialTheme.typography.bodyLarge
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HeroAppPreview() {
//    SuperheroesTheme {
//        HeroesList(heroes = heroes)
//    }
//}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    // Fade in entry animation for the entire list
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn(contentPadding = contentPadding) {
            itemsIndexed(heroes) { index, hero ->
                HeroListItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        // Animate each list item to slide in vertically
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,
                                    dampingRatio = DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (index + 1) } // staggered entrance
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperheroesTheme {
        HeroListItem(hero = hero)
    }
}

@Preview("Heroes List")
@Composable
fun HeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            /* Important: It is not a good practice to access data source directly from the UI.
            In later units you will learn how to use ViewModel in such scenarios that takes the
            data source as a dependency and exposes heroes.
            */
            HeroesList(heroes = HeroesRepository.heroes)
        }
    }
}