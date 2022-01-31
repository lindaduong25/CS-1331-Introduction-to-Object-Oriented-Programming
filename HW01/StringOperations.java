public class StringOperations {
    public static void main(String[] args) {
        String name = "Linda";
        String replaceWithA = "A" + name.substring(1, 5);
        String replaceWithZ = replaceWithA.substring(0, 4) + "Z";
        String webAddress = "www.gatech.edu";
        String webName = webAddress.substring(4, 10);
        System.out.println(name);
        System.out.println(replaceWithZ);
        System.out.println(webAddress);
        System.out.println(webName.concat("1331"));

    }

}