# 🎧 Mesa de DJ em Java

-----

### Sobre o Projeto

Este é um projeto de aplicação de console em Java que simula uma mesa de DJ. A aplicação usa **multithreading** para reproduzir várias faixas de música (stems de áudio) simultaneamente. Cada faixa, como bateria, baixo ou vocal, é executada em uma **thread independente**.

O controle da "mesa" é feito via comandos de texto no console, permitindo ao "DJ" interagir com as faixas, ativando-as e desativando-as em tempo real, sem interromper o fluxo das demais.

-----

### 🚀 Tecnologias e Conceitos Aplicados

  * **Java Threads:** Cada faixa de áudio é uma thread individual, responsável por seu próprio ciclo de reprodução.
  * **Java Sound API:** Utilizada para carregar, reproduzir e controlar o volume dos arquivos de áudio no formato `.WAV`.
  * **Sincronização de Threads:** Uso de mecanismos como `synchronized` e `volatile` para garantir que o estado das faixas (como `play` ou `pause`) seja controlado de forma segura, evitando condições de corrida.
  * **Design de Software:** A lógica é dividida entre um `InstrumentController` (o "cérebro" da mesa de DJ) e as classes `Instrument` (as faixas de áudio), promovendo um código organizado e de fácil manutenção.

-----

### 🎶 Como Rodar o Projeto

O projeto foi empacotado em um arquivo `.jar` executável, que contém todas as classes compiladas e as faixas de áudio. Siga os passos abaixo para executá-lo.

#### Pré-requisitos

  * [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (versão 17 ou superior) instalado.

#### Executando a Aplicação

1.  Faça o download do arquivo `DJApp.jar` da pasta releases.
2.  Abra o terminal ou prompt de comando.
3.  Navegue até o diretório onde você salvou o arquivo `DJApp.jar`.
4.  Execute o seguinte comando:

<!-- end list -->

```bash
java -jar DJApp.jar
```

A aplicação será iniciada e o painel de controle da mesa de DJ aparecerá no console.

-----

### 🕹️ Comandos de DJ

A seguir estão os comandos que você pode usar para controlar as faixas de música. Digite um comando e pressione `Enter`.

  * `play <nome do instrumento>`: Inicia a reprodução de um instrumento.
      * Exemplo: `play bateria`
  * `pause <nome do instrumento>`: Pausa a reprodução de um instrumento.
      * Exemplo: `pause baixo`
  * `status`: Exibe o estado atual de todas as faixas (tocando ou pausada).
  * `stop all`: Para a reprodução de todas as faixas e encerra o programa.
  * `set bpm <nome do instrumento> <bpm>`: Ajusta o BPM de um instrumento (apenas se a lógica de BPM estiver implementada).
      * Exemplo: `set bpm bateria 90`

-----

### 📦 Estrutura do Projeto

A estrutura de diretórios do projeto é a seguinte:

```
.
├── music/
│   ├── bass.wav
│   ├── drums.wav
│   ├── melody.wav
│   └── vocal.wav
├── src/
│   ├── Instrument.java
│   └── InstrumentController.java
│   └── Main.java
│   └── StatusController.java
├── .gitignore
├── DJApp.jar
└── README.md
```

### Equipe

  * [vic-fmr](https://github.com/vic-fmr)
  * [camilamta275](https://github.com/camilamta275)
  * [Sun-cs-Sol](https://github.com/Sun-cs-Sol)
  * [renysoo](https://github.com/renysoo)
  * [lucxsz-web](https://github.com/lucxsz-web)


-----
