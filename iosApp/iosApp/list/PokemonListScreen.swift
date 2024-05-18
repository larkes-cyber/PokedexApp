//
//  PokemonListScreen.swift
//  iosApp
//
//  Created by MacBook on 18.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK
import Combine


struct PokemonListScreen: View {
    
    @ObservedObject private var viewModel:PokemonListViewModel = PokemonListViewModel()

  
    
    
    var body: some View {
   

        VStack{
    
            if(viewModel.state(\.isLoading)){
                    ProgressView()
                }
            if(!viewModel.state(\.pokemonList.).isEmpty){
                    List(content: {
                        ForEach(viewModel.state(\.viewState).list, id: \.id){item in
                            Text(item.name)
                        }
                    })
                }
            
        }
        .onReceive(createPublisher(viewModel.viewAction)){action in
            
        }
    }
}

#Preview {
    PokemonListScreen()
}

extension PokemonListViewModel {
    var stateKs: Pokemon {
        get {
            return self.state(
                \.state,
                equals: { $0 === $1 },
                mapper: { BookListViewModelStateKs($0) }
            )
        }
    }
    
    var actionsKs: AnyPublisher<BookListViewModelActionKs, Never> {
        get {
            return createPublisher(self.actions)
                .map { BookListViewModelActionKs($0) }
                .eraseToAnyPublisher()
        }
    }
}
