
package com.mycompany.album;

import java.util.LinkedList;


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
        nbComps = 0; // نعيد العداد كل مرة يتم استدعاء الدالة

        // نحول شرط الألبوم إلى قائمة وسوم
        LinkedList<String> requiredTags = parseCondition(condition);

        for (Photo photo : manager.getPhotos()) {
            LinkedList<String> photoTags = photo.getTags();
            boolean match = true;

            for (String tag : requiredTags) {
                boolean found = false;
                for (String pt : photoTags) {
                    nbComps++; // نحسب المقارنة
                    if (pt.equals(tag)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    match = false;
                    break;
                }
            }

            if (match) {
                result.insert(photo); // أضف الصورة إذا حققت كل الوسوم
            }
        }

        return result;
    }

    // دالة مساعدة لتحويل شرط إلى قائمة وسوم
    private LinkedList<String> parseCondition(String condition) {
        LinkedList<String> tagsList = new LinkedList<String>();
        if (condition == null || condition.trim().isEmpty()) {
            return tagsList; // شرط فارغ، نعيد قائمة فارغة (تعني كل الصور)
        }

        String[] tagsArray = condition.split("\\s*AND\\s*");
        for (String tag : tagsArray) {
            tagsList.insert(tag.trim());
        }
        return tagsList;
    }
    
}
