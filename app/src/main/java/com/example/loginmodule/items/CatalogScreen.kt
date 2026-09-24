package com.example.loginmodule.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    onItemClick: (Item) -> Unit = {}

){

    var selectedCategory by remember { mutableStateOf(MockDataProvider.categories.first()) }

  val filteredItems = remember (selectedCategory){

      if (selectedCategory.id == "all"){
          MockDataProvider.sampleItems
      }else{
          MockDataProvider.sampleItems.filter { it.category  == selectedCategory.name}
      }

  }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Product Catalog")}
            )
        }
    ) { innerPAdding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPAdding)
        ) {
            CategoryRow(
                categories = MockDataProvider.categories,
                selectedCategory = selectedCategory,
                onCategorySelected  = {clickedCategory ->
                    selectedCategory = clickedCategory
                },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(filteredItems) {item->
                    ItemCard(
                        item = item,
                        onItemClick = {clicked->
                            onItemClick(clicked)
                        }

                    )

                }
            }
        }

    }


}


@Preview(showBackground = true)
@Composable
fun PreviewCatalogScreen(){
    MaterialTheme{
        CatalogScreen ()
    }
}
