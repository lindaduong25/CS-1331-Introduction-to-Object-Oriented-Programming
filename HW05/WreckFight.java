public class WreckFight {
    public static void main(String[] args) {
    
    Icemon edwardCullen = new Icemon("Edward Cullen", 101, 50, false, 0);
    Icemon dedric = new Icemon("Dedric Ciggory");

    Firemon stanLoona = new Firemon("Stan Loona", 16, 12, 45, 0);
    Firemon choCheng = new Firemon("Cho Cheng");

    System.out.println(edwardCullen);
    System.out.println(dedric);
    System.out.println(choCheng);
    System.out.println(stanLoona);

    edwardCullen.duel(choCheng);
    edwardCullen.potion();

    dedric.duel(stanLoona);

    System.out.println(edwardCullen);
    System.out.println(dedric);
    System.out.println(choCheng);
    System.out.println(stanLoona);

    System.out.println(edwardCullen.getIcePoints());
    System.out.println(dedric.getIcePoints());
    System.out.println(stanLoona.getFirePoints());
    System.out.println(choCheng.getFirePoints());

    int icemonPoints = edwardCullen.getIcePoints() + dedric.getIcePoints();
    int firemonPoints = choCheng.getFirePoints() + stanLoona.getFirePoints();

    if (firemonPoints > icemonPoints) {
        System.out.println("Icemon has " + icemonPoints + ", and Firemon has " + firemonPoints + ", which makes Firemon the winner of this year's Wreck Fight!");
        return;
    }
    System.out.println("Icemon has " + icemonPoints + ", and Firemon has " + firemonPoints + ", which makes Icemon the winner of this year's Wreck Fight!");

    }
}