public class Gym {
    public static void main(String[] args) {

        // Trainer objects
        Trainer trainer = new Trainer();
        Trainer trainerBobby = new Trainer("Bobby Dodd");

        Techmon cmon = new Techmon("Cmon", 21, 10);
        Techmon[] cmonTeam = {cmon};
        Trainer trainerAsh = new Trainer("Ash", 8, cmonTeam);

        Techmon pythmon = new Techmon("Pythmon", 13, 1);
        Techmon rubymon = new Techmon("Rubymon", 100, 252);
        Techmon rustmon = new Techmon("Rustmon", 100, 252);
        Techmon[] pythmonRubymonRustmon = {pythmon, rubymon, rustmon};
        Trainer trainerGary = new Trainer("Gary", 8, pythmonRubymonRustmon);

        // Techmon objects
        Techmon techmon = new Techmon();
        Techmon techmonDataStruct = new Techmon("DataStruct", 13, 32);
        Techmon techmonAssembly = new Techmon("Assembly", 21);
        Techmon techmonJavamon = new Techmon("Javamon", 13, 31);

        // toString call
        System.out.println(trainer);
        System.out.println(trainerBobby);
        System.out.println(trainerAsh);
        System.out.println(trainerGary);

        // techmonPopulation
        System.out.println(Techmon.getTechmonPopulation());

        // testing cases
        trainerGary.playWithTechmon(pythmon);
        System.out.println(pythmon.getHappiness());
    }
}