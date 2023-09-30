# sistema-rifas-online
Sistema formado por diversos microsserviços com backend em Java (maven) e frontend em JS (react)

Primeiro, vamos definir o escopo de cada microsserviço do backend:

**Microsserviço 1: Serviço de Autenticação e Gerenciamento de Usuários**
- Responsável por registrar, autenticar e gerenciar usuários.
- Deve fornecer endpoints para registro, login, atualização de perfil e recuperação de senha.

**Microsserviço 2: Serviço de Gestão de Rifas**
- Responsável por criar, listar e gerenciar rifas.
- Deve fornecer endpoints para criar uma rifa, listar rifas disponíveis, comprar rifas e gerenciar rifas do usuário.

**Microsserviço 3: Serviço de Pagamento**
- Responsável por processar pagamentos das rifas.
- Deve fornecer endpoints para processar transações de pagamento.

Agora, vamos abordar o frontend em React:

**Frontend em React: Interface de Usuário da Loja Online**
- Interface para usuários navegarem e interagirem com o sistema.
- Deve permitir que os usuários se registrem, façam login, visualizem e comprem rifas, gerenciem seu perfil e efetuem pagamentos.


**Este é o resumo da aplicação que pretendo desenvolver, estou estipulando o prazo máximo e super otimista de 15 dias para concluir as funcionalidades básicas**

Iniciando 30/09/2023

Cronograma:

|Evento|Data Inicial|Data Final|
|------|------------|----------|
|Desenvolver microsserviço de Gerenciamento de Usuarios|30/09/2023|02/10/2023|
|Desenvolver microsserviço de Gestão de Rifas|02/10/2023|05/10/2023|
|Desenvolver microsserviço de Serviço de Pagamento|05/10/2023|08/10/2023|
|Desenvolver Interface|08/10/2023|12/10/2023|
|Ajustes finos e containerização|12/10/2023|15/10/2023|