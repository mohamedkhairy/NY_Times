package com.example.details.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ui.component.CoilImagePainter
import com.example.core.ui.component.scaffold.NYTimesScaffold
import com.example.sharedData.model.Article


@Composable
internal fun DetailsRoute(
    onBackClick: () -> Unit,
    article: Article?,
) {

    ArticleDetailsScreen(
        article = article,
        onBackClick = onBackClick,
    )

}

@Composable
fun ArticleDetailsScreen(
    article: Article?,
    onBackClick: () -> Unit
) {

    NYTimesScaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                article?.let {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Column(
                            Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center
                        )
                        {

                            Image(
                                painter = CoilImagePainter(
                                    imageUrl = article.images
                                ),
                                contentDescription = "article image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .align(Alignment.CenterHorizontally)
                            )

                            Text(
                                text = "Title: ${article.title}",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(8.dp)
                            )


                            Text(
                                text = article.abstract,
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.padding(8.dp)
                            )

                            Text(
                                text = "Source: ${article.source}",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelMedium,
                                maxLines = 1,
                                modifier = Modifier.padding(8.dp)
                            )


                            Text(
                                text = "Publish Date: ${article.publishedDate}",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelMedium,
                                maxLines = 1,
                                modifier = Modifier.padding(8.dp)
                            )

                            Text(
                                text = "Section: ${article.section}",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.labelMedium,
                                maxLines = 1,
                                modifier = Modifier.padding(8.dp)
                            )


                        }
                    }


                }


            }


        }, icon = {}
    )
}
