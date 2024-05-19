package com.tutormatch

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutormatch.ui.theme.TutorMatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorMatchTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {
    var shouldShowHello by rememberSaveable { mutableStateOf(true) }

    if (shouldShowHello) {
        HelloScreen(onContinueClicked = { shouldShowHello = false })
    } else {
        ListOfCards() //Or Home
    }
}

@Composable
private fun HelloScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to TutorMatch!")
            Button(
                onClick = onContinueClicked, modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Text(stringResource(id = R.string.enterApp))

            }
        }
    }
}

@Composable
fun ListOfCards(names: List<String> = List(10) { "$it" }) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.padding(vertical = 28.dp)
        ) {
            LazyColumn {
                item { Text(text = "Header") }
                items(names) { name ->
                    CardContent(name)
                }
            }
        }
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " + "padding theme elit, sed do bouncy. ").repeat(
                        4
                    ),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(value = "", onValueChange = {}, leadingIcon = {
        Icon(
            Icons.Default.Search, contentDescription = null
        )
    }, placeholder = {
        Text(stringResource(id = androidx.compose.material3.R.string.search_bar_search))
    }, modifier = modifier
        .heightIn(min = 56.dp)
        .fillMaxWidth()
    )
}

@Composable
fun AttributeElement(
    @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun AttributeRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(userAttributeData) { item ->
            AttributeElement(
                item.first, item.second
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AttributeRowPreview() {
    TutorMatchTheme { AttributeRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AttributeElementPreview() {
    TutorMatchTheme {
        AttributeElement(
            text = R.string.attribute_8,
            drawable = R.drawable.certificates,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320)
@Composable()
fun SearchBarPreview() {
    TutorMatchTheme {
        SearchBar(Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable()
fun HelloScreenPreview() {
    TutorMatchTheme {
        HelloScreen(onContinueClicked = {})
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    TutorMatchTheme {
        MyApp()
    }
}

private val userAttributeData = listOf(
    R.drawable.interests to R.string.attribute_1,
    R.drawable.objectives to R.string.attribute_2,
    R.drawable.qualifications to R.string.attribute_3,
    R.drawable.resources to R.string.attribute_4,
    R.drawable.reviews to R.string.attribute_5,
    R.drawable.skills to R.string.attribute_6,
    R.drawable.workexperience to R.string.attribute_7,
    R.drawable.certificates to R.string.attribute_8
).map { Pair(it.first, it.second) }