# API de Gestão de Médicos

Esta é uma API RESTful simples para gerenciamento de médicos em uma clínica médica. A API permite a realização de operações CRUD (Criar, Ler, Atualizar e Deletar) sobre médicos, além de fornecer autenticação via JWT para garantir a segurança dos endpoints.

## Endpoints

A API possui os seguintes endpoints:

- **POST /api/login**: Endpoint para autenticação de usuários. Recebe um objeto JSON com as credenciais do usuário e retorna um token JWT válido por um determinado período de tempo.

- **POST /api/medicos**: Endpoint para criar um novo médico. Recebe um objeto JSON com os detalhes do médico a ser criado e retorna os dados do médico recém-criado.

- **GET /api/medicos/{id}**: Endpoint para recuperar os detalhes de um médico específico. Recebe o ID do médico como parâmetro na URL e retorna os detalhes do médico correspondente.

- **PUT /api/medicos/{id}**: Endpoint para atualizar os detalhes de um médico existente. Recebe o ID do médico como parâmetro na URL e um objeto JSON com os novos detalhes do médico a serem atualizados.

- **DELETE /api/medicos/{id}**: Endpoint para deletar um médico existente. Recebe o ID do médico como parâmetro na URL e remove o médico correspondente do sistema.

## Autenticação

A API utiliza autenticação via JWT (JSON Web Token) para proteger os endpoints e garantir que apenas usuários autorizados possam acessá-los. Para autenticar, envie uma solicitação POST para `/api/login` com as credenciais do usuário. O token JWT retornado deve ser incluído no cabeçalho `Authorization` para acessar os endpoints protegidos.

## Estrutura do Projeto

A estrutura do projeto está organizada seguindo o conceito de Arquitetura Limpa seguinte forma:

- **api/adapters**: Contém adaptadores responsáveis pela comunicação com o mundo exterior, como DTOs, enums e interfaces.
- **api/communication**: Contém os controladores REST e implementações de gateways para comunicação com o núcleo da aplicação.
- **core**: Contém as entidades principais da aplicação e implementações dos casos de uso.

## Configuração

Para executar a API localmente, siga estas etapas:

1. Clone este repositório em sua máquina local.
2. Configure as dependências e o ambiente de execução conforme especificado no arquivo `pom.xml`.
3. Execute a aplicação.

Certifique-se de configurar corretamente o banco de dados e as credenciais de autenticação para garantir o funcionamento adequado da API.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue para relatar problemas ou sugerir melhorias. Você também pode enviar um pull request com suas próprias contribuições.
