//
//  PokemonDetailView.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct PokemonDetailView: View {
    
    let viewState:PokemonDetailViewState
    let viewEvent:(PokemonDetailEvent) -> Void
    
    var body: some View {
        let pokemon = viewState.pokemonAboutInfo
        let _ = print(pokemon)
        VStack{
            if(viewState.isLoading){
                ProgressView()
            }
            if(viewState.pokemonAboutInfo != nil){
                NavigationView{
                    List{
                        Section{
                            Text("height: \(pokemon!.height!)")
                            Text("weight: \(pokemon!.weight!)")
                        } header: {
                            Text("Props")
                        }
                        Section{
                            ForEach(pokemon!.types, id:\.self){item in
                                Text(item)
                            }
                        } header: {
                            Text("Types")
                        }
                        Section{
                            ForEach(pokemon!.abilities, id:\.self){item in
                                Text(item)
                            }
                        } header: {
                            Text("Abilities")
                        }
                        Section{
                            ForEach(pokemon!.stat, id:\.self){item in
                                Text("\(item.first!): \(item.second!)")
                            }
                        }header: {
                            Text("Stats")
                        }
                    }
                    .navigationTitle(pokemon!.name)
                }
            }
        }
    }
}

