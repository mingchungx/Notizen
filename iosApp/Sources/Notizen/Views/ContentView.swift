//
//  ContentView.swift
//  Notizen
//
//  Created by Mingchung Xia on 2025-08-13.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI

struct ContentView: View {
    private let viewModel = ContentViewModel()
    private let greeting = Greeting()
    
    @State private var uiState: UiState
    
    init() {
        self._uiState = .init(initialValue: viewModel.uiState.value)
    }
    
    var body: some View {
        VStack {
            Text(greeting.greet())
            if !uiState.isLoading {
                Text(uiState.title)
            }
            Text(String(uiState.count))
            Button {
                viewModel.increment()
            } label: {
                Text("increment!")
            }
            Image(resource: \.cat)
                .resizable()
                .scaledToFit()
        }
        .animation(.default, value: uiState.isLoading)
        .animation(.default, value: uiState.count)
        .onAppear {
            debugPrint(greeting.greet())
        }
        .collect(flow: viewModel.uiState, into: $uiState)
        .onChange(of: uiState) { _, newValue in
            print("Received newValue: \(newValue)")
        }
        .onAppear {
            viewModel.onLaunch()
        }
    }
}

