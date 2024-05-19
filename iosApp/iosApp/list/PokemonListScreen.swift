//
//  PokemonListScreen.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct PokemonListScreen: View {
    
    private let viewModel = PokemonListViewModel()
    @State private var isDetailPresented:Bool = false
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            PokemonListView(viewState: viewState){event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            switch(action){
                case PokemonListAction.OpenPokemonDetail():
                    isDetailPresented = true
                    break
                default:
                    break
            }
        }
        .sheet(isPresented:$isDetailPresented, content: {
            PokemonDetailScreen(id: viewModel.viewState.selectedPokemon ?? "")
        })
    }
}

#Preview {
    PokemonListScreen()
}
