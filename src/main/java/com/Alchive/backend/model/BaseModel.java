package com.Alchive.backend.model;

import java.time.LocalDateTime;

public abstract class BaseModel {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
