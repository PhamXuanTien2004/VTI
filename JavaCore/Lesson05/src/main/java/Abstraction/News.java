package Abstraction;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rates = new int[]{0, 0, 0}; // Tránh NullPointerException

    public News(String title, String publishDate, String author, String content) {
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public int[] getRates() {
        return rates;
    }

    public void setRates(int[] rates) {
        if (rates != null && rates.length > 0) {
            this.rates = rates;
        } else {
            System.out.println("Invalid rates array. It must have at least one value.");
        }
    }

    @Override
    public void display() {
        System.out.println("News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", averageRate=" + calculate() +
                '}');
    }

    @Override
    public float calculate() {
        if (rates == null || rates.length == 0) {
            System.out.println("No rates available to calculate.");
            return 0;
        }
        int sum = 0;
        for (int rate : rates) {
            sum += rate;
        }
        averageRate = (float) sum / rates.length;
        return averageRate;
    }
}
