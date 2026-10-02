// This class manages all resources
// It acts like a simple database for storing and retrieving content

public class ResourceLibrary {

    private Resource[] resources;
    private int resourceCount;

    public ResourceLibrary(){

        // max of 10 resources for this version
        resources = new Resource[10];
        resourceCount = 0;
    }

    // adds a resource to the library
    public void addResource(Resource resource) {

        if (resource == null) {
            System.out.println("Resource cannot be empty.");
            return;
        }

        if (resourceCount >= resources.length) {
            System.out.println("The resource library is full.");
            return;
        }

        resources[resourceCount] = resource;
        resourceCount++;
    }

    // display all resources in the system
    public void displayResources() {

        if (resourceCount == 0) {
            System.out.println("No resources available.");
            return;
        }

        System.out.println("\nAVAILABLE RESOURCES:");
        System.out.println("======================");

        for (int i = 0; i < resourceCount; i++) {
            System.out.println("Resource " + (i+1));
            resources[i].displayResource();
        }
    }

    // Searches for resources using keyword
    public void searchResource(String searchTerm) {

        if (searchTerm == null || searchTerm.trim().isEmpty()){

            System.out.println("Please enter a search term.");
            return;
        }

        boolean found = false;

        String search = searchTerm.toLowerCase();

        for (int i = 0; i < resourceCount; i++) {
            Resource resource = resources[i];

            if (resources[i].getTitle().toLowerCase().contains(search) ||
                    resource.getType().toLowerCase().contains(search) ||
                    resource.getKeyword().toLowerCase().contains(search) ||
                    resource.getAuthor().toLowerCase().contains(search)) {

                resource.displayResource();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching resource were found for: " + searchTerm);
        }
    }

    // Count the total resources
    public int getTotalResources() {
        return resourceCount;
    }

    // Count resources by type (PDF/Video/Story)
    public int countByType(String type) {

        int count = 0;

        for (int i = 0; i < resourceCount; i++) {

            if (resources[i].getType().equalsIgnoreCase(type)) {
                count++;
            }
        }

        return count;
    }

    // Update existing resource
    public boolean updateResource(int index, String title, String type, String keyword, String author, String description){

        if (index < 0 || index >= resourceCount){
            return false;
        }

        resources[index].setTitle(title);
        resources[index].setType(type);
        resources[index].setKeyword(keyword);
        resources[index].setAuthor(author);
        resources[index].setDescription(description);

        return true;
    }

    // deletes a resource
    public boolean deleteResource(int index){

        if (index < 0 || index >= resourceCount){
            return false;
        }

        for (int i = index; i<resourceCount -1; i++) {
            resources[i] = resources[i+1];
        }

        resources[resourceCount -1] = null;
        resourceCount--;

        return true;
    }
}


