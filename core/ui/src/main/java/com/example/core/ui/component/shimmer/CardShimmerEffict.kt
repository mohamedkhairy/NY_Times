package com.example.core.ui.component.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerArticleCardItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Thumbnail
        Box(
            modifier = Modifier
                .size(100.dp)
        ) {
            Shimmer {
                // Thumbnail content
            }
        }

        // Headline
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        ) {
            Shimmer {
                // Headline content
            }
        }

        // Author
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(12.dp)
        ) {
            Shimmer {
                // Author content
            }
        }

        // Date
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(12.dp)
        ) {
            Shimmer {
                // Date content
            }
        }
    }
}