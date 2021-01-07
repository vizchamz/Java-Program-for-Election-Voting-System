package Model;

public class ModelTable1 {
    String indexIDNo, name, party;

    public ModelTable1(String indexIDNo, String name, String party) {
        this.indexIDNo = indexIDNo;
        this.name = name;
        this.party = party;
    }

    public String getIndexIDNo() {

        return indexIDNo;
    }

    public void setIndexIDNo(String indexIDNo) {

        this.indexIDNo = indexIDNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getParty() {

        return party;
    }

    public void setParty(String party) {

        this.party = party;
    }


}
