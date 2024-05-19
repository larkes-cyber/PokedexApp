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
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            PokemonListView(viewState: viewState){event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

#Preview {
    PokemonListScreen()
}
