//
//  ProductDetailsView.swift
//  ecommerceapp
//
//  Created by Camila Ferreira  on 28/04/26.
//

import SwiftUI

struct ProductDetailsView: View {
    
    var product: Product
    var body: some View {
       
        VStack(spacing: 0) {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    RoundedRectangle(cornerRadius: 16)
                        .fill(.gray.opacity(0.2))
                        .frame(height: 250)
                        .overlay(
                            Image(systemName: "photo")
                                .font(.largeTitle)
                                .foregroundColor(.gray)
                        )
                    
                    VStack(alignment: .leading, spacing: 8) {
                        Text(product.title)
                            .font(.title2)
                            .bold()
                        Text(product.price, format: .currency(code: "BRL"))
                            .font(.title)
                            .foregroundColor(.green)
                            .bold()
                        
                        Text(product.category)
                            .font(.caption)
                            .padding(6)
                            .background(.blue.opacity(0.1))
                            .cornerRadius(8)
                    }
                    
                    VStack(alignment: .leading, spacing: 8) {
                        Text("Description")
                            .font(.headline)
                        
                        Text(product.description)
                            .font(.body)
                            .foregroundColor(.secondary)
                    }
                    
                    HStack {
                        Text("Disponível")
                        Spacer()
                        Text("\(product.quantity)")
                            .bold()
                            .foregroundColor(.blue)
                        
                    }
                    .padding()
                    .background(Color(.systemGray6))
                    .cornerRadius(12)
                }
                .padding()
            }
            HStack {
                VStack(alignment: .leading) {
                    Text("Preço")
                        .font(.caption)
                    
                    Text(product.price, format: .currency(code: "BRL"))
                        .font(.headline)
                }
                
                Spacer()
                
                Button(action: {
                    comprar()
                }) {
                    Text("Comprar")
                        .bold()
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(.blue)
                        .foregroundColor(.white)
                        .cornerRadius(12)
                }
            }
            .padding()
            .background(.ultraThinMaterial)
        }
        .navigationTitle("Details")
        .navigationBarTitleDisplayMode(.inline)
    }
}


func comprar() {
    print("OK")
}

#Preview {
    ProductDetailsView(product: Product(id: " ", title: "iPhone", description: "iPhone 17", category: "ELETRONICS", quantity: 10, price: 9000, imageUrl: " "))
}
