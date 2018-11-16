package PhoneBook;

public class Call {
    private int Time;
    private User cgpn;
    private User cdpn;
    private String description;

    public Call(int Time, User cgpn, User cdpn, String description) {
        this.Time = Time;
        this.cgpn = cgpn;
        this.cdpn = cdpn;
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

    public void setDescription(String d) {
        this.description = d;
    }

    public String getDescription() {
        return description;
    }

    public void setCdpn(User cdpn) {
        this.cdpn = cdpn;
    }

    public void setCgpn(User cgpn) {
        this.cgpn = cgpn;
    }

    public User getCdpn() {
        return cdpn;
    }

    public User getCgpn() {
        return cgpn;
    }
}