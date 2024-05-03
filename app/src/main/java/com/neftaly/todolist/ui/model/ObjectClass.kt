package com.neftaly.todolist.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class plantilla(
    var title: MutableState<String>,
    var description: MutableState<String>,
    var state: MutableState<Boolean> = mutableStateOf(false)
)