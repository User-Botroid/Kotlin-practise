package com.example.loginmodule.items


data class Category(
    val id: String,
    val name: String
)
data class Item(
    val id : Int,
    val title: String,
    val description:String,
    val category: String,
    val price: Double
)

object MockDataProvider {
    val categories = listOf(
        Category("all", "All"),
        Category("electronics", "Electronics"),
        Category("clothing", "Clothing"),
        Category("home", "Home"),
        Category("books", "Books")
    )

    val sampleItems = listOf(
        Item(1, "Wireless Headphones", "High-quality noise-canceling headphones", "Electronics", 99.99),
        Item(2, "Running Shoes", "Comfortable breathable shoes for running", "Clothing", 59.99),
        Item(3, "Smart Watch", "Track your fitness and notifications", "Electronics", 199.99),
        Item(4, "Coffee Maker", "Brew fresh coffee every morning", "Home", 49.99),
        Item(5, "Kotlin Programming Guide", "Learn modern Kotlin from scratch", "Books", 39.99),
        Item(6, "Desk Lamp", "Adjustable LED desk lamp with USB port", "Home", 24.99),
        Item(7, "Cotton T-Shirt", "100% organic cotton casual t-shirt", "Clothing", 19.99),
        Item(8, "Bluetooth Speaker", "Portable wireless speaker with deep bass", "Electronics", 79.99),
        Item(9, "Gaming Keyboard", "Mechanical keyboard with RGB lighting", "Electronics", 89.99),
        Item(10, "USB-C Charger", "Fast charging USB-C wall adapter", "Electronics", 29.99),
        Item(11, "Denim Jeans", "Classic slim-fit blue denim jeans", "Clothing", 44.99),
        Item(12, "Hoodie", "Warm and comfortable cotton hoodie", "Clothing", 54.99),
        Item(13, "Sneakers", "Lightweight everyday casual sneakers", "Clothing", 69.99),
        Item(14, "Table Clock", "Minimal digital desk clock with alarm", "Home", 22.99),
        Item(15, "Water Bottle", "Stainless steel insulated water bottle", "Home", 27.99),
        Item(16, "Wall Art", "Modern abstract decorative wall painting", "Home", 34.99),
        Item(17, "Android Development Book", "Complete guide to modern Android development", "Books", 45.99),
        Item(18, "Clean Code", "A practical guide to writing better software", "Books", 32.99),
        Item(19, "Jetpack Compose Guide", "Learn modern Android UI with Jetpack Compose", "Books", 42.99),
        Item(20, "Wireless Mouse", "Ergonomic wireless mouse with adjustable DPI", "Electronics", 39.99),
        Item(21, "Backpack", "Water-resistant laptop backpack for daily use", "Clothing", 49.99),
        Item(22, "Notebook Set", "Premium ruled notebooks for everyday writing", "Books", 16.99)

    )
}
