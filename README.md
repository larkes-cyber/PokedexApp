<h1 align="center">PokedexApp</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">  
 PokedexApp demonstrates modern Kotlin Multiplatform development with  Jetpack Compose, SwiftUI, Koin, Coroutines, Flow, SqlDelight and Ktor based on Multi-Module MVI architecture.
</p>

> [!TIP]
> If you want to see more the Kotlin Multiplatfrom content, check out the [telegram](https://t.me/snikky_notes) channel.
<img width="1000" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/bfef6e48-a5cd-4721-b228-f25e6757700d">

## Download
Go to the [Releases](https://github.com/larkes-cyber/PokedexApp/releases) to download the latest APK.

## Tech stack & Open-source libraries
- Minimum SDK level 24
-  [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/) based, [Jetpack Compose](https://developer.android.com/develop/ui/compose) + [SwiftUI](https://developer.apple.com/xcode/swiftui/) for ui interface.
- Kotlin Multiplatform
  - Expected/actual: Expected and actual declarations allow you to access platform-specific APIs from Kotlin Multiplatform modules. You can provide platform-agnostic APIs in the common code.
  - Gradle kts: Gradle’s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience in supported IDEs, with superior content assist.
- Architecture
  - Multi-Module Concept: Modularization is a practice of organizing a codebase into loosely coupled and self contained parts. Each part is a module. Each module is independent and serves a clear purpose.
  - [MVI/ViewModel](https://github.com/adeo-opensource/kviewmodel--mpp) Architecture: ViewModel hosts the UiState and initializes it with the default state. ViewModel handles the Intent/Action and Manipulates the UiState causing the View change.
  - [Koin](https://insert-koin.io/docs/reference/koin-mp/kmp/): Koin provides us with an all-in kotlin library to use it in our shared module to create injections that can be used by both Android and iOS
  - Repository Pattern: Repository commonly refers to a storage location, often for safety or preservation.
 - [SqlDelight](https://github.com/cashapp/sqldelight):SQLDelight is a powerful tool for implementing data persistence in Kotlin Multiplatform Mobile (KMM) projects
 - [Ktor](https://ktor.io/docs/client-create-multiplatform-application.html):Ktor includes a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses, extend its functionality with plugins, such as authentication, JSON serialization, and so on.
 - [Compose Navigation](https://developer.android.com/develop/ui/compose/navigation): The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component's infrastructure and features.
 - [Coil](https://coil-kt.github.io/coil/compose/): Loading images from network.
 - [Serialization﻿](https://github.com/Kotlin/kotlinx.serialization): Kotlin serialization consists of a compiler plugin, that generates visitor code for serializable classes, runtime library with core serialization API and support libraries with various serialization formats.

## Architecture
**PokedexApp** is based on the Multi-Module Concept, the MVI architecture and the Repository pattern
<img width="500" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/503c2012-d204-430a-b816-7223d4afc356">
<img width="500" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/8997f2bf-4a9c-461e-9860-a561ab9e1cbb">
The project includes 8 modules where: 2 android/iosApp, 1 feature, 2 core, 2 umbrella, 1 utils.

### Android/iosApp
Contains default android/ios project where included shared business logic with umbrella moduels. 

**Additional:**
The UI for android implemented in the feature module, for ios was written in iosApp using SwiftUI

### Feature Pokemon
The feature is to show pokemons and pokemon detail info
<img width="700" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/d55ffbf9-af81-4c3f-bd6e-e97ef08f267c">
- **Api:** Contains repositories’s interfaces and data models 
- **Data:** Contains the implemetation of the repositories and data sources
- **Presentation:** Contains viewmodels
- **Compose:** Contains android ui

**UI -> ViewModels -> Repositories -> DataSource**

**Compose -> Presentation -> Api(Data)**

### Core
Contains all http/database initialization and DI inject 
<img width="1351" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/07f7e1cc-bd48-4c78-9c64-e45f7c0385ed">

### Core-Root
Contains PlatfromSDK that executes in android/ios app for initialzation business logic, then it injects into Inject singleton object
<img width="463" alt="image" src="https://github.com/larkes-cyber/PokedexApp/assets/79082708/ac30da2c-d24b-4a8c-a4c8-a118be7a4cdc">

### Compose-root
Contains navigation + theme setup

### Ios-root
Contains pod build gradle setup










 
