package net.mindview.util;

import java.util.*;

/**
 * Created by searover on 4/3/16.
 */
public class Countries {
    public static final String[][] DATA = {
            {"ALGERIA","Algiers"}, {"ANGOLA","Luanda"},
            {"BENIN","Porto-Novo"},{"BOTSWANA","Gaberone"},
            {"ZAMBIA","Lusaka"},{"ZIMBABWE","Harare"},
            {"AFGHANISTAN","Kabul"},{"BAHRAIN","Manama"},
            {"AUSTRALIA","Canberra"},{"FIJI","Suva"}
    };

    // Using AbstractMap by implementing entrySet()
    private static class FlyweightMap extends AbstractMap<String,String>{

        private static class Entry implements Map.Entry<String,String>{
            int index;
            Entry(int index){
                this.index = index;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        // Use AbstractSet by implementing size() & iterator()
        static class EntrySet extends AbstractSet<Map.Entry<String,String>>{
            private int size;
            EntrySet(int size){
                if(size < 0)
                    this.size = 0;
                else if(size > DATA.length)
                    // Can't be any bigger than the array:
                    size = DATA.length;
                else
                    this.size = size;
            }

            @Override
            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String,String>>{
                // Only one Entry object per Iterator
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size -1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }
        }

        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

        // Create a partial map of 'size' countries:
        static Map<String,String> select(final int size){
            return new FlyweightMap(){
                @Override
                public Set<Map.Entry<String, String>> entrySet() {
                    return new EntrySet(size);
                }
            };
        }

        static Map<String,String> map = new FlyweightMap();

        public static Map<String,String> capitals(){
            return map;
        }

        public static Map<String,String> capitals(int size){
            return select(size);
        }

        static List<String> names = new ArrayList<>(map.keySet());

        public static List<String> names(){
            return names;
        }

        public static List<String> names(int size){
            return new ArrayList<>(select(size).keySet());
        }

        public static void main(String[] args) {
            System.out.println(capitals(5));
            System.out.println(names(5));
            System.out.println(new HashMap<>(capitals(3)));
            System.out.println(new LinkedHashMap<>(capitals(3)));
            System.out.println(new TreeMap<>(capitals(3)));
            System.out.println(new Hashtable<>(capitals(3)));
            System.out.println(new HashSet<>(names(6)));
            System.out.println(new LinkedHashSet<>(names(5)));
            System.out.println(new TreeSet<>(names(5)));
            System.out.println(new ArrayList<>(names(5)));
            System.out.println(new LinkedList<>(names(5)));
            System.out.println(capitals().get("BRAZIL"));
        }
    }
}
