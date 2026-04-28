//
//  ProductGridCardView.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import SwiftUI

struct ProductGridCardView: View {
    let product: Product
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            RoundedRectangle(cornerRadius: 12)
                .fill(Color.gray.opacity(0.2))
                .frame(height: 120)
                .overlay(
                    
                    AsyncImage(url: product.imageUrl.flatMap {URL(string: $0)}) {
                        phase in
                        switch phase {
                        case .empty:
                            Image(systemName: "photo")
                                .font(.largeTitle)
                                .foregroundColor(.gray)
                            
                        case .success(let image):
                            image.resizable()
                                .scaledToFill()
                            
                        case .failure:
                            Image(systemName: "photo")
                                .font(.largeTitle)
                                .foregroundColor(.gray)
                        @unknown default:
                            Image(systemName: "photo")
                                .font(.largeTitle)
                                .foregroundColor(.gray)
                        }
                    }
                        .frame(height: 125)
                        .clipShape(RoundedRectangle(cornerRadius: 16))
                
                )
            
            Text(product.title)
                .font(.subheadline)
                .lineLimit(2)
            Text(product.price, format: .currency(code: "BRL"))
                .font(.headline)
                .bold()
            
            Text(product.category)
                .font(.caption)
                .padding(4)
                .background(Color.blue.opacity(0.1))
                .cornerRadius(6)
            
            Text("\(product.quantity) em estoque")
                .font(.caption)
                .foregroundColor(.green)
        }
        .padding()
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(
            RoundedRectangle(cornerRadius: 16)
                .fill(Color(.systemBackground)
                     )
                .shadow(color: .black.opacity(0.08), radius: 6, x: 0, y: 3)
        )
    }
}

#Preview {
    ProductGridCardView(product: Product(id: " ", title: "iPhone", description: "iPhone 17", category: "ELETRONICS", quantity: 10, price: 9000, imageUrl: "photo"))
}
