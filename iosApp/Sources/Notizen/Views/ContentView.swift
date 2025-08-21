//
//  ContentView.swift
//  Notizen
//
//  Created by Mingchung Xia on 2025-08-13.
//

import SwiftUI
import Shared

struct ContentView: View {
    private let greeting = Greeting()
    
    var body: some View {
        VStack {
            Text(greeting.greet())
            Image(resource: \.cat)
                .resizable()
                .scaledToFit()
        }
        .onAppear {
            debugPrint(greeting.greet())
        }
    }
}

