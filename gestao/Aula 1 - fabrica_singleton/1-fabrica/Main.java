/**
* Exercício sobre o padrão de projeto Fábrica
*/

/** IChannel */
interface IChannel {
	void connect();
}

class TCPChannel implements IChannel {

	@Override
	public void connect() {
		System.out.println("Conectando via TCP...");
	}

}

class UDPChannel implements IChannel {

	@Override
	public void connect() {
		System.out.println("Conectando via UDP...");
	}

}

class ChannelFactory {
	public static IChannel create(){
		return new UDPChannel();
	}
}

public class Main {

    void f() {
        IChannel c = ChannelFactory.create();
        c.connect();
    }

    void g() {
        IChannel c = ChannelFactory.create();
        c.connect();
    }

    void h() {
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