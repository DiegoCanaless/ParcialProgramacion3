# Proyecto Mutantes

API desarrollada en Spring Boot y desplegada en Render: "https://parcialprogramacion3-vpg6.onrender.com". Detecta mutantes a traves de analizar las secuencias de ADN y esta conectada a una base de datos creada en H2 para almacenar personas

## Funcionalidades de la API
- *POST* /personas/mutant: Verifica si un ADN pertenece a un mutante.
  - URL: https://parcial-mutantes.onrender.com/personas/mutant
  
- *GET* /stats: Retorna las estadísticas de mutantes y humanos.
  - URL: https://parcial-mutantes.onrender.com/stats

- *GET* /personas: Devuelve todas las personas registradas.
  - URL: https://parcial-mutantes.onrender.com/personas

- *GET* /personas/{id}: Devuelve una persona por ID.
  - URL: https://parcial-mutantes.onrender.com/personas/1


## Maneras de utilizar:

### Clona el repositorio

   Abre una terminal o consola y clona el repositorio:
  ```
   git clone https://github.com/DiegoCanaless/ParcialProgramacion3
  ```
### Descarga el zip

Descarga el zip y extraigalo en una archivo. Ejecutelo con algun IDE (Netbeans, IntelliJ, etc)

### Requisitos:

 - JKL 17*
 - Gradle*
 - Git*
 - IDE elegido*

## Tecnologías utilizadas en el proyecto

- *Java *
- *Spring Boot*
- *Spring Data JPA*
- *H2 Database*
- *Lombok*
