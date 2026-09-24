package com.example.loginmodule.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

@Composable
fun CategoryRow(
    categories: List<Category>,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories){category ->
            FilterChip(
                selected = category == selectedCategory,
                onClick = {onCategorySelected(category)},
                label = {Text(text = category.name)}
            )

        }
    }



}

@Preview
@Composable
fun PreviewCategoryRow(){
    MaterialTheme{
        CategoryRow(
            categories = MockDataProvider.categories,
            selectedCategory = MockDataProvider.categories[0],
            onCategorySelected = {clickedCategory ->

            }
        )
    }
}