# 🏭 Sistema de Manutenção Industrial

O **Sistema de Manutenção Industrial** é um projeto desenvolvido em **Java** com arquitetura em camadas, seguindo o padrão **MVC** (Model–View–Controller) e princípios de separação de responsabilidades.  
Seu objetivo é gerenciar **máquinas**, **peças**, **técnicos** e **ordens de manutenção** dentro de um ambiente industrial.

---

## 📂 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │    └── weg.manutencaoIndustrial/
     │         ├── app/
     │         │    └── Main.java                  # Ponto de entrada do sistema
     │         │
     │         ├── connection/
     │         │    └── Conexao.java               # Classe responsável pela conexão com o banco de dados
     │         │
     │         ├── controller/
     │         │    └── ManutencaoSystem.java      # Camada de controle do sistema (coordena fluxos principais)
     │         │
     │         ├── dao/                            # Camada DAO — acesso e manipulação de dados no banco
     │         │    ├── MaquinasDAO.java
     │         │    ├── OrdemPecasDAO.java
     │         │    ├── OrdensManutencaoDAO.java
     │         │    ├── PecasDAO.java
     │         │    └── TecnicosDAO.java
     │         │
     │         ├── dto/
     │         │    └── ValidacaoMaquina.java      # DTO para validação e transporte de dados
     │         │
     │         ├── model/                          # Entidades e classes de domínio
     │         │    ├── enums/                     # Enumerações específicas do domínio
     │         │    ├── Maquinas.java
     │         │    ├── OrdemPecas.java
     │         │    ├── OrdensManutencao.java
     │         │    ├── Pecas.java
     │         │    └── Tecnicos.java
     │         │
     │         ├── service/                        # Camada de lógica de negócio
     │         │    ├── MaquinasService.java
     │         │    ├── OrdemPecasService.java
     │         │    ├── OrdensManutencaoService.java
     │         │    ├── PecasService.java
     │         │    └── TecnicosService.java
     │         │
     │         ├── utils/
     │         │    └── Utils.java                 # Funções utilitárias gerais do sistema
     │         │
     │         └── view/                           # Camada de interface e interação com o usuário
     │              ├── Inputs.java                # Entrada de dados e validações de input
     │              ├── Mensagens.java             # Exibição de mensagens ao usuário
     │              └── Menus.java                 # Estrutura de menus e navegação
     │
     ├── resources/                                # Arquivos de configuração e recursos
     └── test/                                     # Testes unitários e de integração
```

---

## 🧩 Funcionalidades Principais

- ✅ **Cadastro de Máquinas**  
  Registra e gerencia informações sobre os equipamentos industriais.

- 🧰 **Gestão de Peças e Técnicos**  
  Controla peças utilizadas e técnicos responsáveis pelas manutenções.

- 🧾 **Ordens de Manutenção**  
  Criação, acompanhamento e finalização de ordens de manutenção.

- ⚙️ **Validação de Dados via DTO**  
  Assegura a consistência das informações inseridas pelo usuário.

- 🧠 **Camada de Serviço Isolada**  
  Implementa as regras de negócio de forma modular e reutilizável.

---

## 🖥️ Interface do Menu Inicial

A aplicação é executada em modo **console (CLI)**.  
Ao iniciar o sistema, o usuário visualiza o menu principal conforme o exemplo abaixo:

```
+-----------------------------------------------+
|         WEG Manutencao Industrial             |
|-----------------------------------------------|
|                   opções                      |
|-----------------------------------------------|
| 1 - Cadastrar Máquina                         |
| 2 - Cadastrar Técnico                         |
| 3 - Cadastrar Peça                            |
| 4 - Criar Ordem de Manutenção                 |
| 5 - Associar Peças à ordem                    |
| 6 - Executar Manutenção                       |
|-----------------------------------------------|
| 0 - sair                                      |
+-----------------------------------------------+
```

---

## 🧱 Arquitetura em Camadas

| Camada          | Descrição                                                                 |
|-----------------|----------------------------------------------------------------------------|
| **app**         | Contém o ponto de entrada da aplicação (`Main`)                            |
| **connection**  | Configura e gerencia a conexão com o banco de dados                        |
| **controller**  | Gerencia o fluxo entre view, service e DAO                                 |
| **dao**         | Manipula dados diretamente no banco (CRUD)                                 |
| **dto**         | Transfere dados entre camadas e realiza validações                         |
| **model**       | Define as entidades e enums do domínio industrial                          |
| **service**     | Implementa as regras de negócio                                            |
| **view**        | Gerencia a interação com o usuário (menus, mensagens, inputs)              |
| **utils**       | Funções auxiliares e utilitárias                                           |

---

## ⚙️ Tecnologias Utilizadas

- ☕ **Java 17+**
- 🧩 **Maven**
- 🗄️ **MySQL / JDBC**
- 🧱 **Arquitetura MVC**
- 🔄 **DAO Pattern**
- 🧰 **POO (Programação Orientada a Objetos)**

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seuusuario/SistemaManutencaoIndustrial.git
   ```

2. **Abra o projeto no IntelliJ IDEA ou Eclipse**

3. **Configure o banco de dados**
   - Crie o banco `manutencao_industrial` no MySQL
   - Ajuste as credenciais em `connection/Conexao.java`

4. **Execute a aplicação**
   - Localize a classe:  
     `src/main/java/weg/manutencaoIndustrial/app/Main.java`
   - Rode o método `main()`

5. O sistema será iniciado via terminal com menus interativos.

---

## 🧑‍💻 Desenvolvido por

**Lorhan Pierre de Melo**  
💼 Desenvolvedor Java / Back-end  
📧 lorhan_p_melo@estudante.sesisenai.org.br  
🌐 [linkedin.com/in/lorhan-pierre(#)](https://www.linkedin.com/in/lorhan-pierre/)

---

## 📄 Licença

Este projeto é distribuído sob a licença **MIT**.  
Você pode utilizá-lo, modificá-lo e redistribuí-lo livremente.

---


