public class Article {
    private String author, journal, title, volume, pages, doi, month, year, number;
    private String authorIEEE, authorACM, authorNJ;

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
//            System.out.println(author);
//            author = author.substring(0, author.indexOf("}"));

            journal = journal.substring(journal.indexOf("{") + 1);
//            journal = journal.substring(0, journal.indexOf("}"));

            title = title.substring(title.indexOf("{") + 1);
//            title = title.substring(0, title.indexOf("}"));

            volume = volume.substring(volume.indexOf("{") + 1);
//            volume = volume.substring(0, volume.indexOf("}"));

            pages = pages.substring(pages.indexOf("{") + 1);
//            pages = pages.substring(0, pages.indexOf("}"));

            doi = doi.substring(doi.indexOf("{") + 1);
//            doi = doi.substring(0, doi.indexOf("}"));

            month = month.substring(month.indexOf("{") + 1);
//            month = month.substring(0, month.indexOf("}"));

            year = year.substring(year.indexOf("{") + 1);
//            year = year.substring(0, year.indexOf("}"));

            number = number.substring(number.indexOf("{") + 1);
//            number = number.substring(0, number.indexOf("}"));

            authorIEEE = author.replace("and", ",");
            authorNJ = author.replace("and", "&");
            authorACM = author.substring(0, author.indexOf("and")) + "et al.";
        }
//        System.out.println(authorIEEE);
//
//        author={T. Jackson and A. H. Peterson and N. Wang
//                ,
//                journal={IEEE Transactions on Computer Science
//                        ,
//                        title={Detecting Security Vulnerabilities in Binary Code
//                                ,
//                                year={2017
//                                        ,
//                                        volume={QQ
//                                                ,
//                                                number={85
//                                                        ,
//                                                        pages={1-12
//                                                                ,
//                                                                keywords={Security attacks;Binary code processing;Security error detection;Deep machine learning;Static analysis
//                ,
//                doi={14.2408/TCS.2017.4746889
//        System.out.println(authorACM);
//        System.out.println(authorNJ);
    }

//    public String getAuthorIEEE(){
//        return authorIEEE;
//    }
//
//    public String getAuthorACM() {
//        return authorACM;
//    }
//
//    public String getAuthorNJ() {
//        return authorNJ;
//    }

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
