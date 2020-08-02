package training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static training.GuestListGeneratorFactory.Type.*;

public class Main {

    public static void main(String[] args) {

        List<Vote> voteList = new ArrayList<Vote>();

        voteList.add(new Vote(new Date(2020, 06,12, 7,55,9), "Tom", false));
        voteList.add(new Vote(new Date(2020, 06,18, 4,10,8), "TOM", true));
        voteList.add(new Vote(new Date(2020, 07,11, 12,22,22), "TOM", false));
        voteList.add(new Vote(new Date(2020, 07,11, 4,45,07), "Mike", true));
        voteList.add(new Vote(new Date(2020, 06,12, 7,15,59), "Chrissi", true));
        voteList.add(new Vote(new Date(2020, 07,15, 12,53,58), "ChriSSi", true));
        voteList.add(new Vote(new Date(2020, 06,30, 22,1,57), "Chrissi", true));
        voteList.add(new Vote(new Date(2020, 06,17, 11,9,41), "CHRISSI", false));
        voteList.add(new Vote(new Date(2020, 07,2, 15,21,43), "Elmar", false));
        voteList.add(new Vote(new Date(2020, 06,25, 3,45,04), "Adi", true));

        GuestListGeneratorFactory gF = ServiceLocator.getInstance().newGuestListGeneratorFactory();
        GuestListGenerator gLG = gF.createGuestListGenerator(SET, voteList);

        for (Vote v : gLG.generateGuestListWithLatestEntryAndVoteTrue()) {
            System.out.printf("%s %s %s\n", v.getDate(), v.getName(), v.isVote());
        }
    }
}
