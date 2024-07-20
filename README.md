# reactive-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

### Guides

Build do projeto

```
mvn clean install
```

Run da aplicação

```
./mvnw compile quarkus:dev
```

Chamada para a endpoint reativo

```
curl -N "http://localhost:8080/api/heroes"

```
