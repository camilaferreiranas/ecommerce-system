//
//  ProductListView.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import SwiftUI

struct ProductListView: View {
    
    @StateObject private var viewModel = ProductViewModel()
    
    private let columns = [
        GridItem(.flexible()),
        GridItem(.flexible()),
    ]
    
    var body: some View {
        NavigationStack {
            content.navigationTitle("Products")
        }
        .task {
            await viewModel.loadProducts()
        }
    }
    
    @ViewBuilder
    private var content: some View  {
        if viewModel.isLoading {
                ProgressView("Loading products")
            } else if let error = viewModel.errorMessage {
                Text("Error: \(error)")

            } else {
                ScrollView {
                    LazyVGrid(columns: columns, spacing: 16) {
                        ForEach(viewModel.products) {
                            product in
                            NavigationLink(destination: ProductDetailsView(product: product)) {
                                ProductGridCardView(product: product)
                            }
                            .buttonStyle(.plain)
                        }
                    }
                    .padding()
                }

            }

        }
    
}




#Preview {
    ProductListView()
}
