package com.neftaly.todolist.ui.data

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.neftaly.todolist.ui.model.plantilla

// modelo de nuestros datos
@SuppressLint("MutableCollectionMutableState")
val ListaTareas: MutableState<MutableList<plantilla>> = mutableStateOf(mutableListOf())