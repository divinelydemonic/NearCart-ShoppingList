@file:OptIn(ExperimentalMaterial3Api::class)

package kr.android.shoppinglistapp_room.view

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.android.shoppinglistapp_room.ui.theme.ThemeMode
import kr.android.shoppinglistapp_room.ui.theme.ThemeSelectorDropdown

@Composable
fun AppBarView (
    modifier: Modifier,
    title : String,
    onBackNavClicked : () -> Unit = {},
    themeMode: ThemeMode,
    onThemeChange: (ThemeMode) -> Unit,
) {

    val navigationIcon : (@Composable () -> Unit) = {
        if (!title.contains("Shopping List")){
            IconButton(
                onClick = { onBackNavClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 4.dp),
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(30.dp),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 35.sp
            )
        },
        windowInsets = WindowInsets(top = 35.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        navigationIcon = navigationIcon,
        actions = {
            ThemeSelectorDropdown(
                current = themeMode,
                onChange = onThemeChange
            )
        }
    )

}
