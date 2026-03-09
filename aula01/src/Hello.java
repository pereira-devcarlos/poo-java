public class Hello {
    private String hello;

    // Builders
    public Hello (){}

    public Hello (String hello){
        this.hello = hello;
    }

    // Method toString
    @Override
    public String toString() {
        return hello;
    }

    // Getters and Setters
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
