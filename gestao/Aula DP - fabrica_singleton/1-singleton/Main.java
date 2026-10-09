/**
* Exercício sobre o padrão de projeto Singleton
*/

class Logger {

    private Logger(){}
    
    private static Logger instance;

    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void println(String msg) {
        // registra msg na console, mas poderia ser em um arquivo
        System.out.println(msg);
    }

}


class Main {
    
    void f() {
        Logger log = Logger.getInstance();
        log.println("Executando f " + log);
    }

    void g() {
        Logger log = Logger.getInstance();
        log.println("Executando g " + log);
    }

    void h() {
        Logger log = Logger.getInstance();
        log.println("Executando h " + log);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.f();
        m.g();
        m.h();
        System.out.println("Observe que as 3 chamadas executaram no mesmo objeto, com ID: " + Logger.getInstance());
    }

}
