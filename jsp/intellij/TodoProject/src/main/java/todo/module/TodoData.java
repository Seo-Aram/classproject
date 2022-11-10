package todo.module;

public class TodoData {
    private String key;
    private String title;
    private String date;
    private boolean isCheck;

    private static int index = 0;

    public TodoData(String title, String date) {
        this.key = String.valueOf(index++) + System.currentTimeMillis();
        this.title = title;
        this.date = date;
        this.isCheck = false;

        index %= 10;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public boolean isCheck() {
        return isCheck;
    }

    @Override
    public String toString() {
        return "TodoData{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
