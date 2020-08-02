package training;

import java.util.List;
import java.util.stream.Collectors;

class SolutionWithFilter implements GuestListGenerator {

    private List<Vote> guestList;

    public List<Vote> getGuestList() {
        return this.guestList;
    }

    public void setGuestList(List<Vote> guestList) {
        this.guestList = guestList;
    }

    public SolutionWithFilter(List<Vote> guestList) {
        this.guestList = guestList;
    }

    public List<Vote> generateGuestListWithLatestEntryAndVoteTrue() {
        List<Vote> l = guestList
                .stream()
                .sorted((o1, o2) -> {
                    if (o2.getDate().after(o1.getDate())) return 1;
                    else if (o2.getDate().before(o1.getDate())) return -1;
                    else return 0;
                })
                .filter(v -> {
                    for (Vote vote : guestList) {
                        if (vote.getName().toUpperCase().equals(v.getName().toUpperCase()) &&
                                vote.getDate().after(v.getDate())) {
                            return false;
                        }
                    }
                    return true;
                })
                .filter(v -> v.isVote())

                .collect(Collectors.toList());
        setGuestList(l);
        return l;
    }
}
