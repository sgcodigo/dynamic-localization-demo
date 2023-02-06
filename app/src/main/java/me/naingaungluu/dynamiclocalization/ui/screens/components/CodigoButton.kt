package me.naingaungluu.dynamiclocalization.ui.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.naingaungluu.dynamiclocalization.ui.theme.DynamicLocalizationTheme

@Composable
fun CodigoButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ),
        modifier = modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCodigoButton() {
    DynamicLocalizationTheme {
        CodigoButton(
            "Dummy Button",
        )
    }
}

@Preview
@Composable
fun PreviewCodigoButtonDark() {
    DynamicLocalizationTheme(darkTheme = true) {
        CodigoButton(
            text = "Dummy Button"
        )
    }
}