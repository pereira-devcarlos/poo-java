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

class GameFacade {
  private final SistemaDeGraficos sistemaDeGraficos;
  private final SistemaDeAudio sistemaDeAudio;
  private final SistemaDeSave sistemaDeSave;
  private final SistemaDeRede sistemaDeRede;

  public GameFacade() {
    this.sistemaDeGraficos = new SistemaDeGraficos();
    this.sistemaDeAudio = new SistemaDeAudio();
    this.sistemaDeSave = new SistemaDeSave();
    this.sistemaDeRede = new SistemaDeRede();
  }

  public void iniciarModoHistoria(){
    sistemaDeGraficos.inicializar();
    sistemaDeAudio.inicializar();
    sistemaDeSave.carregarProgresso();
    sistemaDeGraficos.carregarTexturas();
    sistemaDeAudio.tocarMusicaTema();
  }

  public void iniciarModoOnline(){
    sistemaDeGraficos.inicializar();
    sistemaDeAudio.inicializar();
    sistemaDeRede.conectarServidor();
    sistemaDeGraficos.carregarTexturas();
    sistemaDeAudio.tocarMusicaTema();
  }

  public void iniciarModoTreino(){
    sistemaDeGraficos.inicializar();
    sistemaDeAudio.inicializar();
    sistemaDeGraficos.carregarTexturas();
    sistemaDeAudio.tocarMusicaTema();
  }
}

public class Main {

  public static void main(String[] args) {
    GameFacade gf = new GameFacade();

    System.out.println("=== Modo História ===");
    gf.iniciarModoHistoria();

    System.out.println("\n=== Modo Online ===");
    gf.iniciarModoOnline();

    System.out.println("\n=== Modo Treino ===");
    gf.iniciarModoTreino();
  }

}
