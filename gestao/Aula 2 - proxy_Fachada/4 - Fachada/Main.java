/**
* Exercício sobre o padrão de projeto Fachada
*/

class SistemaDeGraficos {
  void inicializar() {
    System.out.println("Inicializando sistema de gráficos...");
  }
  void carregarTexturas() {
    System.out.println("Carregando texturas do cenário...");
  }
}

class SistemaDeAudio {
  void inicializar() {
    System.out.println("Inicializando sistema de áudio...");
  }
  void tocarMusicaTema() {
    System.out.println("Tocando música tema...");
  }
}

class SistemaDeRede {
  void conectarServidor() {
    System.out.println("Conectando ao servidor de partidas...");
  }
}

class SistemaDeSave {
  void carregarProgresso() {
    System.out.println("Carregando progresso salvo...");
  }
}

public class Main {

  // Problema: para iniciar qualquer modo de jogo, é preciso conhecer os 4
  // subsistemas do motor (gráficos, áudio, rede, save) e coordená-los na
  // ordem correta. Essa coordenação está duplicada em cada método abaixo, e
  // qualquer mudança na forma de inicializar o motor (por exemplo, uma nova
  // etapa obrigatória) precisaria ser repetida em todos eles.

  void iniciarModoHistoria() {
    SistemaDeGraficos graficos = new SistemaDeGraficos();
    SistemaDeAudio audio = new SistemaDeAudio();
    SistemaDeSave save = new SistemaDeSave();

    graficos.inicializar();
    audio.inicializar();
    save.carregarProgresso();
    graficos.carregarTexturas();
    audio.tocarMusicaTema();
  }

  void iniciarModoOnline() {
    SistemaDeGraficos graficos = new SistemaDeGraficos();
    SistemaDeAudio audio = new SistemaDeAudio();
    SistemaDeRede rede = new SistemaDeRede();

    graficos.inicializar();
    audio.inicializar();
    rede.conectarServidor();
    graficos.carregarTexturas();
    audio.tocarMusicaTema();
  }

  void iniciarModoTreino() {
    SistemaDeGraficos graficos = new SistemaDeGraficos();
    SistemaDeAudio audio = new SistemaDeAudio();

    graficos.inicializar();
    audio.inicializar();
    graficos.carregarTexturas();
    audio.tocarMusicaTema();
  }

  public static void main(String[] args) {
    Main m = new Main();

    System.out.println("=== Modo História ===");
    m.iniciarModoHistoria();

    System.out.println("\n=== Modo Online ===");
    m.iniciarModoOnline();

    System.out.println("\n=== Modo Treino ===");
    m.iniciarModoTreino();
  }

}

// TODO (1): crie uma classe GameFacade que encapsule um atributo para cada
// um dos 4 subsistemas (SistemaDeGraficos, SistemaDeAudio, SistemaDeRede,
// SistemaDeSave), instanciando-os no construtor de GameFacade.
// TODO (2): mova para dentro de GameFacade três métodos públicos —
// iniciarModoHistoria(), iniciarModoOnline() e iniciarModoTreino() — com
// exatamente a mesma lógica de coordenação que hoje está duplicada em
// Main (recorte o corpo de cada método e cole em GameFacade, trocando as
// variáveis locais pelos atributos da fachada).
// TODO (3) em Main: apague os três métodos iniciarModoHistoria(),
// iniciarModoOnline() e iniciarModoTreino() — Main não deve mais conhecer
// SistemaDeGraficos, SistemaDeAudio, SistemaDeRede nem SistemaDeSave.
// TODO (4) no main(): crie um único objeto GameFacade e chame seus três
// métodos no lugar dos métodos que existiam em Main.
// TODO (5) [extra]: adicione a GameFacade um quarto método,
// iniciarModoEspectador() (pode reaproveitar a mesma lógica de
// iniciarModoTreino()), e chame-o também no main(). Repare que nenhuma
// outra classe precisou ser alterada para isso funcionar.
