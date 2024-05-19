//
//  PokemonListItem.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct PokemonListItem: View {
    
    @State private var dominantColor: Color = .white
    let pokemon:PokemonItem
    
    var body: some View {
        ZStack{
            dominantColor
            HStack{
                VStack{
                    Text("#\(pokemon.id)")
                        .font(.title3)
                        .foregroundColor(.black.opacity(0.7))
                    Text(pokemon.name)
                        .foregroundColor(.black)
                        .font(.title)
                }
                Spacer()
                AsyncImage(url: URL(string: pokemon.imageSrc)){phase in
                    switch phase{
                    case .empty:
                        ProgressView()
                    case .success(let image):
                        image
                            .resizable()
                            .scaledToFit()
                    case .failure:
                        Image(systemName: "photo")
                            .resizable()
                            .scaledToFit()
                    }
                }
                .frame(width:120, height: 120)
                
            }
        }
        .frame(height: 135)
    }
}
    
