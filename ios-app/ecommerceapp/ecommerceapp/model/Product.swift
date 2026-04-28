//
//  Product.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import Foundation


struct Product: Identifiable, Decodable, Hashable{
    var id: String
    var title: String
    var description: String
    var category: String
    var quantity: Int
    var price: Double
    var imageUrl: String?
}
