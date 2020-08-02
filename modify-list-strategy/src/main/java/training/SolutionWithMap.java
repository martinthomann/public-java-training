package training;

import java.util.*;

public class SolutionWithMap implements GuestListGenerator {

    private List<Vote> guestList;

    public List<Vote> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Vote> guestList) {
        this.guestList = guestList;
    }

    public SolutionWithMap(List<Vote> guestList) {
        this.guestList = guestList;
    }

    @Override
    public List<Vote> generateGuestListWithLatestEntryAndVoteTrue() {

        Map<String, Wrapper> vote = new HashMap<>();

        guestList.sort((a, b) -> a.getDate().compareTo(b.getDate()));

        for (Vote v : this.guestList) {
            vote.put(v.getName().toUpperCase(), new Wrapper(v.isVote(), v.getDate()));
        }

        List<Vote> l = new ArrayList<>();

        for (Map.Entry<String, Wrapper> m : vote.entrySet()) {
            if (m.getValue().vote) {
                l.add(new Vote(m.getValue().date, m.getKey(), m.getValue().vote));
            }
        }

        setGuestList(l);
        return l;
    }

    private class Wrapper {
        boolean vote;
        Date date;

        public Wrapper(boolean vote, Date date) {
            this.vote = vote;
            this.date = date;
        }
    }
}
