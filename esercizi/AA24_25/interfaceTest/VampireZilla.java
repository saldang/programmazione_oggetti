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
