package pl.mwaszczuk.githubrepotracker.design.interact

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import pl.mwaszczuk.githubrepotracker.core.interact.SideEffect

@Composable
fun <T> HandleSideEffect(
    sideEffect: SideEffect<T>?,
    onSideEffect: suspend CoroutineScope.(T) -> Unit,
) {
    LaunchedEffect(sideEffect) {
        sideEffect?.let { nonNullSideEffect ->
            nonNullSideEffect { onSideEffect(this) }
        }
    }
}

@Composable
fun <T> HandleToast(
    sideEffect: SideEffect<T>?,
    message: String = "",
) {
    val context = LocalContext.current
    HandleSideEffect(sideEffect = sideEffect) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}