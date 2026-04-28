//
//  ProductViewModel.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import Foundation
import SwiftUI
import Combine

@MainActor
class ProductViewModel: ObservableObject {
    @Published var products: [Product] = []
    @Published var isLoading = false
    @Published var errorMessage: String?
    
    private let service = ProductService()
    
    func loadProducts() async {
        isLoading = true
        errorMessage = nil
        do {
            products = try await service.fetchProducts()
            
        } catch {
            errorMessage = error.localizedDescription
        }
        isLoading = false
    }
}
