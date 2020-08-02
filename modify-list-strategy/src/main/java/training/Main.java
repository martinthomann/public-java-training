package training;

import java.util.ArrayList;
import java.util.List;

import static training.GuestListGeneratorFactory.Type.MAP;

public class Main {

    public static void main(String[] args) {

        List<Vote> voteList = new ArrayList<Vote>();

        voteList.add(new Vote(3, "Tom", false));
        voteList.add(new Vote(7, "TOM", true));
        voteList.add(new Vote(13, "TOM", false));
        voteList.add(new Vote(23, "Mike", true));
        voteList.add(new Vote(9, "Chrissi", true));
        voteList.add(new Vote(12, "ChriSSi", true));
        voteList.add(new Vote(13, "Chrissi", true));
        voteList.add(new Vote(157, "CHRISSI", false));
        voteList.add(new Vote(87, "Elmar", false));
        voteList.add(new Vote(65, "Adi", true));

        GuestListGeneratorFactory gF = ServiceLocator.getInstance().newGuestListGeneratorFactory();
        GuestListGenerator gLG = gF.createGuestListGenerator(MAP, voteList);
        gLG.generateGLDistinctByUpperDateAndFilterByTrue();

        for (Vote v : gLG.getGuestList()) {
            System.out.printf("%d %s %s\n", v.getDate(), v.getName(), v.isVote());
        }
    }
}
