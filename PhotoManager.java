
package com.mycompany.datastructuresprogect;


public class PhotoManager {
    
    LinkedList<Photo> photos;
    
    public PhotoManager() {
 photos = new LinkedList<>();
}
    

    
    public void addPhoto(Photo p){
        
        if (photos.empty() ){
            photos.insert(p);
            return;
        }
           photos.findFirst();
           
           do{
               if(photos.retrieve().getPath().equals(p.getPath()))
                   return;
               
               if (photos.last()) 
                  break;
               
               photos.findNext();
           }while(true);
           
           photos.insert(p);
        
    }
    
   
     public void deletePhoto(String path){
          if (photos.empty() )
              return;
          
          photos.findFirst();
           do{
               
               if(photos.retrieve().getPath().equals(path)){
                   photos.remove();
                   return;
               }
               if (photos.last()) break;
                photos.findNext();
           }while(true);
           
          
           
     }
     
     
    public LinkedList<Photo> getPhotos(){
        return photos;
    }
    
}
