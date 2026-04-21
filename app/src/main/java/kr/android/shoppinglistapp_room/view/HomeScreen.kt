package kr.android.shoppinglistapp_room.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import kr.android.shoppinglistapp_room.navigation.Screens
import kr.android.shoppinglistapp_room.ui.theme.GreenPrimaryContainer
import kr.android.shoppinglistapp_room.ui.theme.GreenPrimaryContainerDark
import kr.android.shoppinglistapp_room.ui.theme.ShoppingListApp_RoomTheme
import kr.android.shoppinglistapp_room.ui.theme.ThemeMode

@Composable
fun HomeScreen(
    themeMode: ThemeMode,
    isDark : Boolean,
    onThemeChange : (ThemeMode) -> Unit,
    navController: NavHostController
) {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    ShoppingListApp_RoomTheme (darkTheme = isDark) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                AppBar(
                    title = "Shopping List",
                    themeMode = themeMode,
                    onThemeChange = onThemeChange
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(Screens.AddEditScreen.route) },
                    modifier = Modifier
                        .padding(30.dp)
                        .size(70.dp)
                        .border(
                            width = 1.dp,
                            color = GreenPrimaryContainerDark,
                            CircleShape
                        ),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ) {
                    Icon(
                        imageVector = Icons.Default.AddShoppingCart,
                        contentDescription = "add item",
                        modifier = Modifier.size(35.dp)
                    )
                }
            },
            snackbarHost = { SwipeableSnackBar(snackBarHostState) }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                item{
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Button(
                            onClick = {
                                scope.launch {
                                    snackBarHostState.showSnackbar(
                                        message = "Item has been deleted"
                                    )
                                }
                            }
                        ) {
                            Text("Snack")
                        }
                    }
                }
            }
        }
    }

}