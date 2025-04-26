public class PhotoManager {
    
    LinkedList<Photo> photos;

    
    public PhotoManager() {
 photos = new LinkedList<>();
}
    
    // Add photo
    public void addPhoto(Photo p)
    {
           if (! IsPhototAvailable(p.getPath(), photos) )     
               photos.insert(p);
    }
    
    private boolean IsPhototAvailable(String p, LinkedList<Photo> List)
    {
        if (List.empty()) 
           return false;

        List.findFirst();
        while ( !List.last())
        {
           if (List.retrieve().getPath().compareToIgnoreCase(p)== 0)
               return true;

           List.findNext();
        }

        if (List.retrieve().getPath().compareToIgnoreCase(p)== 0)
           return true;

        return false;
    }


    public void deletePhoto(String path)
    {
        if (! this.IsPhototAvailable(path, photos))
            return;
    
        if (! photos.empty())
         {
            boolean found = false;
        
            photos.findFirst();
            while (!found && !photos.last() )
            {
                Photo p = photos.retrieve();
                if (p.getPath().compareToIgnoreCase(path) == 0)
                {
                    found = true; 
                    photos.remove();
                }
                photos.findNext();
            }
            
            if (!found )
            {
                Photo p = photos.retrieve();
                if (p.getPath().compareToIgnoreCase(path) == 0)       
                {
                    found = true;
                    photos.remove();
                }
            }
        }
    }

     
    public LinkedList<Photo> getPhotos(){
        return photos;
    }  
}
