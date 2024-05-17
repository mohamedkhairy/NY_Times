package com.example.home.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.home.domain.enums.Periods

@Composable
fun PeriodsDropdownMenu(
    selectionList: List<Periods>,
    selectedPeriod: String,
    onSelection: (String) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
//    var selectedPeriodValue by remember { mutableStateOf("1") }


    IconButton(
        modifier = Modifier
            .fillMaxWidth(0.2f)
            .border(0.5.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp)),
        onClick = { expanded = true }
    ) {
        Text(
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(id = Periods.getPeriod(selectedPeriod).periodName),
        )

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
//                    selectedPeriodValue = item.value
                    onSelection(item.value)
                    expanded = false
                })
        }

    }
}

