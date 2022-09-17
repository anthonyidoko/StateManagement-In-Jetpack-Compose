package com.example.statemanagement.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.statemanagement.R
import com.example.statemanagement.domain.composables.StatefulCounter
import com.example.statemanagement.domain.composables.WellnessTaskList
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statemanagement.ui.viewModel.WellnessViewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier) {
        StatefulCounter(
            modifier = modifier,
            desc = R.string.text_desc,
            buttonText = R.string.add_one,
        )

        WellnessTaskList(list = wellnessViewModel.tasks,
            onClose = {
                wellnessViewModel.remove(it)
            },
            onCheck = { task, checked ->
                wellnessViewModel.updateCheckedState(task, checked)
            }
        )
    }
}