# API Unions Grupo
**Back-end da aplicação web da empresa Unions Grupo, desenvolvida durante o Hackathon da Coti Informática.**

Essa API consiste em um sistema de networking projetado para ser utilizado por membros associados. O sistema permite que os membros realizem as seguintes ações:

* Convidar outras pessoas para se tornarem membros;
* Marcar reuniões para fechamento de negócios;
* Fazer referências e avaliar serviços adquiridos.

O projeto tem como objetivo facilitar a conexão entre os associados, promovendo oportunidades de negócios e fortalecendo a rede de contatos.

## Funcionalidades
- Cadastro de grupos, gerenciamento de grupos (alteração, exclusão e consulta).
- Cadastro de membros associados a um ou mais grupos, gerenciamento de membros (alteração, exclusão e consulta).
- Cadastro de convidados associados a um membro, gerenciamento de convidados (alteração, exclusão e consulta).
- Possibilidade de agendar uma reunião 1 a 1 entre dois membros.
- Registro de referência e avaliação de um serviço prestado por algum membro.
- Registro de OPNF.

## Tecnologias utilizadas:
- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Swagger**
- **Lombok**
- **Model Mapper**
- **Bean Validation (javax.validation)**

## Endpoints
#### Grupos
| Método | Endpoint             | Descrição                       |
|--------|----------------------|---------------------------------|
| POST   | `/api/grupos`        | Registra um novo grupo          |
| GET    | `/api/grupos`        | Consulta todas os grupos        |
| GET    | `/api/grupos/{id}`   | Consulta um grupo através do ID |
| PUT    | `/api/grupos/{id}`   | Edita um grupo                  |
| DELETE | `/api/grupos/{id}`   | Exclui um grupo                 |

#### Membros
| Método | Endpoint              | Descrição                        |
|--------|-----------------------|----------------------------------|
| POST   | `/api/membros`        | Registra um novo membro          |
| GET    | `/api/membros`        | Consulta todas os membros        |
| GET    | `/api/membros/{id}`   | Consulta um membro através do ID |
| PUT    | `/api/membros/{id}`   | Edita um membro                  |
| DELETE | `/api/membros/{id}`   | Exclui um membro                 |

#### Convidados
| Método | Endpoint                 | Descrição                           |
|--------|--------------------------|-------------------------------------|
| POST   | `/api/convidados`        | Registra um novo convidado          |
| GET    | `/api/convidados`        | Consulta todas os convidados        |
| GET    | `/api/convidados/{id}`   | Consulta um convidado através do ID |
| PUT    | `/api/convidados/{id}`   | Edita um convidado                  |
| DELETE | `/api/convidados/{id}`   | Exclui um convidado                 |

#### Reunião
| Método | Endpoint               | Descrição                           |
|--------|------------------------|-------------------------------------|
| POST   | `/api/reunioes`        | Marca uma nova reunião              |
| GET    | `/api/reunioes`        | Consulta todas os reuniões marcadas |
| GET    | `/api/reunioes/{id}`   | Consulta uma reunião através do ID  |
| PUT    | `/api/reunioes/{id}`   | Altera uma reunião                  |
| DELETE | `/api/reunioes/{id}`   | Desmarca uma reunião                |

#### Referência
| Método | Endpoint                  | Descrição                             |
|--------|---------------------------|---------------------------------------|
| POST   | `/api/referencias`        | Registra uma nova referência          |
| GET    | `/api/referencias`        | Consulta todas as referências         |
| GET    | `/api/referencias/{id}`   | Consulta uma referência através do ID |
| PUT    | `/api/referencias/{id}`   | Altera uma referência                 |
| DELETE | `/api/referencias/{id}`   | Exclui uma referência                 |

#### OPNF
| Método | Endpoint           | Descrição                       |
|--------|--------------------|---------------------------------|
| POST   | `/api/opnf`        | Registra uma nova OPNF          |
| GET    | `/api/opnf`        | Consulta todas as OPNFs         |
| GET    | `/api/opnf/{id}`   | Consulta uma OPNF através do ID |
| PUT    | `/api/opnf/{id}`   | Altera uma OPNF                 |
| DELETE | `/api/opnf/{id}`   | Exclui uma OPNF                 |
