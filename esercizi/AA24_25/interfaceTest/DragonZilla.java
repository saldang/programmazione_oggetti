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
