//
//  Page.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import Foundation


struct Page: Decodable {
    let size: Int
    let number: Int
    let totalElements: Int
    let totalPages: Int 
}
