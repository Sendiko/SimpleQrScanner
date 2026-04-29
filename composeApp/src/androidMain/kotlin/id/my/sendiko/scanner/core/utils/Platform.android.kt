package id.my.sendiko.scanner.core.utils

import android.content.Context
import android.content.Intent

private var androidContext: Context? = null

fun initializePlatform(context: Context) {
    androidContext = context
}

actual fun shareContent(content: String) {
    androidContext?.let { context ->
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, content)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(Intent.createChooser(intent, "Share via"))
    }
}
