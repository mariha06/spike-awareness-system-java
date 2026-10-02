// This class represents a single resource in the system
// It can be a PDF, video, or story (from resource library design)

public class Resource {

    // attributes describing a resource
    private String title;        // name of resource
    private String type;         // type (PDF, Video, Story)
    private String keyword;      // keyword for searching
    private String author;
    private String description;

    // Constructor to create a new resource object
    public Resource(String title, String type, String keyword, String author, String description) {

        this.title = title;
        this.type = type;
        this.keyword = keyword;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getType(){
        return type;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getAuthor(){
        return author;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setKeyword(String keyword){
        this.keyword = keyword;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // Display resource details
    public void displayResource() {
        System.out.println("--------------------------------------------");
        System.out.println("Title: "+ title);
        System.out.println("Type: " + type);
        System.out.println("Keyword: " + keyword);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("--------------------------------------------");
    }
}
