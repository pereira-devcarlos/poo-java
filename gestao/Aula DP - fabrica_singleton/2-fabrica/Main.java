/**
* Exercício sobre o padrão de projeto Fábrica
*/

interface IInimigo {
    void spawnar();
}

class GoblinInimigo implements IInimigo {

    @Override
    public void spawnar() {
        System.out.println("Um Goblin surgiu no mapa!");
    }

}

class OrcInimigo implements IInimigo {

    @Override
    public void spawnar() {
        System.out.println("Um Orc surgiu no mapa!");
    }

}

class InimigoFactory {
    public static IInimigo create(){
        return new OrcInimigo();
    }
}

public class Main {

    void ondaTutorial() {
        IInimigo i = InimigoFactory.create();
        i.spawnar();
    }

    void ondaFase1() {
        IInimigo i = InimigoFactory.create();
        i.spawnar();
    }

    void arenaFinal() {
        IInimigo i = InimigoFactory.create();
        i.spawnar();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.ondaTutorial();
        m.ondaFase1();
        m.arenaFinal();
    }

}
