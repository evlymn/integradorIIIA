package Paciente;

import Paciente.Paciente;

import java.util.*;

public class ListaDePacientes implements List<Paciente> {

   static List<Paciente> list = new ArrayList<>();

    public List<Paciente> getList() {
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
    public Iterator<Paciente> iterator() {
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
    public boolean add(Paciente Paciente) {
        return list.add(Paciente);
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
    public boolean addAll(Collection<? extends Paciente> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Paciente> c) {
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
    public Paciente get(int index) {
        return list.get(index);
    }

    @Override
    public Paciente set(int index, Paciente element) {
        return list.set(index,element);
    }

    @Override
    public void add(int index, Paciente element) {
        list.add(index,element);
    }

    @Override
    public Paciente remove(int index) {
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
    public ListIterator<Paciente> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Paciente> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Paciente> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex,toIndex);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (Paciente p : list) {
            builder.append(String.format("%s \n", p.toString()));
        }
        return builder.toString();
    }

    public List<Paciente> find(String s) {
        List<Paciente> pesquisa = new ArrayList<>();
        s = s.toLowerCase();
        for (Paciente p : list) {
            if ((p.getCpf().toLowerCase().contains(s)) || (p.getEndereco().toLowerCase().contains(s)) || (p.getNome().toLowerCase().contains(s))) {
                pesquisa.add(p);
            }
        }
        return pesquisa;
    }
}
