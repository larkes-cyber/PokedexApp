//
//  PokemonListView.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct PokemonListView: View {
    
    let viewState:PokemonListViewState
    let viewEvent:(PokemonListEvent) -> Void
    
    var body: some View {
        let _ = print(viewState)
        VStack{
            VStack{
                Spacer()
                    .frame(height: 35)
                Text("Pokedex")
                    .font(.title)
                Spacer()
                    .frame(height: 15)
                Text("Search for Pokemon by name or using the National Pokedex number")
                    .font(.subheadline)
                    .foregroundColor(.gray)
                    .multilineTextAlignment(.center)

                Spacer()
                    .frame(height: 15)
                CommonTextField(hint: "What Pokemon are you looking for?", onValueChanged: {value in
                    viewEvent(PokemonListEvent.SearchEntered(text: value))
                })
                Spacer()
                    .frame(height: 15)
            }
            .padding(.horizontal, 20)
            
            
            List{
                ForEach(viewState.list, id:\.id){item in
                    PokemonListItem(pokemon: item)
                        .onAppear(perform: {
                            if(item == viewState.list.last){
                                viewEvent(PokemonListEvent.EndScrolled())
                            }
                        })
                }
                
            }
            .padding(.vertical, 0)
            
        }
    }
}

