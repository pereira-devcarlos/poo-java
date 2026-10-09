/**
* Exercício sobre o padrão de projeto Fábrica
*/

/**
 * IChannel
 */
interface IChannel {
	void connect();
}

class TCPChannel implements IChannel {

	@Override
	public void connect() {
		System.out.println("Conectando via TCP...");
	}

}

// TODO (3): crie aqui uma classe UDPChannel, também implementando IChannel,
// cujo método connect() imprima "Conectando via UDP..."
// (essa classe vai servir para você testar a troca de implementação no final)
class UDPChannel implements IChannel {

	@Override
	public void connect() {
		System.out.println("Conectando via UDP...");
	}

}

// TODO (4): crie aqui uma classe ChannelFactory com um método fábrica
// estático create(), que centralize a decisão de qual Channel instanciar.
// Ex.: public static Channel create() { ... return new TCPChannel(); }
class ChannelFactory {
	public static IChannel create(){
		return new UDPChannel();
	}
}

public class Main {

  void f() {
    // TODO (5): O que deve ser alterado aqui?
    IChannel c = ChannelFactory.create();
    c.connect();
  }

  void g() {
    // TODO (6): faça a mesma alteração da dica (5) aqui
    IChannel c = ChannelFactory.create();
    c.connect();
  }

  void h() {
    // TODO (7): faça a mesma alteração da dica (5) aqui
    IChannel c = ChannelFactory.create();
    c.connect();
  }

  public static void main(String[] args) {
     Main m = new Main();
     m.f();
     m.g();
     m.h();
  }

}

// TODO (8) [extra]: depois de terminar, altere apenas o método create() da
// ChannelFactory para retornar um UDPChannel em vez de um TCPChannel, e rode
// o programa novamente. Repare que nenhuma outra classe precisou ser alterada.
