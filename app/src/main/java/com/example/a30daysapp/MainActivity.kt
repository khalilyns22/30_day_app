package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.ui.theme._30DaysAppTheme


data class Day(
    val dayNumber: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)

val daysList = listOf(
    Day(
        dayNumber = 1,
        titleRes = R.string.day1_title,
        imageRes = R.drawable.hiking,
        descriptionRes = R.string.day1_desc
    ),
    Day(
        dayNumber = 2,
        titleRes = R.string.day2_title,
        imageRes = R.drawable.camping,
        descriptionRes = R.string.day2_desc
    ),
    Day(
        dayNumber = 3,
        titleRes = R.string.day3_title,
        imageRes = R.drawable.cooking_over_campire,
        descriptionRes = R.string.day3_desc
    ),
    Day(dayNumber = 4, titleRes = R.string.day4_title, imageRes = R.drawable.stream, descriptionRes = R.string.day4_desc),
    Day(dayNumber = 5, titleRes = R.string.day5_title, imageRes = R.drawable.forest_walk, descriptionRes = R.string.day5_desc),
    Day(dayNumber = 6, titleRes = R.string.day6_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day6_desc),
    Day(dayNumber = 7, titleRes = R.string.day7_title, imageRes = R.drawable.sunset, descriptionRes = R.string.day7_desc),
    Day(dayNumber = 8, titleRes = R.string.day8_title, imageRes = R.drawable.cooking_over_campire, descriptionRes = R.string.day8_desc),
    Day(dayNumber = 9, titleRes = R.string.day9_title, imageRes = R.drawable.oldest_tree, descriptionRes = R.string.day9_desc),
    Day(dayNumber = 10, titleRes = R.string.day10_title, imageRes = R.drawable.compass_navigation, descriptionRes = R.string.day10_desc),
    Day(dayNumber = 11, titleRes = R.string.day11_title, imageRes = R.drawable.hammock, descriptionRes = R.string.day11_desc),
    Day(dayNumber = 12, titleRes = R.string.day12_title, imageRes = R.drawable.marchmello, descriptionRes = R.string.day12_desc),
    Day(dayNumber = 13, titleRes = R.string.day13_title, imageRes = R.drawable.wolf, descriptionRes = R.string.day13_desc),
    Day(dayNumber = 14, titleRes = R.string.day14_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day14_desc),
    Day(dayNumber = 15, titleRes = R.string.day15_title, imageRes = R.drawable.stargaze, descriptionRes = R.string.day15_desc),
    Day(dayNumber = 16, titleRes = R.string.day16_title, imageRes = R.drawable.cooking_over_campire, descriptionRes = R.string.day16_desc),
    Day(dayNumber = 17, titleRes = R.string.day17_title, imageRes = R.drawable.ferns, descriptionRes = R.string.day17_desc),
    Day(dayNumber = 18, titleRes = R.string.day18_title, imageRes = R.drawable.barefoot, descriptionRes = R.string.day18_desc),
    Day(dayNumber = 19, titleRes = R.string.day19_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day19_desc),
    Day(dayNumber = 20, titleRes = R.string.day20_title, imageRes = R.drawable.climbing, descriptionRes = R.string.day20_desc),
    Day(dayNumber = 21, titleRes = R.string.day21_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day21_desc),
    Day(dayNumber = 22, titleRes = R.string.day22_title, imageRes = R.drawable.cave, descriptionRes = R.string.day22_desc),
    Day(dayNumber = 23, titleRes = R.string.day23_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day23_desc),
    Day(dayNumber = 24, titleRes = R.string.day24_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day24_desc),
    Day(dayNumber = 25, titleRes = R.string.day25_title, imageRes = R.drawable.campfire, descriptionRes = R.string.day25_desc),
    Day(dayNumber = 26, titleRes = R.string.day26_title, imageRes = R.drawable.walking_pace, descriptionRes = R.string.day26_desc),
    Day(dayNumber = 27, titleRes = R.string.day27_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day27_desc),
    Day(dayNumber = 28, titleRes = R.string.day28_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day28_desc),
    Day(dayNumber = 29, titleRes = R.string.day29_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day29_desc),
    Day(dayNumber = 30, titleRes = R.string.day30_title, imageRes = R.drawable.hiking, descriptionRes = R.string.day30_desc),

)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                ThirtyDaysApp()
            }
        }
    }
}


@Composable
fun ThirtyDaysApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThirtyDaysTopAppBar() }
    ) { innerPadding ->
        DaysList(
            days = daysList,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days Outdoors",
                style = MaterialTheme.typography.titleLarge
            )
        },
        modifier = modifier
    )
}


@Composable
fun DaysList(
    days: List<Day>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(days) { day ->
            DayCard(
                day = day,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

// ==========================================
// 6. DAY CARD (Photo + Click-to-Reveal Animation)
// ==========================================
@Composable
fun DayCard(
    day: Day,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // Day number and title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = "Day ${day.dayNumber}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = stringResource (day.titleRes),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // THE PHOTO: Clicking toggles the description open/closed
            Image(
                painter = painterResource(day.imageRes),
                contentDescription =stringResource (day.titleRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable { expanded = !expanded }
            )

            // THE TEXT UNDER: Appears below the photo when clicked
            if (expanded) {
                Text(
                    text = stringResource(day.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}