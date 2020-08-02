package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void generateGLDistinctByUpperDateAndFilterByTrue() {

        Map<String, Wrapper> vote = new HashMap<>();

        guestList.sort((a, b) -> a.getDate() - b.getDate());

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
    }

    private class Wrapper {
        boolean vote;
        int date;

        public Wrapper(boolean vote, int date) {
            this.vote = vote;
            this.date = date;
        }
    }
}
