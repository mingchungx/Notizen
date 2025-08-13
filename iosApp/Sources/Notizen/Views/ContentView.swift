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
        Text(greeting.greet())
    }
}
