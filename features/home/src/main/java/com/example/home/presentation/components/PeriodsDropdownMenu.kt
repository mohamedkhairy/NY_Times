package com.example.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.sharedData.enums.Periods

@Composable
fun PeriodsDropdownMenu(
    selectionList: List<Periods>,
    onSelection: (String) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedPeriodValue by remember { mutableStateOf("1") }


    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.List, contentDescription = "Options")
    }
    androidx.compose.material3.DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        selectionList.forEachIndexed { index, item ->
            DropdownMenuItem(
                text = {
                    Text(
                        stringResource(id = item.periodName)
                    )
                },
                onClick = {
                    selectedPeriodValue = item.value
                    onSelection(selectedPeriodValue)
                    expanded = false
                })
        }

    }
}

