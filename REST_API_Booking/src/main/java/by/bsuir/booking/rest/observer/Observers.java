package by.bsuir.booking.rest.observer;

import by.bsuir.booking.rest.model.Role;

import java.util.ArrayList;
import java.util.Iterator;

public class Observers<T extends Observer> extends ArrayList<T> {
    public void notifyObjectCreated(Role obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().setRoleByIdRole(obj);
    }
    public void notifyObjectModified(Role obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().setRoleByIdRole(obj);
    }
}