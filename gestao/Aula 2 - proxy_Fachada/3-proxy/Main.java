import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
* Exercício sobre o padrão de projeto Proxy
*/

class Book {
    String nome;

    public Book(String nome) {
        this.nome = nome;
    }
}

interface BookSearchInterface {
    Book getBook(String ISBN);
}

class BookSearch implements BookSearchInterface {

    public Book getBook(String ISBN) {
        System.out.println("Pesquisando no objeto base - ISBN " + ISBN);
        switch (ISBN) {
            case "1":
                return new Book("ESM");
            case "2":
                return new Book("POO");
            case "3":
                return new Book("BD");
            case "4":
                return new Book("SO");
            case "5":
                return new Book("Compiladores");
            case "6":
                return new Book("Redes");
            case "7":
                return new Book("IA");
            case "8":
                return new Book("Sistemas Distribuídos");
            case "9":
                return new Book("Sistemas Embarcados");
            case "10":
                return new Book("Sistemas de Informação");
            default:
                return null;
        }
    }

}

class BookSearchProxy implements BookSearchInterface {

    private BookSearch base;

    BookSearchProxy(BookSearch base) {
        this.base = base;
    }

    public Book getBook(String ISBN) {
        Book book;
        System.out.println("Entrando no proxy - ISBN: " + ISBN);

        // A ideia aqui é que o Proxy conhece o livro que tem ISBN 1
        // Logo, ele nem precisa fazer a consulta ao objeto base
        switch (ISBN) {
            case "1":
                System.out.println("Livro achado no proxy - ISBN: " + ISBN);
                return new Book("ESM");
            case "2":
                System.out.println("Livro achado no proxy - ISBN: " + ISBN);
                return new Book("POO");
            case "3":
                System.out.println("Livro achado no proxy - ISBN: " + ISBN);
                return new Book("BD");
            default:
                System.out.println("Livro não achado no proxy, repassando chamada para objeto base - ISBN: " + ISBN);
                book = base.getBook(ISBN);
        }
        System.out.println("Saindo do Proxy");
        return book;
    }

}

class BookSearchCacheProxy implements BookSearchInterface {

    private final BookSearchInterface base;
    private final Map<String, Book> cache = new HashMap<>();
    private final Map<String, Integer> freq = new HashMap<>();

    public BookSearchCacheProxy(BookSearchInterface base){
        this.base = base;
    }

    @Override
    public Book getBook(String ISBN) {
        Book book;
        System.out.println("Entrando no proxy cache - ISBN: " + ISBN);

        // Increment freq when search book
        freq.put(ISBN, 
            freq.getOrDefault(ISBN, 0) + 1
        );

        if (cache.containsKey(ISBN)) {
            System.out.println("Livro achado no proxy cache - ISBN: " + ISBN);
            return cache.get(ISBN);
        } 
        System.out.println("Livro não achado no proxy cache, repassando chamada para proxy - ISBN: " + ISBN);
        book = base.getBook(ISBN);

        if (cache.size() < 5 && book != null) {
            System.out.println("Livro acrescentado na cache - ISBN: " + ISBN);
            System.out.println("Frequência: " + freq.get(ISBN));
            cache.put(ISBN, book);
        }
        if (book != null) {
            String menorFreqIsbn = null;
            int menorFreq = Integer.MAX_VALUE;
            for (String cacheIsbn : cache.keySet()) {
                if (freq.get(cacheIsbn) < menorFreq) {
                    menorFreq = freq.get(cacheIsbn);
                    menorFreqIsbn = cacheIsbn;
                }
            }
            if (freq.get(ISBN) > menorFreq) {
                cache.remove(menorFreqIsbn);
                freq.remove(menorFreqIsbn);
                System.out.println("Livro acrescentado na cache - ISBN: " + ISBN);
                System.out.println("Frequência: " + freq.get(ISBN));
                cache.put(ISBN, book);
            }
        }

        return book; 
    }

    public Map<String, Integer> getFreq() {
        return freq;
    }
}

class Main {
    public static void main(String[] args) {
        BookSearch bs = new BookSearch();
        BookSearchProxy pbs = new BookSearchProxy(bs);
        BookSearchCacheProxy pcbs = new BookSearchCacheProxy(pbs);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("----------- Menu -----------\n");
            System.out.println("[1] - Adicionar livro");
            System.out.println("[2] - Listar Frequência de busca");
            System.out.print("Escolha uma opção ou 'sair' para encerrar: ");
            String isbn = scanner.nextLine();

            if (isbn.equals("2")) {
                System.out.println("Frequência de busca:");
                for (Map.Entry<String, Integer> entry : pcbs.getFreq().entrySet()) {
                    System.out.println("ISBN: " + entry.getKey() + ", Frequência: " + entry.getValue());
                }
                System.out.println();
                continue;
            }
            else if (isbn.equals("1")) {
                System.out.print("Digite o ISBN do livro: ");
                isbn = scanner.nextLine();
                pcbs.getBook(isbn);
                System.out.println();
            } 
            else if (isbn.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa...");
                break;
            } 
            else {
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println();
            }
        }
        scanner.close();
    }
}
