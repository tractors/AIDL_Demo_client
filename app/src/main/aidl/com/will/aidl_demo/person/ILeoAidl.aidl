// ILeoAidl.aidl
package com.will.aidl_demo.person;

// Declare any non-default types here with import statements
import com.will.aidl_demo.person.Person;
interface ILeoAidl {
    void addPerson(in Person person);

    List<Person> getPersonList();
}
