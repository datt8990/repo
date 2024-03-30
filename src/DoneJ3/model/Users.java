package DoneJ3.model;

public class Users {

    private String userName;
            
    private String displayName;

    private String passWord;

    private String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users(String userName, String displayName, String passWord, String description) {
        this.userName = userName;
        this.displayName = displayName;
        this.passWord = passWord;
        this.description = description;
    }

    public Users() {
    }

    
}
