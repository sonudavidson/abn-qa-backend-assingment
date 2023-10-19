package com.abnamro.stubs;

import java.util.UUID;

public class Userbooks {
    private UUID userId;
    private Isbn[] collectionOfIsbns;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID newUserId) {
        this.userId = newUserId;
    }

    public Isbn[] getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setUserBooks(Isbn[] newCollectionOfIsbns) {
        this.collectionOfIsbns = newCollectionOfIsbns;
    }
    
    public Userbooks(UUID userId, Isbn[] collectionOfIsbns) {
        setUserId(userId);
        setUserBooks(collectionOfIsbns);    
    }
}


