/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.app_final.presentation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.app_final.R
import com.example.app_final.presentation.theme.App_finalTheme
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }

    private fun WearApp() {
        TODO("Not yet implemented")
    }

}

object NavRoute{
    const val SCREEN_1 = "screen1"
    const val SCREEN_2 = "screen2"
    const val SCREEN_3 = "screen3"
    const val SCREEN_4 = "screen4"
    const val SCREEN_5 = "screen5"
    const val SCREEN_6 = "screen6"
    const val SCREEN_7 = "screen7"
    const val SCREEN_8 = "screen8"
}

@Composable
fun WearApp(sharedPreferences: SharedPreferences) {
    val navController = rememberSwipeDismissableNavController()
    ScalingLazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item{
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = NavRoute.SCREEN_1
            ){
                composable(NavRoute.SCREEN_1){
                    Screen1(navController)
                }
                composable(NavRoute.SCREEN_2){
                    Screen2(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_3){
                    Screen3(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_4){
                    Screen4(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_5){
                    Screen5(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_6){
                    Screen6(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_7){
                    Screen7(navController, sharedPreferences)
                }
                composable(NavRoute.SCREEN_8){
                    Screen8(navController, sharedPreferences)
                }

            }
        }
    }
}

@Composable
fun Screen1(
    navigation: NavController,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            text = ("Ejercicios")
        )
        Spacer(modifier = Modifier.height(30.dp))
        Chip(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            onClick = {navigation.navigate("screen2")},
            enabled = true,
            label = {
                Text(
                    text = "Correr",
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_run),
                    contentDescription = "Run",
                    modifier = iconModifier
                    )
            }
        )
        Chip(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            onClick = {navigation.navigate("screen6")},
            enabled = true,
            label = {
                Text(
                    text = "Sentadillas",
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sprint),
                    contentDescription = "Run",
                    modifier = iconModifier
                )
            }
        )
        Chip(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            onClick = {navigation.navigate("screen6")},
            enabled = true,
            label = {
                Text(
                    text = "Abdominales",
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_abdominal),
                    contentDescription = "Run",
                    modifier = iconModifier
                )
            }
        )
    }
}

@Composable
fun Screen2(navigator: NavController, sharedPreferences: SharedPreferences){
    val items = listOf("40","60","80","100","120","140","160","180","200","210","220","230")
    val state = rememberPickerState(items.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = "BPM: ${items[state.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state,
        ){
            Text(items[it], modifier = Modifier.padding(10.dp))
        }
    }
    val items2 = listOf("bpm")
    val state2 = rememberPickerState(items2.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            text = "Selected: ${items2[state2.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state2,
        ){
            Text(items2[it], modifier = Modifier.padding(10.dp))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        var position = state.selectedOption
        var value = items[position]
        Button(
            onClick = {
                navigator.navigate("screen3"){
                    launchSingleTop = true
                    popUpTo("screen2"){ inclusive = true}
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.Red
            )
        ) {
            Icon(imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Screen3(navigator: NavController, sharedPreferences: SharedPreferences){
    val items = listOf("1","2","3","4","5","10","15","20","25","30","35","40",
        "45","50","55","60","65","70","75","80","85","90","95","100")
    val state = rememberPickerState(items.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = "KM: ${items[state.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state,
        ){
            Text(items[it], modifier = Modifier.padding(10.dp))
        }
    }
    val items2 = listOf("km")
    val state2 = rememberPickerState(items2.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            text = "Selected: ${items2[state2.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state2,
        ){
            Text(items2[it], modifier = Modifier.padding(10.dp))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        var position = state.selectedOption
        var value = items[position]
        Button(
            onClick = {
                navigator.navigate("screen4"){
                    launchSingleTop = true
                    popUpTo("screen2"){ inclusive = true}
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.Red
            )
        ) {
            Icon(imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Screen4(navigator: NavController, sharedPreferences: SharedPreferences){
    val items = listOf("1","2","3","4","5","10","15","20","25","30","35","40",
        "45","50","55","60","65","70","75","80","85","90","95","100")
    val state = rememberPickerState(items.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = "Pasos: ${items[state.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state,
        ){
            Text(items[it], modifier = Modifier.padding(10.dp))
        }
    }
    val items2 = listOf("pasos")
    val state2 = rememberPickerState(items2.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            text = "Selected: ${items2[state2.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state2,
        ){
            Text(items2[it], modifier = Modifier.padding(10.dp))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        var position = state.selectedOption
        var value = items[position]
        Button(
            onClick = {
                navigator.navigate("screen5"){
                    launchSingleTop = true
                    popUpTo("screen2"){ inclusive = true}
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.Red
            )
        ) {
            Icon(imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Screen5(navigator: NavController, sharedPreferences: SharedPreferences){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text("Calorias quemadas: 356", textAlign = TextAlign.Center)
        Button(onClick={
            navigator.navigate("screen1")
        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )
        ){
            Text("Guardar")
        }
    }
}

@Composable
fun Screen6(navigator: NavController, sharedPreferences: SharedPreferences){
    val items = listOf("1","2","3","4","5","10","15","20","25","30","35","40",
        "45","50","55","60","65","70","75","80","85","90","95","100")
    val state = rememberPickerState(items.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = "Repeticioness: ${items[state.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state,
        ){
            Text(items[it], modifier = Modifier.padding(10.dp))
        }
    }
    val items2 = listOf("reps")
    val state2 = rememberPickerState(items2.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            text = ": ${items2[state2.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state2,
        ){
            Text(items2[it], modifier = Modifier.padding(10.dp))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        var position = state.selectedOption
        var value = items[position]
        Button(
            onClick = {
                navigator.navigate("screen7"){
                    launchSingleTop = true
                    popUpTo("screen2"){ inclusive = true}
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.Red
            )
        ) {
            Icon(imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Screen7(navigator: NavController, sharedPreferences: SharedPreferences){
    val items = listOf("40","60","80","100","120","140","160","180","200","210","220","230")
    val state = rememberPickerState(items.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = "BPM: ${items[state.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state,
        ){
            Text(items[it], modifier = Modifier.padding(10.dp))
        }
    }
    val items2 = listOf("bpm")
    val state2 = rememberPickerState(items2.size)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            text = "Selected: ${items2[state2.selectedOption]}"
        )
        Picker(
            modifier = Modifier.size(100.dp, 100.dp),
            state = state2,
        ){
            Text(items2[it], modifier = Modifier.padding(10.dp))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        var position = state.selectedOption
        var value = items[position]
        Button(
            onClick = {
                navigator.navigate("screen8"){
                    launchSingleTop = true
                    popUpTo("screen2"){ inclusive = true}
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.Red
            )
        ) {
            Icon(imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Screen8(navigator: NavController, sharedPreferences: SharedPreferences){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text("Calorias quemadas: 235", textAlign = TextAlign.Center)
        Button(onClick={
            navigator.navigate("screen1")
        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red
            )
        ){
            Text("Guardar")
        }
    }
}

