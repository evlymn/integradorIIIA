package Medico;

import Medico.Medico;
import java.util.*;

public class ListaDeMedicos implements List<Medico> {

   static List<Medico> list = new ArrayList<>();

    public  List<Medico> getList() {
        return list;
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Medico> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return list.toArray(a);
    }

    @Override
    public boolean add(Medico Medico) {
        return list.add(Medico);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(list).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Medico> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Medico> c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public Medico get(int index) {
        return list.get(index);
    }

    @Override
    public Medico set(int index, Medico element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Medico element) {
        list.add(index, element);
    }

    @Override
    public Medico remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<Medico> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Medico> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Medico> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (Medico m : list) {
            builder.append(String.format("%s \n", m.toString()));
        }
        return builder.toString();
    }

    public List<Medico> find(String s) {
        List<Medico> pesquisa = new ArrayList<>();

        s = s.toLowerCase();
        for (Medico m : list) {
            if ((m.getCpf().toLowerCase().contains(s)) || (m.getEspecialidade().toLowerCase().contains(s)) || (m.getNome().toLowerCase().contains(s))) {
                pesquisa.add(m);
            }
        }

        return pesquisa;
    }
}
