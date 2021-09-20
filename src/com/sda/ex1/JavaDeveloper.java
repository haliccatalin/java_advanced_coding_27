package com.sda.ex1;

public class JavaDeveloper extends Developer {

    public JavaDeveloper () {
        super();  // apelam constructorul din clasa parinte
        System.out.println("Constructor: JavaDeveloper");
    }

    public void exists (boolean isFriday) {
        System.out.println("Is Friday today? " + isFriday);
    }

}
