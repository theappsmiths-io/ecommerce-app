package com.theappsmiths.ecommerce.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theappsmiths.designsystem.ui.pager.BannerSpotlight
import ecommerce.composeapp.generated.resources.Res
import ecommerce.composeapp.generated.resources.banner1

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        val banners = listOf(
            Res.drawable.banner1,
            Res.drawable.banner1,
            Res.drawable.banner1,
        )
        BannerSpotlight(modifier = Modifier.padding(horizontal = 16.dp), banners = banners)
    }
}
