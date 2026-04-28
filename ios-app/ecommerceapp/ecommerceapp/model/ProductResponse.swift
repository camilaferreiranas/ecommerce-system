//
//  ProductResponse.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import Foundation


struct ProductResponse: Decodable {
    let page: Page
    let content: [Product]
}
