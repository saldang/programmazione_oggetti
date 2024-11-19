---
layout: page
title: Interfacce Java
permalink: /esercizi/AA24_25/JavaInterface/
---

## {{page.title}}

Esempio di utilizzo delle interfacce in Java.

```java
public class App {
    public static void main(String[] args) {
        DragonZilla d = new DragonZilla();
        VampireZilla v = new VampireZilla();

        d.shoted();
        v.shoted();
    }
}
interface Monster {
    Test life = new Test();

    void menace();

    void shoted();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class DragonZilla implements DangerousMonster, Lethal {

    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void kill() {

    }

    @Override
    public void shoted() {
        life.setI(3);
        System.out.println(life.i);
    }
}
public class Test {
    int i = 1;

    public void setI(int i) {
        this.i = i;
    }
}
public class VampireZilla implements Vampire {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public void kill() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'kill'");
    }

    @Override
    public void drinkBlood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drinkBlood'");
    }

    @Override
    public void menace() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menace'");
    }

    @Override
    public void shoted() {
        System.out.println(life.i);
        life.setI(5);
        System.out.println(life.i);

    }

}
```
