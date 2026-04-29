package id.my.sendiko.scanner.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import simpleqrscanner.composeapp.generated.resources.Res
import simpleqrscanner.composeapp.generated.resources.manrope_bold
import simpleqrscanner.composeapp.generated.resources.manrope_extrabold
import simpleqrscanner.composeapp.generated.resources.manrope_extralight
import simpleqrscanner.composeapp.generated.resources.manrope_light
import simpleqrscanner.composeapp.generated.resources.manrope_medium
import simpleqrscanner.composeapp.generated.resources.manrope_regular
import simpleqrscanner.composeapp.generated.resources.manrope_semibold

@Composable
fun manropeFontFamily() = FontFamily(
    Font(Res.font.manrope_light, FontWeight.Light),
    Font(Res.font.manrope_regular, FontWeight.Normal),
    Font(Res.font.manrope_medium, FontWeight.Medium),
    Font(Res.font.manrope_semibold, FontWeight.SemiBold),
    Font(Res.font.manrope_bold, FontWeight.Bold),
    Font(Res.font.manrope_extrabold, FontWeight.ExtraBold),
    Font(Res.font.manrope_extralight, FontWeight.ExtraLight),
)

val AppTypography: Typography
    @Composable
    get() {
        val fontFamily = manropeFontFamily()
        return Typography(
            headlineLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = (-0.02).sp
            ),
            headlineMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = (-0.01).sp
            ),
            bodyLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.5.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.25.sp
            ),
            labelMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.05.sp
            ),
            labelSmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp
            )
        )
    }
