package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        MartialArtist boxer = new Boxer("Balrog", 200, 1000);
        MartialArtist kungFu = new KungFuFighter("Chop Chop Master Onion", 800, 300);

        List<MartialArtist> martialArtists = new ArrayList<>();
        martialArtists.add(boxer);
        martialArtists.add(kungFu);

        for(MartialArtist martialArtist: martialArtists){
            martialArtist.getInfo();
            martialArtist.punchObject("Uks", 500);
            martialArtist.kickObject("Uks", 500);
            System.out.println();
        }
    }
}