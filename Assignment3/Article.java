/*
 * Nigel Yong Sao Young, 40089856
 * COMP249
 * Assignment 3
 * Due 21/03/19
 *
 */

/**
 * Class article storing data on article in which author is found
 */
public class Article {
    private String author, journal, title, volume, pages, doi, month, year, number;
    private String authorIEEE, authorACM, authorNJ;

    /**
     * get author's name
     * @return author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * get journal name
     * @return journal
     */
    public String getJournal() {
        return journal;
    }

    /**
     * get title name
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * get volume
     * @return volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * get pages
     * @return book pages
     */
    public String getPages() {
        return pages;
    }

    /**
     * get DOI
     * @return DOI
     */
    public String getDoi() {
        return doi;
    }

    /**
     * get month
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * get year
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * get number
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * constructor of the Article class
     * @param myAuthor stores author
     * @param myJournal stores journal
     * @param myTitle stores title
     * @param myVolume stores volume
     * @param myPages stores pages
     * @param myDoi stores doi
     * @param myMonth stores month
     * @param myYear stores year
     * @param myNumber stores number
     */
    public Article(String myAuthor, String myJournal, String myTitle, String myVolume, String myPages, String myDoi, String myMonth, String myYear, String myNumber) {
        this.author = myAuthor;
        this.journal = myJournal;
        this.title = myTitle;
        this.volume = myVolume;
        this.pages = myPages;
        this.doi = myDoi;
        this.month = myMonth;
        this.year = myYear;
        this.number = myNumber;

        if (!author.equals("")) {
            author = author.substring(author.indexOf("author={") + 8);

            journal = journal.substring(journal.indexOf("{") + 1);

            title = title.substring(title.indexOf("{") + 1);

            volume = volume.substring(volume.indexOf("{") + 1);

            pages = pages.substring(pages.indexOf("{") + 1);

            doi = doi.substring(doi.indexOf("{") + 1);

            month = month.substring(month.indexOf("{") + 1);

            year = year.substring(year.indexOf("{") + 1);

            number = number.substring(number.indexOf("{") + 1);

            authorIEEE = author.replace(" and", ",");
            authorNJ = author.replace("and", "&");
            authorACM = author.substring(0, author.indexOf("and")) + "et al.";
        }
    }

   public String toStringIEEE() {
       // NAME, NAME, NAME, NAME. “TITLE”, JOURNAL, vol. VOLUME, no. NUMBER, p. PAGES, MONTH YEAR.
        return authorIEEE+" \""+title+"\""+","+" "+journal+", "+volume+", no. "+number+", p. "+pages+", "+month+" "+year+".";
    }

    public String toStringACM() {
        // NAME et al. YEAR. TITLE. JOURNAL. PP, NUMBER (YEAR), PAGES. DOI:https://doi.org/DOI.
        return authorACM+" "+year+". "+title+". "+journal+". "+volume+", "+number+" ("+year+")"+", "+pages+". DOI:https://doi.org/"+doi;
    }

    public String toStringNJ() {
        // NAME & NAME & NAME & NAME. TITLE. JOURNAL. PP, PAGES(YEAR).
        return authorNJ+". "+title+". "+journal+". "+volume+", "+pages+"("+year+")";
    }
}
