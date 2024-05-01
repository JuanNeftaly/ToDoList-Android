package com.neftaly.todolist.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class plantilla(
    var title: String,
    var description: String,
    var state: MutableState<Boolean> = mutableStateOf(false)
)