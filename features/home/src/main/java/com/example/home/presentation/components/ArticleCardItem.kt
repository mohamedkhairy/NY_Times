package com.example.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.component.CoilImagePainter
import com.example.sharedData.model.Article

@Composable
fun ArticleCardItem(
    article: Article,
    openDetails: (Article) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { openDetails(article) }
    ) {

        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        )
        {

            Image(
                painter = CoilImagePainter(imageUrl = article.images?.first()),
                contentDescription = "user image",
                modifier = Modifier
                    .size(150.dp, 150.dp)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = article.title,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                maxLines = 2,
                modifier = Modifier.padding(8.dp)
            )


            Text(
                text = article.source,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
                maxLines = 1,
                modifier = Modifier.padding(8.dp)
            )


        }
    }
}