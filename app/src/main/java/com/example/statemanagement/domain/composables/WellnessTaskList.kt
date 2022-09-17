package com.example.statemanagement.domain.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.statemanagement.data.model.WellnessTask

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onClose: (WellnessTask) -> Unit,
    onCheck: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = list, key = {task -> task.id}) { task ->
            WellnessTaskItem(
                modifier = modifier,
                task = task,
                onClose = {onClose(task)},
                checked = task.checked,
                onCheck = {
                    onCheck(task, it)
                }
            )
        }
    }
}