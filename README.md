# PokedexApp
Kotlin Version Gradle License

Este es un proyecto de aplicación para Android, para mostrar las buenas prácticas de desarrollo móvil, utilizando principios S.O.L.I.D, patrón MVVM, inyección de dependencia (DI) y pruebas unitarias de la aplicación, Actions CI CD

# Tecnologias, patrones y librerias usadas para el desarrollo
<li>Navigator JetPack y safeargs</li>
<li>Hil</li>
<li>Room</li>
<li>Flow y corrutinas</li>
<li>Mvvm</li>

## Testing
Mockito
JUnit

## CI CD 
Con actions Github

## Alcance desarrollado
Se realiza lista de pokemons en RecyclerView con Layout Manager GridLayout, vista detalle pokemon seleccionado en la lista y almacenamiento local de las consultas realizadas, filtrado de busquda

## Pendiente 
Lista de abiliades, movimientos, evoluciones y Lugares

## Como realizar los pendientes
Algunas entities se deben relacionar utilizando @Embedded ejemplo (Pokemons ->  Habilities)
realizar los casos de uso para consultas reutilizando la Sealed Class Resource para manejar las diferentes respuestas
la ui se construyeron los diferentes menus en PokemonDetailsFragment y usando navigation y safeargs (Parcelize Object)
la estructura para la sincronizacion remota y local ya esta establecida




