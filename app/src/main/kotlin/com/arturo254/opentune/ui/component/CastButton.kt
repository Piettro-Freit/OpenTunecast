package com.arturo254.opentune.ui.component

import android.view.ContextThemeWrapper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.mediarouter.app.MediaRouteButton
import com.google.android.gms.cast.framework.CastButtonFactory

/**
 * Botão de Cast. Precisa de contexto com tema AppCompat e de uma FragmentActivity (MainActivity).
 * Se o aparelho não tiver Google Play Services, o botão simplesmente não é criado.
 */
@Composable
fun CastButton(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            MediaRouteButton(
                ContextThemeWrapper(context, androidx.appcompat.R.style.Theme_AppCompat),
            ).also { button ->
                runCatching { CastButtonFactory.setUpMediaRouteButton(context.applicationContext, button) }
            }
        },
    )
}
