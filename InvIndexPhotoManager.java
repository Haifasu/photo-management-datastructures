package com.mycompany.datastructuresprogect;


public class InvIndexPhotoManager {
    
       
        BST<LinkedList<Photo>> invertedIndex;
        
        
    public InvIndexPhotoManager(){
        invertedIndex = new BST<LinkedList<Photo>>();
        
}
    public void addPhoto(Photo p){
        LinkedList<String> tags = p.getTags();
        LinkedList<Photo> Photos;

        if (tags.empty())
            return;
        
        tags.findFirst();
        
        while(! tags.last()){
            
            if( invertedIndex.findKey(tags.retrieve()) ){
                Photos = invertedIndex.retrieve();
            } else
                Photos = new LinkedList<>();
            
            Photos.insert(p);
            invertedIndex.insert(tags.retrieve(), Photos);
            tags.findNext();
            
        }
        if( invertedIndex.findKey(tags.retrieve()) ){
                Photos = invertedIndex.retrieve();
            } else
                Photos = new LinkedList<>();
            
            Photos.insert(p);
            invertedIndex.insert(tags.retrieve(), Photos);
            
    }
    
    public void deletePhoto(String path){
        String tags = invertedIndex.inOrder();
        if ( tags == null)
            return;
        
        String[] tagArray = tags.split(" ");
        int i = 0;
        while( i < tagArray.length ){
  
            if(invertedIndex.findKey(tagArray[i])){
                
            LinkedList<Photo> P = invertedIndex.retreive();
            
            if ( !P.empty() ) 
            P.findFirst();
            
            Photo current = P.retrieve();
            
            while(!P.last()){
              if(current.getPath().equals(path)) 
                  P.remove();
            else
                  P.findNext();
            
              
             if (P.empty()) 
                invertedIndex.remove_key(tagArray[i]);
            }
             
            
        
            i++;
            
    }}}
    
    public BST<LinkedList<Photo>> getPhotos(){
        return invertedIndex;
    }
}