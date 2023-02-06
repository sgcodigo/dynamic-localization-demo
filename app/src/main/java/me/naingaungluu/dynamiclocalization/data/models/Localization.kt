package me.naingaungluu.dynamiclocalization.data.models

import me.naingaungluu.dynamiclocalization.preferences.AppLanguage
import java.io.Serializable

class Localization : Serializable {

    /**
     * Properties
     */
    var lblGreeting : String = ""
    var lblSelectedLanguage : String = ""
    var lblEnglish : String = ""
    var lblBurmese : String = ""
    var lblChinese : String = ""

    companion object {
        const val TEMPLATE_HANDLE = "%@"

        private val dummy = Localization().apply {
            lblGreeting = "Hello"
            lblSelectedLanguage = "Selected Language : %@"
            lblEnglish = "English"
            lblChinese = "Chinese"
            lblBurmese = "Burmese"
        }
        private val dummyChinese = Localization().apply {
            lblGreeting = "你好"
            lblSelectedLanguage = "选择的语言 : %@"
            lblEnglish = "英语"
            lblChinese = "缅甸语"
            lblBurmese = "中文"
        }
        private val dummyBurmese = Localization().apply {
            lblGreeting = "မင်္ဂလာပါ။"
            lblSelectedLanguage = "ရွေးချယ်ထားသောဘာသာစကား : %@"
            lblEnglish = "အင်္ဂလိပ်"
            lblChinese = "ဗမာ"
            lblBurmese = "တရုတ်"
        }
        fun getDefaultLocalization(
            appLanguage: AppLanguage = AppLanguage.ENGLISH
        ) : Localization =
            when (appLanguage) {
                AppLanguage.ENGLISH -> dummy
                AppLanguage.BURMESE -> dummyBurmese
                AppLanguage.CHINESE -> dummyChinese
            }

        fun getTemplatedString(format: String, vararg params: String): String =
            if (params.isNotEmpty() && format.contains(TEMPLATE_HANDLE))
                getTemplatedString(
                    format.replaceFirst(TEMPLATE_HANDLE, params.first()),
                    *params.drop(1).toTypedArray()
                )
        else
            format
    }
}