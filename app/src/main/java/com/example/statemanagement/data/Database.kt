package com.example.statemanagement.data

import com.example.statemanagement.data.model.WellnessTask


fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

