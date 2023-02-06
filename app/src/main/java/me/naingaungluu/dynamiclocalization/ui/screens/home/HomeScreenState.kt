import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.naingaungluu.dynamiclocalization.data.models.Localization
import me.naingaungluu.dynamiclocalization.preferences.AppLanguage

data class HomeScreenState(
    val data : Data = Data(),
    val delegates: Delegate = Delegate()
) {
    data class Data(
        val localization: State<Localization> = mutableStateOf(Localization()),
        val appLanguage: State<AppLanguage> = mutableStateOf(AppLanguage.ENGLISH)
    )

    data class Delegate(
        val onTapEnglish: () -> Unit = {},
        val onTapChinese: () -> Unit = {},
        val onTapBurmese: () -> Unit = {}
    )

    companion object {
        val previewState by lazy {
            HomeScreenState(
                data = Data(
                    localization = mutableStateOf(Localization.getDefaultLocalization())
                ),
                delegates = Delegate()
            )
        }
    }
}

class HomeScreenStateProvider: PreviewParameterProvider<HomeScreenState> {
    override val values: Sequence<HomeScreenState>
        get() = sequenceOf(
            HomeScreenState.previewState.copy(
                data = HomeScreenState.Data(
                    appLanguage = mutableStateOf(AppLanguage.ENGLISH),
                    localization = mutableStateOf(
                        Localization.getDefaultLocalization(AppLanguage.ENGLISH)
                    )
                )
            ),
            HomeScreenState.previewState.copy(
                data = HomeScreenState.Data(
                    appLanguage = mutableStateOf(AppLanguage.CHINESE),
                    localization = mutableStateOf(
                        Localization.getDefaultLocalization(AppLanguage.CHINESE)
                    )
                )
            ),
            HomeScreenState.previewState.copy(
                data = HomeScreenState.Data(
                    appLanguage = mutableStateOf(AppLanguage.BURMESE),
                    localization = mutableStateOf(
                        Localization.getDefaultLocalization(AppLanguage.BURMESE)
                    )
                )
            )
        )

}