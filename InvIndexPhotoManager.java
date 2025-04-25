package com.mycompany.invindexphotomanager;

import java.util.*;

public class InvIndexPhotoManager {

    private BST<LinkedList<String>> index;

    public InvIndexPhotoManager() {
        index = new BST<>();
    }

    // إضافة صورة إلى كلمة مفتاحية
    public void addPhoto(String keyword, String photoName) {
        if (index.findkey(keyword)) {
            // الكلمة موجودة، نضيف الصورة لقائمة الصور
            LinkedList<String> photos = index.retrieve();
            if (!photos.contains(photoName)) {
                photos.add(photoName);
            }
        } else {
            // الكلمة غير موجودة، ننشئ قائمة جديدة ونضيفها
            LinkedList<String> photos = new LinkedList<>();
            photos.add(photoName);
            index.insert(keyword, photos);
        }
    }

    // حذف صورة من كلمة مفتاحية
    public void removePhoto(String keyword, String photoName) {
        if (index.findkey(keyword)) {
            LinkedList<String> photos = index.retrieve();
            photos.remove(photoName);
            // إذا ما بقي صور، نحذف الكلمة المفتاحية من الشجرة
            if (photos.isEmpty()) {
                index.remove_key(keyword);
            }
        }
    }

    // استرجاع قائمة الصور المرتبطة بكلمة مفتاحية
    public List<String> getPhotos(String keyword) {
        if (index.findkey(keyword)) {
            return index.retrieve();
        }
        return new ArrayList<>(); // ترجع قائمة فاضية إذا ما لقاها
    }

    // طباعة كل الكلمات المفتاحية
    public void printAllKeywords() {
        System.out.println("All keywords in order:");
        System.out.println(index.inOrder());
    }
}
