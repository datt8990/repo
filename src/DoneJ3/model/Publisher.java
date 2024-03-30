package DoneJ3.model;

public class Publisher {

    private String pubID ;

    private String pubName;

    private String pubAddress;

    public String getPubID() {
        return pubID;
    }

    public void setPubID(String pubID) {
        this.pubID = pubID;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getPubAddress() {
        return pubAddress;
    }

    public void setPubAddress(String pubAddress) {
        this.pubAddress = pubAddress;
    }

    public Publisher(String pubID, String pubName, String pubAddress) {
        this.pubID = pubID;
        this.pubName = pubName;
        this.pubAddress = pubAddress;
    }

    public Publisher() {
    }

}
