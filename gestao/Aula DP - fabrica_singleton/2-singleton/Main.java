/**
* Exercício sobre o padrão de projeto Singleton
*/

class GameLogger {
    private GameLogger (){}
    
    private static GameLogger instance;

    public static GameLogger getInstance(){
        if (instance == null) {
            instance = new GameLogger();
        }
        return instance;
    }

    public void registrar(String evento) {
        // registra o evento do jogo na console, mas poderia ser em um arquivo
        System.out.println(evento);
    }

}


class Main {

    void sistemaDeCombate() {
        GameLogger log = GameLogger.getInstance();
        log.registrar("[Combate] Jogador derrotou um Goblin " + log);
    }

    void sistemaDeConquistas() {
        GameLogger log = GameLogger.getInstance();
        log.registrar("[Conquistas] Jogador desbloqueou 'Primeiro Sangue' " + log);
    }

    void sistemaDeSave() {
        GameLogger log = GameLogger.getInstance();
        log.registrar("[Save] Progresso salvo " + log);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.sistemaDeCombate();
        m.sistemaDeConquistas();
        m.sistemaDeSave();
        System.out.println("Observe que os 3 subsistemas usaram o mesmo objeto, com ID: " + GameLogger.getInstance());
    }

}
