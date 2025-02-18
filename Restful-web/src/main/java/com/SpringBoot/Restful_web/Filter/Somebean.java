package com.SpringBoot.Restful_web.Filter;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties("field1")

@JsonFilter("somebeanFilter")
public class Somebean {

    private String field1;
   // @JsonIgnore
    private String field2;
    private String field3;

    // Constructor
    public Somebean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // Getter and Setter for field1
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    // Getter and Setter for field2
    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    // Getter and Setter for field3
    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    // toString method
    @Override
    public String toString() {
        return "Somebean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
