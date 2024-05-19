//
//  CommonTextField.swift
//  iosApp
//
//  Created by MacBook on 19.05.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {
    
    @State private var value = ""
    private let hint:String
    private let enabled:Bool
    private let onValueChanged:(String) -> Void
    
    init(hint: String,enabled:Bool = true, isSecure:Bool = false, onValueChanged:@escaping (String) -> Void) {
        self.hint = hint
        self.enabled = enabled
        self.onValueChanged = onValueChanged
    }
    
    var body: some View {
        ZStack(alignment:.leading){
            RoundedRectangle(cornerRadius: 10.0)
                .foregroundColor(.gray.opacity(0.25))
            
            if(value.isEmpty){
                Text(hint)
                    .foregroundColor(.gray)
                    .padding(EdgeInsets(top: 20, leading: 20, bottom: 20, trailing: 20))
                    .font(.system(size: 16))
            }
            
            TextField("", text: $value)
                .foregroundColor(.gray)
                .font(.system(size: 16))
                .autocapitalization(.none)
                .disableAutocorrection(true)
                .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                .disabled(!self.enabled)
                .onChange(of: value){ newValue in
                    onValueChanged(newValue)
                }
            
        }
        .frame(height: 56)
    }
}

