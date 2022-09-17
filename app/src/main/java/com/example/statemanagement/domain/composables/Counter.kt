package com.example.statemanagement.domain.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.statemanagement.domain.utils.increaseCount


@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier,
    @StringRes desc: Int,
    @StringRes buttonText: Int,
) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StateLessCounter(
        count = count,
        desc = desc,
        buttonText = buttonText,
        onButtonClick = { count = count.increaseCount() },
        isEnabled = count<10,
        modifier = modifier
    )
}

@Composable
fun StateLessCounter(
    count: Int,
    desc: Int,
    buttonText: Int,
    onButtonClick: () -> Unit,
    isEnabled : Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (count > 0) {
            Text(stringResource(id = desc, count))
        }
        Button(
            onClick = onButtonClick,
            modifier = modifier.padding(top = 12.dp),
            enabled = isEnabled
        ) {
            Text(text = stringResource(id = buttonText))
        }
    }
}


