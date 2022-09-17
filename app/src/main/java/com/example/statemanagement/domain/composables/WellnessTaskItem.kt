package com.example.statemanagement.domain.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.statemanagement.R
import com.example.statemanagement.data.model.WellnessTask

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    task: WellnessTask,
    checked: Boolean,
    onCheck: (Boolean) -> Unit,
    onClose: () -> Unit,
    icon: ImageVector = Icons.Filled.Close,
    @StringRes iconDesc: Int = R.string.close,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = task.label, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        Checkbox(checked = checked, onCheckedChange = {
            onCheck(it)
        })
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = onClose,
        ) {
            Icon(imageVector = icon, contentDescription = stringResource(id = iconDesc))
        }
    }
}



