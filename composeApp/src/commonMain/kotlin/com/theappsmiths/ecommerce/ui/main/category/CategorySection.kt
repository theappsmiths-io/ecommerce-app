package com.theappsmiths.ecommerce.ui.main.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.theappsmiths.designsystem.ui.header.HeaderWithNavigation
import com.theappsmiths.designsystem.ui.item.CircleItem
import com.theappsmiths.ecommerce.domain.model.Category
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.header_categories
import ecommerce.composeapp.generated.resources.header_navigation_label
import org.jetbrains.compose.resources.stringResource

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onCategoryClick: (categoryId: Int) -> Unit,
    onNavigationClick: () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        HeaderWithNavigation(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = stringResource(Res.string.header_categories),
            navigationTitle = stringResource(Res.string.header_navigation_label),
            onNavigationClick = onNavigationClick,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(categories) { category ->
                CircleItem(
                    title = category.name,
                    imageContent = {
                        AsyncImage(
                            model = category.imageUrl,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )
                    },
                    onItemClick = {
                        onCategoryClick(category.id)
                    })
            }
        }
    }
}
