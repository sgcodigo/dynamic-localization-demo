package me.naingaungluu.dynamiclocalization.ui.screens.home

import HomeScreenState
import HomeScreenStateProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.naingaungluu.dynamiclocalization.data.models.Localization
import me.naingaungluu.dynamiclocalization.preferences.AppLanguage
import me.naingaungluu.dynamiclocalization.ui.screens.components.CodigoButton
import me.naingaungluu.dynamiclocalization.ui.theme.DynamicLocalizationTheme

@Preview(showBackground = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenStateless(
        HomeScreenState(
            data = HomeScreenState.Data(
                localization = viewModel.localizationFlow.collectAsState(
                    initial = Localization.getDefaultLocalization()
                ),
                appLanguage = viewModel.currentLanguageFlow.collectAsState(
                    initial = AppLanguage.ENGLISH
                )
            ),
            delegates = HomeScreenState.Delegate(
                onTapEnglish = viewModel::switchToEnglish,
                onTapBurmese = viewModel::switchToBurmese,
                onTapChinese = viewModel::switchToChinese
            )
        )
    )
}

@Composable
fun HomeScreenStateless(
    state: HomeScreenState
) {

    val localization by remember {
        state.data.localization
    }
    val appLanguage by remember {
        state.data.appLanguage
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = localization.lblGreeting,
                style = TextStyle(
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 24.sp
                )
            )
            Text(
                text = Localization.getTemplatedString(
                    localization.lblSelectedLanguage,
                    appLanguage.value
                ),
                style = TextStyle(
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 24.sp
                )
            )
        }
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            CodigoButton(
                text = localization.lblEnglish,
                onClick = state.delegates.onTapEnglish,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(12.dp))
            CodigoButton(
                text = localization.lblChinese,
                onClick = state.delegates.onTapChinese,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(12.dp))
            CodigoButton(
                text = localization.lblBurmese,
                onClick = state.delegates.onTapBurmese,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenStateProvider::class)
    state : HomeScreenState
) {
    DynamicLocalizationTheme {
        HomeScreenStateless(state)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreviewDark(
    @PreviewParameter(HomeScreenStateProvider::class)
    state : HomeScreenState
) {
    DynamicLocalizationTheme(darkTheme = true) {
        HomeScreenStateless(state)
    }
}