public class Article {
    private String author, journal, title, volume, pages, doi, month, year, number;

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }

    public String getPages() {
        return pages;
    }

    public String getDoi() {
        return doi;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public Article(String author, String journal, String title, String volume, String pages, String doi, String month, String year, String number) {
        this.author = author;
        this.journal = journal;
        this.title = title;
        this.volume = volume;
        this.pages = pages;
        this.doi = doi;
        this.month = month;
        this.year = year;
        this.number = number;
    }


}
