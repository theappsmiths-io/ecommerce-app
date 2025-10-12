package com.theappsmiths.designsystem.ui.searchbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ecommerce.designsystem.generated.resources.Res
import ecommerce.designsystem.generated.resources.cd_back
import ecommerce.designsystem.generated.resources.hint_search
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarInputField(
    textFieldState: TextFieldState,
    searchBarState: SearchBarState,
    scope: CoroutineScope = rememberCoroutineScope(),
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    SearchBarDefaults.InputField(
        modifier = modifier.fillMaxWidth(),
        query = textFieldState.text.toString(),
        onQueryChange = { textFieldState.edit { replace(0, length, it) } },
        onSearch = {
            onSearch(it)
            scope.launch { searchBarState.animateToCollapsed() }
        },
        expanded = searchBarState.currentValue == SearchBarValue.Expanded,
        onExpandedChange = { expanded ->
            if (expanded) {
                scope.launch { searchBarState.animateToExpanded() }
            } else {
                scope.launch { searchBarState.animateToCollapsed() }
            }
        },
        placeholder = {
            if (searchBarState.currentValue == SearchBarValue.Collapsed) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.hint_search),
                    textAlign = TextAlign.Start,
                )
            }
        },
        leadingIcon = {
            if (searchBarState.currentValue == SearchBarValue.Expanded) {
                TooltipBox(
                    positionProvider = TooltipDefaults.rememberTooltipPositionProvider(),
                    tooltip = { PlainTooltip { Text("Back") } },
                    state = rememberTooltipState(),
                ) {
                    IconButton(onClick = { scope.launch { searchBarState.animateToCollapsed() } }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = stringResource(Res.string.cd_back),
                        )
                    }
                }
            } else {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(Res.string.hint_search),
                )
            }
        },
    )
}
