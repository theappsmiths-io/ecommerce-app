package com.theappsmiths.ecommerce.data.fakerepository

import com.theappsmiths.ecommerce.domain.model.CartItem
import com.theappsmiths.ecommerce.domain.model.MainCategory
import com.theappsmiths.ecommerce.domain.model.Product
import com.theappsmiths.ecommerce.domain.model.Rating
import com.theappsmiths.ecommerce.domain.model.SubCategory
import com.theappsmiths.ecommerce.domain.model.UserAccount

object FakeData {
    val fakeUsers = listOf(
        UserAccount("demo@demo.com", "demo")
    )

    val allSubCategories: List<SubCategory> = listOf(
        //women
        SubCategory(id = "sub_w_dresses", name = "Dresses", mainCategoryId = "women"),
        SubCategory(id = "sub_w_tops", name = "Tops & Blouses", mainCategoryId = "women"),
        SubCategory(id = "sub_w_jeans", name = "Jeans & Skirts", mainCategoryId = "women"),
        SubCategory(id = "sub_w_sneakers", name = "Sneakers", mainCategoryId = "women"),
        SubCategory(id = "sub_w_bags", name = "Handbags & Totes", mainCategoryId = "women"),

        //men
        SubCategory(id = "sub_m_shirts", name = "Shirts (Casual)", mainCategoryId = "men"),
        SubCategory(id = "sub_m_pants", name = "Pants & Chinos", mainCategoryId = "men"),
        SubCategory(id = "sub_m_formal_shoes", name = "Formal Shoes", mainCategoryId = "men"),
        SubCategory(id = "sub_m_watches", name = "Watches", mainCategoryId = "men"),

        //beauty
        SubCategory(id = "sub_b_skincare", name = "Skincare", mainCategoryId = "beauty"),
        SubCategory(id = "sub_b_makeup", name = "Makeup", mainCategoryId = "beauty"),

        //sport
        SubCategory(id = "sub_s_activewear", name = "Activewear Tops", mainCategoryId = "sport"),
        SubCategory(id = "sub_s_runshoes", name = "Running Shoes", mainCategoryId = "sport"),

        //gadgets
        SubCategory(id = "sub_g_audio", name = "Headphones & Speakers", mainCategoryId = "gadgets"),
        SubCategory(id = "sub_g_wearables", name = "Smartwatches & Trackers", mainCategoryId = "gadgets"),
        SubCategory(id = "sub_g_chargers", name = "Power Banks & Chargers", mainCategoryId = "gadgets"),

        //home
        SubCategory(id = "sub_h_decor", name = "Home Decor", mainCategoryId = "home"),
        SubCategory(id = "sub_h_living", name = "Living Room Furniture", mainCategoryId = "home"),
        SubCategory(id = "sub_h_kitchen", name = "Kitchenware", mainCategoryId = "home"),

        //toys
        SubCategory(id = "sub_t_blocks", name = "Building Blocks", mainCategoryId = "toys"),
        SubCategory(id = "sub_t_action", name = "Action Figures & Dolls", mainCategoryId = "toys"),
        SubCategory(id = "sub_t_games", name = "Board Games & Puzzles", mainCategoryId = "toys"),

        //outdoor
        SubCategory(id = "sub_o_camping", name = "Camping Gear", mainCategoryId = "outdoor"),
        SubCategory(id = "sub_o_sports", name = "Team Sports Equipment", mainCategoryId = "outdoor"),
        SubCategory(id = "sub_o_hydration", name = "Water Bottles & Flasks", mainCategoryId = "outdoor")
    )

    val fakeCategories: List<MainCategory> = listOf(
        MainCategory(
            id = "women",
            name = "Women",
            imageUrl = "https://picsum.photos/id/65/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "women" },
        ),
        MainCategory(
            id = "men",
            name = "Men",
            imageUrl = "https://picsum.photos/id/447/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "men" },
        ),
        MainCategory(
            id = "beauty",
            name = "Beauty",
            imageUrl = "https://picsum.photos/id/21/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "beauty" },
        ),
        MainCategory(
            id = "sport",
            name = "Sport",
            imageUrl = "https://picsum.photos/id/157/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "sport" },
        ),
        MainCategory(
            id = "gadgets",
            name = "Gadgets",
            imageUrl = "https://picsum.photos/id/0/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "gadgets" },
        ),
        MainCategory(
            id = "home",
            name = "Furniture & Home",
            imageUrl = "https://picsum.photos/id/42/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "home" },
        ),
        MainCategory(
            id = "toys",
            name = "Toys",
            imageUrl = "https://picsum.photos/id/96/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "toys" },
        ),
        MainCategory(
            id = "outdoor",
            name = "Outdoor & Leisure",
            imageUrl = "https://picsum.photos/id/177/200/200",
            subCategories = allSubCategories.filter { it.mainCategoryId == "outdoor" },
        ),
    )

