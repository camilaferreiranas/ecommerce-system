//
//  ProductCardView.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import SwiftUI

struct ProductCardView: View {
    
    let product: Product
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(product.title)
                .font(.headline)
            Text(product.description)
                .font(.subheadline)
                .foregroundColor(.gray)
            
            Text(product.price, format: .currency(code: "BRL"))
                .font(.title3)
                .bold()
        }
        .padding()
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(
            
            RoundedRectangle(cornerRadius: 16)
                .fill(Color(.systemBackground))
                .shadow(color: .black.opacity(0.1),
                        radius: 6, x: 0, y: 3)
        )
    }
}

#Preview {
    ProductCardView(product: Product(id: " ", title: "iPhone", description: "iPhone 17", category: "ELETRONICS", quantity: 10, price: 9000, imageUrl: ""))
}
