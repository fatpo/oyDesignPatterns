package design.observer.v1;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();

        // 一直看孩子有没有哭，没哭就等着
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 哭了就给他吃
        System.out.println("day feed ...");
    }
}

class Child {
    private final boolean isCry = false;

    public boolean isCry() {
        return isCry;
    }
}
