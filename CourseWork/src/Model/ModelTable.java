package Model;

public class ModelTable {
    String indexIDNo, name, party, nationality, nicNo, address, contactNo, dob, gender;

    public ModelTable(String indexIDNo, String name, String party, String nationality, String nicNo, String address, String contactNo, String dob, String gender) {
        this.indexIDNo = indexIDNo;
        this.name = name;
        this.party = party;
        this.nationality = nationality;
        this.nicNo = nicNo;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
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

    public String getNationality() {

        return nationality;
    }

    public void setNationality(String nationality) {

        this.nationality = nationality;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getContactNo() {

        return contactNo;
    }

    public void setContactNo(String contactNo) {

        this.contactNo = contactNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
