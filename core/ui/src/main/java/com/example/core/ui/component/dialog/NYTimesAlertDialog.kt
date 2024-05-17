package com.example.core.ui.component.dialog

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun NyTimesInfoDialog(
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    visibility: Boolean = true
) {
    var isDialogVisible by remember {mutableStateOf(visibility)}


    if (isDialogVisible) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "\uD83D\uDC4B") },
            text = { Text(text = "We are about to open the details!") },
            modifier = Modifier.wrapContentWidth(),
            dismissButton = {
                TextButton(onClick = {
                    onCancel()
                }) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text(text = "Open")
                }
            }
        )
    }
}
