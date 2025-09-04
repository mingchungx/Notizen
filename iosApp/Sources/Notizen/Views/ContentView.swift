//
//  ContentView.swift
//  Notizen
//
//  Created by Mingchung Xia on 2025-08-13.
//

import SwiftUI
import Shared

struct ContentView: View {
    private let viewModel = injectContentViewModel()
    
    @State private var count: KotlinInt
    @State private var text: String
    
    init() {
        self._count = .init(initialValue: viewModel.countFlow.value)
        self._text = .init(initialValue: viewModel.textFlow.value)
    }
    
    var body: some View {
        VStack {
            Text(String(Int(truncating: count)))
            Button {
                viewModel.onAction(action: ContentViewModel.ActionIncrement())
            } label: {
                Text("increment!")
            }
            Text(text)
            Button {
                viewModel.onAction(action: ContentViewModel.ActionFetchGreeting())
            } label: {
                Text("fetch greeting!")
            }
            Image(resource: \.cat)
                .resizable()
                .scaledToFit()
        }
        .animation(.default, value: count)
        .animation(.default, value: text)
        .collect(flow: viewModel.countFlow, into: $count)
        .collect(flow: viewModel.textFlow, into: $text)
        .onAppear {
            viewModel.onLaunch()
        }
    }
}

