package training;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SolutionWithSet implements GuestListGenerator {
    private List<Vote> guestList;

    public List<Vote> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Vote> guestList) {
        this.guestList = guestList;
    }

    public SolutionWithSet(List<Vote> guestList) {
        this.guestList = guestList;
    }

    public void generateGLDistinctByUpperDateAndFilterByTrue() {
        List<Vote> l = (List<Vote>) new ArrayList<Vote>(new TreeSet<Vote>(guestList
                .stream()
                .sorted((o1, o2) -> {
                    if (o2.getDate() > o1.getDate()) return 1;
                    else if (o2.getDate() < o1.getDate()) return -1;
                    else return 0;
                })
                .collect(Collectors.toCollection(
                        () -> new TreeSet<Vote>((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()))
                        )
                )))
                .stream()
                .filter(v -> v.isVote())
                .sorted((o1, o2) -> {
                    if (o2.getDate() > o1.getDate()) return 1;
                    else if (o2.getDate() < o1.getDate()) return -1;
                    else return 0;
                })
//                .sorted((a, b) -> {
//                    if ((a instanceof Vote) && (b instanceof Vote)) {
//                        return ((Vote) a).getName().compareTo(((Vote) b).getName());
//                    } else return 0;
//                })
                .collect(Collectors.toUnmodifiableList());
        setGuestList(l);
    }
}
