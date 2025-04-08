package model;

public class Book {
    private String name;
    private String author;
    private String code;
    private int total;
    private String subject;

    // Constructor
    public Book(String name, String author, String code, int total, String subject) {
        this.name = name;
        this.author = author;
        this.code = code;
        this.total = total;
        this.subject = subject;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
