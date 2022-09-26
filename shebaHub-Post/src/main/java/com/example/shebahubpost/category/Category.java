package com.example.shebahubpost.category;

public enum Category {
    BIOLOGY,
    CHEMISTRY,
    PHYSICS,
    MATHS,
    NUMBER_THEORY,
    COMPLEX_NUMBER,
    SEQUENCE,
    ALGEBRA;
    @Override
    public String toString() {
        return this.toString().toLowerCase();
    }
}
