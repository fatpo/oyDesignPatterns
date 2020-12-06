package design.builder.v1;

import lombok.Data;

public class Main {
    public static void main(String[] args) {

        // 告诉导购你要高端机器
        Director director = new Director(new HighComputer());
        director.makeComputer();
        System.out.println(director.getComputer());

        // 告诉导购你要低端机器
        Director director2 = new Director(new LowComputer());
        director2.makeComputer();
        System.out.println(director2.getComputer());
    }
}

class Director {
    private BuildComputer buildComputer;

    public Director(BuildComputer buildComputer) {
        this.buildComputer = buildComputer;
    }

    public void makeComputer() {
        this.buildComputer.buildCpu();
        this.buildComputer.buildDisplay();
        this.buildComputer.buildKeyboard();
        this.buildComputer.buildMemory();
    }

    public Computer getComputer() {
        return this.buildComputer.getComputer();
    }
}

@Data
class Computer {
    private String cpu;
    private String memory;
    private String display;
    private String keyboard;
}

abstract interface BuildComputer {
    abstract public void buildCpu();

    abstract public void buildMemory();

    abstract public void buildDisplay();

    abstract public void buildKeyboard();

    Computer getComputer();
}

class HighComputer implements BuildComputer {
    Computer computer;

    public HighComputer() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("I5");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("8G");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("三星");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("高端键盘");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}


class LowComputer implements BuildComputer {
    Computer computer;

    public LowComputer() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("I3");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("2G");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("杂牌显示器");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("免费键盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}