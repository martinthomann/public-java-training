package training;

import java.util.List;

public interface GuestListGenerator {

    public List<Vote> getGuestList();

    public void setGuestList(List<Vote> guestList);

    public void generateGLDistinctByUpperDateAndFilterByTrue();

}

