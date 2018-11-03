package PhoneBook;

public class Conference {
    private int Time;
    User[] users;
    String description;

    public void setTime(int hour, int minute, int seconds) {
        Time = (hour * 60 * 60) + (minute * 60) + seconds;
    }

    public void setTime(int minute, int seconds) {
        Time = (minute * 60) + seconds;
    }

    public void setTime(int seconds) {
        Time = seconds;
    }

    public int getTime() {
        return Time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
