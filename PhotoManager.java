
package com.mycompany.datastructuresprogect;


public class PhotoManager {
    
    LinkedList<Photo> photos;
    
    public PhotoManager() {
 photos = new LinkedList<Photo>();
}
    

    public LinkedList<Photo> getPhotos(){
        return photos;
    }
    
    
    public void addPhoto(Photo p){
        if (photos.empty() ){
            photos.insert(p);
            return;
        }
           photos.findFirst();
           while( !photos.last() ){
               if(photos.retrieve().getPath().equals(p.getPath()))
                   return;
               photos.findNext();
           }
           if(photos.retrieve().getPath().equals(p.getPath()))
                   return;
           photos.insert(p);
        
    }
    
   
     public void deletePhoto(String path){
          if (photos.empty() )
              return;
          
          photos.findFirst();
           while( !photos.last() ){
               
               if(photos.retrieve().getPath().equals(path)){
                   photos.remove();
                   return;
               }
                photos.findNext();
           }
           if(photos.retrieve().getPath().equals(path))
                   photos.remove();
           
     }
}
