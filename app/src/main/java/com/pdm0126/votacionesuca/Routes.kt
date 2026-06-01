package com.pdm0126.votacionesuca

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()
    @Serializable
    data object Votes : Routes()
}