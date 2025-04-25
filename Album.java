public class Album {
    
    private String name;
    private String condition;
    private PhotoManager manager;
    private int nbComps; 
    
    public Album (String name, String condition, PhotoManager manager){
        this.name = name;
        this.condition = condition;
        this.manager = manager;
        this.nbComps = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCondition(){
        return condition;
    }
    
    public PhotoManager getManager(){
        return manager;
    }
    
    public int getNbComps(){
        return nbComps;
    }
    
    public LinkedList<Photo> getPhotos(){
        LinkedList<Photo> result = new LinkedList<Photo>();
        nbComps = 0;

        LinkedList<String> requiredTags = parseCondition(condition);
        LinkedList<Photo> allPhotos = manager.getPhotos();

        if (!allPhotos.empty()) {
            allPhotos.findFirst();
            for (int i = 0; i < allPhotos.getSize(); i++) {
                Photo photo = allPhotos.retrieve();
                LinkedList<String> photoTags = photo.getTags();
                boolean match = true;

                if (!requiredTags.empty()) {
                    requiredTags.findFirst();
                    for (int j = 0; j < requiredTags.getSize(); j++) {
                        String tag = requiredTags.retrieve();
                        boolean found = false;

                        if (!photoTags.empty()) {
                            photoTags.findFirst();
                            for (int k = 0; k < photoTags.getSize(); k++) {
                                nbComps++;
                                if (photoTags.retrieve().equals(tag)) {
                                    found = true;
                                    break;
                                }
                                photoTags.findNext();
                            }
                        }

                        if (!found) {
                            match = false;
                            break;
                        }

                        requiredTags.findNext();
                    }
                }

                if (match) {
                    result.findFirst(); // لازم نحدد موقع قبل الإدراج
                    result.insert(photo);
                }

                allPhotos.findNext();
            }
        }

        return result;
    }

    // دالة مساعدة لتحويل شرط إلى قائمة وسوم
    private LinkedList<String> parseCondition(String condition) {
        LinkedList<String> tagsList = new LinkedList<String>();
        if (condition == null || condition.trim().isEmpty()) {
            return tagsList;
        }

        String[] tagsArray = condition.split("\\s*AND\\s*");
        for (String tag : tagsArray) {
            tagsList.findFirst(); // لازم قبل كل insert
            tagsList.insert(tag.trim());
        }
        return tagsList;
    }
    
}
