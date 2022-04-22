package Consulta;

import Medico.Medico;

import java.util.*;

public class ListaDeConsultas implements List<Consulta> {


    static List<Consulta> list = new ArrayList<>();

    public List<Consulta> getList() {
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
    public Iterator<Consulta> iterator() {
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
    public boolean add(Consulta consulta) {
        return list.add(consulta);
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
    public boolean addAll(Collection<? extends Consulta> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Consulta> c) {
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
    public Consulta get(int index) {
        return list.get(index);
    }

    @Override
    public Consulta set(int index, Consulta element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Consulta element) {
        list.add(index, element);
    }

    @Override
    public Consulta remove(int index) {
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
    public ListIterator<Consulta> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Consulta> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Consulta> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Consulta c : list) {
            builder.append(String.format("%s \n", c.toString()));
        }
        return builder.toString();
    }


    public List<Consulta> find(String s) {
        List<Consulta> pesquisa = new ArrayList<>();
        s = s.toLowerCase();
        for (Consulta c : list) {
            if ((c.getMedico().getEspecialidade().toLowerCase().contains(s)) ||
                    (c.getMedico().getNome().toLowerCase().contains(s)) ||
                    (c.getPaciente().getNome().toLowerCase().contains(s)) ||
                    c.getPaciente().getCpf().contains(s)
                    || c.getDataConsultaFormatted().contains(s)) {
                pesquisa.add(c);
            }
        }

        return pesquisa;
    }

    public List<Consulta> findByDate(Date d) {
        List<Consulta> pesquisa = new ArrayList<>();
        for (Consulta c : list) {
            if (c.getDataConsulta() == d) {
                pesquisa.add(c);
            }
        }
        return pesquisa;
    }
}
