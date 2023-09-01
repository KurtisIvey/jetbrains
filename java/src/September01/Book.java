package September01;

public class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setYearOfPublishing(int year) {
        this.yearOfPublishing = year;
    }

    public String[] getAuthors() {
        // use clone method to not expose internal array. Was getting error message
        return this.authors.clone();
    }
    // set if to not set if null. Must use clone as well to not expose internal array
    public void setAuthors(String[] authors) {
        if (authors != null) {
            this.authors = authors.clone();
        }
    }
}
