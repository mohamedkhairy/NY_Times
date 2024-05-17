package com.example.home.presentation.components.shimmerLoading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.component.shimmer.Shimmer

@Composable
fun ShimmerArticleCardItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Thumbnail
            Box(
                modifier = Modifier.size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Shimmer ()
            }

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            ) {
                Shimmer ()
            }

            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(12.dp)
            ) {
                Shimmer()
            }
        }
    }
}