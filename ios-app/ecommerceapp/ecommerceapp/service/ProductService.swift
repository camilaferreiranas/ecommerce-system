//
//  ProductService.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//
import Foundation

class ProductService  {
    func fetchProducts() async throws -> [Product] {
        guard let url = URL(string: "http://localhost:8080/products/all") else {
            throw URLError(.badURL)
        }
        
        let (data, _) = try await URLSession.shared.data(from: url)
        let response = try JSONDecoder().decode(ProductResponse.self, from: data)
        return response.content
    }
}
