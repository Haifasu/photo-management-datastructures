public class Test {
    public static void main(String[] args) {
    
        PhotoManager manager = new PhotoManager();
        
        Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        manager.addPhoto(photo1);
        
        Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass, wind"));        
        manager.addPhoto(photo2);
        
        Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect, butterfly, flower, color"));
        manager.addPhoto(photo3);
        
        Album album1 = new Album("Album1", "bear", manager);
        Album album2 = new Album("Album2", "animal AND grass", manager);
        
        System.out.println("Get photo1 path and tags:");
        System.out.println("photo1 path: " + photo1.getPath());
        System.out.println("photo1 tags:");
        printTags(photo1.getTags());
        
        System.out.println("\nGet album2 name, condition, and photos:");
        System.out.println("album2 name: " + album2.getName());
        System.out.println("album2 condition: " + album2.getCondition());
        System.out.println("album2 photos:");
        printAlbumPhotos(album2.getPhotos());

        System.out.println("\nDelete the photo ’bear.jpg’:");
        manager.deletePhoto("bear.jpg");
        
        System.out.println("\nPhotos after deleting 'bear.jpg' from album2:");
        printAlbumPhotos(album2.getPhotos());
    }
    
    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<String>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (int i = 0; i < tagsArray.length; i++) {
            result.insert(tagsArray[i]);
        }
        return result;
    }
    
    private static void printTags(LinkedList<String> tags) {
        if (!tags.empty()) {
            tags.findFirst();
            for (int i = 0; i < tags.getSize(); i++) {
                System.out.println("- " + tags.retrieve());
                if (!tags.last()) {
                    tags.findNext();
                }
            }
        }
    }
    
    private static void printAlbumPhotos(LinkedList<Photo> photos) {
        if (!photos.empty()) {
            photos.findFirst();
            for (int i = 0; i < photos.getSize(); i++) {
                System.out.println("- " + photos.retrieve().getPath());
                if (!photos.last()) {
                    photos.findNext();
                }
            }
        } else {
            System.out.println("No photos match the condition.");
        }
    }
}
