package demo.chapter8;


import static net.mindview.util.Print.print;

class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        print("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        print("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
