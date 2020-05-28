<img src="icon.png" align="right" />

# Awesome README [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)
> O melhor README(ou tentativa) que você ira ver hoje.

Corona Virus API: repositorio de uma API onde visa centralizar os dados do governo sobre os dados do corona virus por estado/cidade.

## Getting Started

Esse se propõe a buscar todos os dados do corona virus disponibilizado pelo governo filtrando por estado/cidade e disponibilizao numa api de forma organizada e documentada.

API Governo:

https://covid.saude.gov.br/
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalRegiaoSaude
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalCasos
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalRegiaoUf
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalMunicipio
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalGeralApi
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalSintese
https://xx9p7hp1p7.execute-api.us-east-1.amazonaws.com/prod/PortalEstado
https://covid.saude.gov.br/assets/data/municipios.json


### Prerequisites

Projeto Desenvolvido em Java 1.8+ usando Springboot.

Frameworks utilizados no projeto:

```
Spring starterWeb - Para uso do tomcat embedded e facilidade no desenvolvimento das api.
JPA - Pera a persistencia dos dados incluindo spring-data e hibernate.
H2 -Banco de dados em memoria.
Spring-security - Usado para a segurança na exposição dos endpoints.
JWT- Usado para autenticação nos endpoints.
Junit - para testes unitarios
Mockito - Para Mock em testes
Swagger2 - Para criação do swagger para documentação dos endpoints.

```
Foi adotado O padrão arquitetura Clean Arch 
Testes desenvolvidos usando TDD
E a API foi internacionalizada
Durante todo o processo de desenvolvido foi se atento para que seja limpo e organizado seguindo os princípios SOLID.

### Usage


### Documentação

Foi adicionado um swagger mapeando as rotas disponiveis, ele esta acessivel em: 
Queria ter melhorado um pouco mais o codigo e implementado 

```
http://localhost:8080/swagger-ui.html
```

<img src="swagger.png" align="right" />

<br><br>
### Observaçes

