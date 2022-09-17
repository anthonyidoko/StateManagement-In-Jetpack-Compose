package com.example.statemanagement.ui.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.statemanagement.data.model.WellnessTask
import com.example.statemanagement.data.getWellnessTasks

class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(task: WellnessTask){
        _tasks.remove(task)
    }

    fun updateCheckedState(task: WellnessTask, checked: Boolean){
        tasks.find { it.id == task.id }?.let {
            it.checked = checked
        }
    }
}
