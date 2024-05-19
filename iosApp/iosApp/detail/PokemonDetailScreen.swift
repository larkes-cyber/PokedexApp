//
//  PokemonDetailScreen.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct PokemonDetailScreen: View {
    
    let id:String
    let viewModel:PokemonDetailViewModel = PokemonDetailViewModel()
    
    init(id: String) {
        self.id = id
        viewModel.obtainEvent(viewEvent: PokemonDetailEvent.LoadPokemonInfo(id: id))
    }
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            PokemonDetailView(viewState: viewState){event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

