package com.etse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TransactionType {
    public enum Transaction_Type{
        INCOME,
        EXPENSE
    }

    @Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TransactionTypeConstraint{
        Transaction_Type[] value();
    }
}
