package constructor;

public class Group {
    String groupName;
    Account creator;
    Account[] accounts;
    String[] usernames;

    public Group() {};

    public Group(String groupName, Account creator, Account[] accounts) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
    }

    public Group(String groupName, Account creator, String[] usernames) {
        this.groupName = groupName;
        this.creator = creator;
        this.usernames = usernames;

    }
}
