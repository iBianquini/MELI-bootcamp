package fundamentos.Aula2TM.src.main.java.domain;

public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public Counter(int value) {
        this.value = value;
    }

    public Counter(Counter counter) {
        this.value = counter.value;
    }

    public void increase(){
        this.value++;
    }

    public void increase(int value){
        this.value += value;
    }

    public void decrease(){
        this.value--;
    }

    public void decrease(int value){
        this.value -= value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "value=" + value +
                '}';
    }
}
