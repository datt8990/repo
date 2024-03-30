package DoneJ3.model;

public class Books {

    private String bookID;

    private String title;

    private String pubName;

    private String auName;

    private String note;

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getAuName() {
        return auName;
    }

    public void setAuName(String auName) {
        this.auName = auName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Books(String bookID, String title, String pubName, String auName, String note, String user) {
        this.bookID = bookID;
        this.title = title;
        this.pubName = pubName;
        this.auName = auName;
        this.note = note;
        this.user = user;

    }

    public Books() {
    }

    public Object[] toRowTable() {
        return new Object[]{bookID, title, pubName, auName, note};
    }

}
