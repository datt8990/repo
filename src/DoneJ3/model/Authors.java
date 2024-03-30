package DoneJ3.model;

public class Authors {

    public String auID;

    public String auName;

    public String auAddress;

    public String getAuID() {
        return auID;
    }

    public void setAuID(String auID) {
        this.auID = auID;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }

    public String getAuAddress() {
        return auAddress;
    }

    public void setAuAddress(String auAddress) {
        this.auAddress = auAddress;
    }

    public Authors(String auID, String auName, String auAddress) {
        this.auID = auID;
        this.auName = auName;
        this.auAddress = auAddress;
    }

    public Authors() {
    }

}
