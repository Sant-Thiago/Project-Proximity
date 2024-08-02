# Project Proximity

Este repositório contém uma aplicação Arduino para controlar um LED com base na detecção de movimento. O LED acende quando o sensor de movimento detecta presença e diminui gradualmente o brilho quando não há movimento, até um nível mínimo definido pelo usuário.

## Estrutura do Projeto

- **Arduino**: Implementa o controle do LED com base na entrada do sensor de movimento. O código Arduino é responsável por acender o LED quando há movimento e diminuir seu brilho gradualmente quando não há movimento.

## Arquivos do Projeto

- **`main.cpp`**: Código principal do Arduino que gerencia a lógica de controle do LED com base na detecção de movimento.
- **`LEDControl.cpp`**: Implementação das funções para controlar o brilho do LED.
- **`LEDControl.h`**: Cabeçalhos das funções de controle do LED utilizadas no `LEDControl.cpp`.

## Funcionalidades Principais

1. **Controle de LED**:
   - **Acender LED**: O LED acende quando o sensor detecta movimento.
   - **Diminuir Brilho**: O LED diminui gradualmente o brilho quando não há movimento, até o nível definido pelo usuário.

## Como Executar o Projeto

1. **Carregar o Código no Arduino**:
   - Conecte o Arduino ao seu computador.
   - Abra o Arduino IDE e carregue os arquivos `main.cpp`, `LEDControl.cpp`, e `LEDControl.h` no Arduino.
   - Faça upload do código para o Arduino.

## Tecnologias Utilizadas

- **Arduino**: Microcontrolador usado para controlar o LED com base no sensor de movimento.
- **C/C++**: Linguagens de programação utilizadas para escrever o código do Arduino.

## Contribuição

Contribuições são bem-vindas! Para sugestões ou problemas encontrados, abra uma issue neste repositório.

---

Desenvolvido por [Sant-Thiago](https://github.com/Sant-Thiago/)
