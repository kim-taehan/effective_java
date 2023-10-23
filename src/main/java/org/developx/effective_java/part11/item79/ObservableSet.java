package org.developx.effective_java.part11.item79;

import org.developx.effective_java.part4.item18.ForwardingSet;

import java.util.*;

public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

//    private void notifyElementAdded(E element) {
//        synchronized (observers) {
//            for(SetObserver<E> observer : observers) {
//                observer.added(this, element);
//            }
//        }
//    }
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer : snapshot)
            observer.added(this, element);
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean result = false;
        for (Object element : c) {

            result |= add((E) element); //notifyElementAdded를 호출
        }
        return result;
    }
}