    val fakeCartItems: List<CartItem> = listOf(
        CartItem(
            productId = 14,
            name = "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED",
            price = 999.99,
            quantity = 1,
            imageUrl = "https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_t.png"
        ),
        CartItem(
            productId = 12,
            name = "WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive",
            price = 114.00,
            quantity = 2,
            attributes = mapOf("Size" to "4TB"),
            imageUrl = "https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_t.png"
        ),
        CartItem(
            productId = 2,
            name = "Mens Casual Premium Slim Fit T-Shirts",
            price = 22.95,
            quantity = 1,
            attributes = mapOf("Size" to "M"),
            imageUrl = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png"
        ),
        CartItem(
            productId = 4,
            name = "Mens Casual Slim Fit",
            price = 75.00,
            quantity = 1,
            attributes = mapOf("Size" to "M", "Color" to "Navy"),
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_t.png"
        ),
        CartItem(
            productId = 7,
            name = "White Gold Plated Princess",
            price = 89.99,
            quantity = 1,
            imageUrl = "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_t.png"
        ),
        CartItem(
            productId = 8,
            name = "Pierced Owl Rose Gold Plated Stainless Steel Double",
            price = 89.99,
            quantity = 1,
            imageUrl = "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_t.png"
        ),
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
        Product(
            id = 9,
            title = "WD 2TB Elements Portable External Hard Drive - USB 3.0",
            price = 64.0,
            description = "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system",
            category = "electronics",
            image = "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_t.png",
            rating = Rating(rate = 3.3, count = 203)
        ),
        Product(
            id = 10,
            title = "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
            price = 109.0,
            description = "Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)",
            category = "electronics",
            image = "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_t.png",
            rating = Rating(rate = 2.9, count = 470)
        ),
        Product(
            id = 11,
            title = "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5",
            price = 109.0,
            description = "3D NAND flash are applied to deliver high transfer speeds Remarkable transfer speeds that enable faster bootup and improved overall system performance. The advanced SLC Cache Technology allows performance boost and longer lifespan 7mm slim design suitable for Ultrabooks and Ultra-slim notebooks. Supports TRIM command, Garbage Collection technology, RAID, and ECC (Error Checking & Correction) to provide the optimized performance and enhanced reliability.",
            category = "electronics",
            image = "https://fakestoreapi.com/img/71kWymZ+c+L._AC_SX679_t.png",
            rating = Rating(rate = 4.8, count = 319)
        ),
        Product(
            id = 12,
            title = "WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive",
            price = 114.0,
            description = "Expand your PS4 gaming experience, Play anywhere Fast and easy, setup Sleek design with high capacity, 3-year manufacturer's limited warranty",
            category = "electronics",
            image = "https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_t.png",
            rating = Rating(rate = 4.8, count = 400)
        ),
        Product(
            id = 13,
            title = "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin",
            price = 599.0,
            description = "21. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology. No compatibility for VESA Mount Refresh Rate: 75Hz - Using HDMI port Zero-frame design | ultra-thin | 4ms response time | IPS panel Aspect ratio - 16: 9. Color Supported - 16. 7 million colors. Brightness - 250 nit Tilt angle -5 degree to 15 degree. Horizontal viewing angle-178 degree. Vertical viewing angle-178 degree 75 hertz",
            category = "electronics",
            image = "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_t.png",
            rating = Rating(rate = 2.9, count = 250)
        ),
        Product(
            id = 14,
            title = "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED",
            price = 999.99,
            description = "49 INCH SUPER ULTRAWIDE 32:9 CURVED GAMING MONITOR with dual 27 inch screen side by side QUANTUM DOT (QLED) TECHNOLOGY, HDR support and factory calibration provides stunningly realistic and accurate color and contrast 144HZ HIGH REFRESH RATE and 1ms ultra fast response time work to eliminate motion blur, ghosting, and reduce input lag",
            category = "electronics",
            image = "https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_t.png",
            rating = Rating(rate = 2.2, count = 140)
        ),
    )

    val fakeFavorites = listOf(
        fakeProductList[1],
        fakeProductList[3],
        fakeProductList[5],
        fakeProductList[6],
        fakeProductList[8],
        fakeProductList[9],
        fakeProductList[10],
        fakeProductList[12],
    )

    val fakeTopSellingProducts = fakeProductList.subList(0, 5)

    val fakeForYouProducts = fakeProductList.subList(6, fakeProductList.size)
}
