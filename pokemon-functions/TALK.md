# Checklist for talk about Micronaut

## Prerequisites

- Check if IntelliJ is running
- Adjust terminal font size (⌘ + +)
- Remove Pokémon function from AWS
- Log in on AWS

## Setup

- Explore CLI (`mn create-function-app --list-features`)
- Create a function application through the CLI
  - Features: http-client (`--features` flag)
  - Java version: 11 (`--java-version` flag)
- Enable annotation processing in IDE
- Add Lombok dependency (shortcut: `lombok`)
- Update imports

## Serverless

- Rename `BookRequest` to `PokemonRequest`
  - Field `name`
- Rename `Book` to `PokemonSpecies`
  - Field `id`
  - Field `name`
  - Field `entries` with `@JsonProperty("flavor_text_entries")`
- Create `PokedexEntry`
  - Field `text` with `@JsonProperty("flavor_text")`
  - Field `language`
- Create `PokedexLanguage`
  - Field `name`
- Create `PokeAPIClient`
- Inject client in function
- Build shadowJAR with `./gradlew shadowJar`

## Deploy function on aWS

- Step 1
  - Select proper environment (Java 11)
- Step 2
  - Upload JAR-file
  - Application requires at least 300MB
  - Use proper class name
  - Add test case (use lowercase letters!)
- Test using test case

## Common issues

- AWS function returns `null`
  - Make sure URL is correct
  - Make sure pokémon name is in lowercase
  - Make sure the field names match
  - Make sure https is used, otherwise 301 redirect is used (no clue if Micronaut http client automatically follows or not)
- NoClassDefFound error when running function:
  - Happens when using normal JAR in stead of shadow JAR
  - Run `./gradlew shadowJar`
  - Use `*-all.jar`
- Upload JAR not available
  - Make sure proper environment is selected during step 1
  - If not, restart