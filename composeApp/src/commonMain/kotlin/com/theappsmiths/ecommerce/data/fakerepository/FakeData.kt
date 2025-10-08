package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.domain.model.Category
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.model.Rating
import com.theappsmiths.ecommerce.domain.model.UserAccount

object FakeData {
    val fakeUsers = listOf(
        UserAccount("demo@demo.com", "demo")
    )

    val fakeCategories = listOf(
        Category(1, "Household & Cleaning", "https://picsum.photos/id/237/200/200"),
        Category(2, "Health & Wellness", "https://picsum.photos/id/123/200/200"),
        Category(3, "Fashion & Apparel", "https://picsum.photos/id/21/200/200"),
        Category(4, "Jewelry & Collections", "https://picsum.photos/id/219/200/200"),
        Category(5, "Bags & Accessories", "https://picsum.photos/id/3/200/200"),
        Category(6, "Furniture & Home", "https://picsum.photos/id/65/200/200"),
    )

    val fakeProductList = listOf(
        Product(
            id = 1,
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            price = 109.95,
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
            rating = Rating(rate = 4.5, count = 120),
        ),
        Product(
            id = 2,
            title = "Mens Casual Premium Slim Fit T-Shirts",
            price = 22.95,
            description = "Modern slim fit jeans crafted from high-quality denim with a slight stretch for comfort.",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
            rating = Rating(rate = 4.1, count = 259),
        ),
        Product(
            id = 3,
            title = "Mens Cotton Jacket",
            price = 35.50,
            description = "Lightweight and breathable floral print summer dress, ideal for warm weather occasions.",
            category = "women's clothing",
            image = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_t.png",
            rating = Rating(rate = 4.7, count = 500),
        ),
        Product(
            id = 4,
            title = "Mens Casual Slim Fit",
            price = 75.00,
            description = "Elegant and spacious genuine leather shoulder bag with multiple compartments.",
            category = "women's clothing",
            image = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_t.png",
            rating = Rating(rate = 4.3, count = 150),
        ),
        Product(
            id = 5,
            title = "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
            price = 22.99,
            description = "Classic sterling silver hoop earrings, a timeless addition to any jewelry collection.",
            category = "jewelery",
            image = "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_t.png",
            rating = Rating(rate = 3.9, count = 70),
        ),
        Product(
            id = 6,
            title = "Solid Gold Petite Micropave",
            price = 89.99,
            description = "Delicate gold plated necklace with a minimalist pendant, perfect for layering.",
            category = "jewelery",
            image = "https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_t.png",
            rating = Rating(rate = 4.6, count = 400),
        ),
        Product(
            id = 7,
            title = "White Gold Plated Princess",
            price = 89.99,
            description = "Delicate gold plated necklace with a minimalist pendant, perfect for layering.",
            category = "jewelery",
            image = "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_t.png",
            rating = Rating(rate = 4.6, count = 400),
        ),
        Product(
            id = 8,
            title = "Pierced Owl Rose Gold Plated Stainless Steel Double",
            price = 89.99,
            description = "Delicate gold plated necklace with a minimalist pendant, perfect for layering.",
            category = "jewelery",
            image = "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_t.png",
            rating = Rating(rate = 4.6, count = 400),
        ),
    )
}
