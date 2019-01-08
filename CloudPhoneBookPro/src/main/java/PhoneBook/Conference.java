package PhoneBook;

public class Conference {
    private int Time;
    private User[] users;
    private String description;

    public Conference(int Time, User[] users, String description) {
        this.Time = Time;
        this.users = users;
        this.description = description;
    }

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

    public String toCSV() {
        return Time + "," + getAllUsers() + "," + description;
    }

    private String getAllUsers() {
        StringBuilder sb = new StringBuilder();

        for (User user : users) {
            sb.append(user.toString());
            if (this.indexOf(user) != users.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private int indexOf(User user) {
        int index = 0;

        for (User _user : users) {
            if (_user.equals(user)) {
                break;
            }
            index++;
        }

        return index;
    }
}
