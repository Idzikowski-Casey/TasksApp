# Android Example

## What is this? 

This repository is a practical example of an Android app using modern architecture and best
practices. 

## Architecture and Tenets

### Modular design

This app follows a modular design with a core tenet of favoring smaller feature based modules over 
larger catch all modules (i.e :common). 

Furthermore, in this example we isolate everything into `feature:api` and `feature:impl` modules. 
Where only app level modules depend on `impl` modules. 

### Dependency injection

In this example we utilize Dagger + Anvil for dependency injection. Anvil provides more flexibility
for custom Dagger components and subcomponents as well as creating software scopes that are decoupled 
from Android lifecycles.

### Decoupled UI, Composition over Inheritance

This app utilizes Jetpack Compose for the UI and favors composition over inheritance. Furthermore a 
very important tenet of this codebase is to keep UI and business logic separate and as decoupled as
possible. Views should rely solely on data as input parameters. 

### Asynchronous data flows

This app will favor suspend functions, flows, and the usage of coroutines over callback functions. 