Entendi, então a aplicação Java não terá endpoints de API. Vou ajustar a documentação para refletir isso.

# Arduino LED Control System

Este repositório contém uma aplicação que configura um Arduino para controlar um LED com base na detecção de movimento. O LED acende ao detectar movimento próximo e diminui gradualmente quando não há movimento, até uma porcentagem definida pelo usuário. A definição dessa porcentagem é feita em uma aplicação Java, com os dados sendo armazenados em um banco de dados MSSQL, em um contêiner Docker.

## Estrutura do Projeto

- **Arduino**: Implementa o controle do LED com base na entrada de um sensor de movimento. O código Arduino é responsável por acender o LED quando há movimento e diminuir seu brilho gradualmente quando não há movimento.
  
- **Java Application**: Implementa a interface para definir a porcentagem mínima do brilho do LED quando não há movimento. A aplicação se comunica com o banco de dados MSSQL para armazenar e recuperar essas configurações.

- **MSSQL Database**: Armazena as configurações definidas pelo usuário para o brilho mínimo do LED. O banco de dados é containerizado usando Docker.

## Funcionalidades Principais

1. **Controle de LED**:
   - **Acender LED**: O LED acende quando o sensor detecta movimento.
   - **Diminuir Brilho**: O LED diminui gradualmente o brilho quando não há movimento, até a porcentagem definida pelo usuário.

2. **Configuração de Brilho**:
   - **Definir Porcentagem de Brilho**: Permite aos usuários definir a porcentagem mínima de brilho do LED quando não há movimento.
   - **Armazenar Configuração**: Armazena a configuração no banco de dados MSSQL.

## Como Executar o Projeto

1. **Configurar e Executar o MSSQL em um Contêiner Docker**:
   - Certifique-se de ter Docker instalado.
   - Navegue até o diretório do projeto e use o Docker Compose para iniciar o contêiner MSSQL:
     ```bash
     docker-compose up -d
     ```
   - O banco de dados estará disponível em [http://localhost:1433](http://localhost:1433).

2. **Configurar e Executar a Aplicação Java**:
   - Navegue até o diretório do projeto Java.
   - Compile e execute a aplicação Java:
     ```bash
     ./mvnw spring-boot:run
     ```
   - A aplicação Java estará disponível em [http://localhost:8080](http://localhost:8080).

3. **Carregar o Código no Arduino**:
   - Conecte o Arduino ao seu computador.
   - Abra o Arduino IDE e carregue os arquivos `main.cpp`, `LEDControl.cpp`, e `LEDControl.h` no Arduino.
   - Faça upload do código para o Arduino.

## Tecnologias Utilizadas

- **Arduino**: Microcontrolador usado para controlar o LED com base no sensor de movimento.
- **Java**: Linguagem de programação usada para a interface de configuração.
- **Spring Boot**: Framework Java utilizado para criar a aplicação de configuração.
- **MSSQL**: Banco de dados utilizado para armazenamento das configurações.
- **Docker**: Plataforma para containerização do banco de dados.

## Contribuição

Contribuições são bem-vindas! Para sugestões ou problemas encontrados, abra uma issue neste repositório.

---

Desenvolvido por [Sant-Thiago](https://github.com/Sant-Thiago/)
