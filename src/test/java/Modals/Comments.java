package Modals;

public class Comments {

    private int id;
    private int userId;
    private String name;
    private String email;
    private String body;

    public Comments(int id, int userId, String name, String email, String body) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
