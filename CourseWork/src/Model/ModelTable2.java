package Model;

public class ModelTable2 {
    String ID;
    String Name;
    String DOB;

    public ModelTable2(String ID, String Name, String DOB) {
        this.ID = ID;
        this.Name = Name;
        this.DOB = DOB;
    }

    public String getID() {

        return ID;
    }

    public void setID(String ID) {

        this.ID = ID;
    }

    public String getName() {

        return Name;
    }

    public void setName(String Name) {

        this.Name = Name;
    }

    public String getDOB() {

        return DOB;
    }

    public void setDOB(String DOB) {

        this.DOB = DOB;
    }


}
