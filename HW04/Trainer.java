public class Trainer {

    // instance variables
    private String trainerName;
    private int badges;
    private Techmon[] techmonTeam;


    // constructors
    public Trainer(String trainerName, int badges, Techmon[] techmonTeam) {
        this.trainerName = trainerName;
        this.badges = badges;
        this.techmonTeam = techmonTeam;
    }

    public Trainer(String trainerName) {
        this(trainerName, 0, new Techmon[] {null, null, null, null, null, null});
    }

    public Trainer() {
        this("George P. Burdell", 0, new Techmon[] {null, null, null, null, null, null});
    }

    // getter methods
    public String getTrainerName() {
        return trainerName;
    }
    public int getBadges() {
        return badges;
    }

    // setter methods
    public void setBadges(int badges) {
        if (badges < 0 || badges > 0) {
            this.badges = 0;
        }
    }

    // other methods
    public void addTechmon(Techmon techie) {
        for (int i = 0; i < techmonTeam.length; i++) {
            if (techmonTeam[i] == null) {
                techmonTeam[i] = techie;
                return;
            }
        }
        System.out.println("Cannot add " + techie.getName() + ", " + trainerName + "'s team is full!");
    }

    public int getTeamSize() {
        int teamCounter = 0;
        for (Techmon object : techmonTeam) {
            if (object != null) {
                teamCounter++;
            }
        }
        return teamCounter;
    }

    public void introduceTeam() {
        int count = 0;
        String teamNames = "";
        for (Techmon techie : techmonTeam) {
            if (techie != null) {
                teamNames += techie.getName() + ", ";
                count++;
            }
        }
        if (count != 0) {
            System.out.println(teamNames.substring(0, teamNames.length() - 2));
        }
    }

    public void playWithTechmon(Techmon techie) {
        if (techie == null) {
            return;
        }
        int newHappiness = (techie.getHappiness() + techie.getHappiness() / 2);
        techie.setHappiness(newHappiness);
        if (techie.getLevel() < badges * 10) {
            int newLevel = (techie.getLevel() + 1);
            techie.setLevel(newLevel);
        }
    }

    public void playWithTechmon(String techmonName) {
        for (Techmon techie : techmonTeam) {
            if (techie != null && techie.getName() == techmonName) {
                int newHappiness = (techie.getHappiness() + techie.getHappiness() / 2);
                techie.setHappiness(newHappiness);
                if (techie.getLevel() < badges * 10) {
                    int newLevel = (techie.getLevel() + 1);
                    techie.setLevel(newLevel);
                    return;
                }
                return;
            }
        }
        System.out.println(techmonName + " is not in " + trainerName + "'s team!");
    }

    public String toString() {
        this.setBadges(badges);
        if (badges == 8) {
            return "My name is " + trainerName + ", and I can now challenge the Techmon League with my team.";
        }
        return "My name is " + trainerName + ", and I still have to beat " + ((badges - 8) * -1) + " gyms.";
    }

    public static void main(String[] args) {

        Techmon[] techmonTeam = new Techmon[6];

        Techmon thisOne = new Techmon("Billy", 20, 10);
        Techmon anotherOne = new Techmon("Poke", 3);

        Trainer newAsh = new Trainer("Ash", 8, techmonTeam);
        Trainer newJon = new Trainer("Jon");

        newAsh.addTechmon(thisOne);
        newAsh.addTechmon(anotherOne);

        newAsh.playWithTechmon("Poke");

        System.out.println(anotherOne.getHappiness());
        System.out.println(anotherOne.getLevel());
        System.out.println(newJon.getTeamSize());
    }
}