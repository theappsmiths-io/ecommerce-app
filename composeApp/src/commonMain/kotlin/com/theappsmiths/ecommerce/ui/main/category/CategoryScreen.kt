package com.theappsmiths.ecommerce.ui.main.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.theappsmiths.designsystem.ui.loadingindicator.FullscreenLoadingIndicator
import com.theappsmiths.ecommerce.domain.model.MainCategory
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.cd_share_product
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CategoryScreen(modifier: Modifier = Modifier, viewModel: CategoryViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isLoading) {
        FullscreenLoadingIndicator()
    } else {
        CategoryScreen(
            modifier = modifier,
            mainCategories = uiState.categories,
        )
    }
}

@Composable
fun CategoryScreen(modifier: Modifier = Modifier, mainCategories: List<MainCategory>) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            items = mainCategories,
            key = { category -> category.id }
        ) { category ->
            MainCategoryItem(mainCategory = category)
        }
    }
}

@Composable
fun MainCategoryItem(modifier: Modifier = Modifier, mainCategory: MainCategory) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = mainCategory.imageUrl,
            contentDescription = mainCategory.name,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            modifier = Modifier.weight(1f),
            text = mainCategory.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = Bold,
        )

        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = stringResource(Res.string.cd_share_product),
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}
