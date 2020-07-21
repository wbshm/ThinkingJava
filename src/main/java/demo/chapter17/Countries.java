package demo.chapter17;

import java.util.*;

/**
 * 享元模式： 每个Map.Entry对象只存储了它的索引，而不是实际的键和值。
 *
 * @ClassName Countries
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/11 21:19
 */
public class Countries {
    /**
     * 初始数据，各个国家名称，及其首都
     */
    public static final String[][] DATA = {
            {"andorra", "Andorra"},
            {"aus tiria", "Vienna"},
            {"albania", "Tirana"},
            {"ireland", "Dublin"},
            {"estonia", "Tallinn"},
            {"iceland", "Reykjavik"},
            {"belarus", "Minsk"},
            {"bulgaria", "Sofia"},
            {"Poland", "Warsaw"},
            {"bosnia", "Sarajevo"},
            {"belgium", "Brussels"},
            {"germany", "Berlin"},
            {"denmark", "Copenhagen"},
            {"russia", "Moscow"},
            {"france", "Paris"},
            {"finland", "Helsinki"},
            {"holand", "Ams teTchm"},
            {"czech", "Prague"},
            {"croatia", "Zagreb"},
            {"latvia", "Riga"},
            {"lithuania", "Vilnius"},
            {"liechtenstein", "Vaduz"},
            {"romania", "Bucharest"},
            {"macedonia", "Skopje"},
            {"luxembourg", "Luxembourg"},
            {"monaco", "Monaco"},
            {"moldova", "Chisinau"},
            {"norway", "Oslo"},
            {"portugal", "Lisbon"},
            {"Sweden", "Stockholm"},
            {"switzerland", "Bern"},
            {"Slovak", "Bratislava"},
            {"slovenia", "Ljubljana"},
            {"san marino", "San Marino"},
            {"Ukraine", "Kiev"},
            {"spain", "Madrid"},
            {"greece", "Athens"},
            {"hungary", "Budapest"},
            {"hungary", "Budapest"},
            {"italy", "Rome"},
            {"england", "London"},
            {"afghanistan", "Kabul"},
            {"arab", "Abu Dhabi"},
            {"oman", "Muscat"},
            {"azerbaijan", "Baku"},
            {"pakistan", "Islamabad"},
            {"palestine", "Jerusalem"},
            {"bahrain", "Manama"},
            {"bhutan", "Thimphu"},
            {"north-korea", "Pyongyang"},
            {"timor", "Dili"},
            {"Philippines", "Manila"},
            {"georgia", "rbilisi"},
            {"kazakhstan", "Astana"},
            {"korea", "seoul"},
            {"kirgizstan", "Bishkek"},
            {"cambodia", "Phnom Penh"},
            {"qatar", "Doha"},
            {"kuwait", "Kuwait"},
            {"laos", "Vientiane"},
            {"lebanon", "Beirut"},
            {"maldives", "Male"},
            {"malaysia", "Kuala Lumpur"},
            {"mongolia", "Elggydggmgj"},
            {"bangladesh", "Dhaka"},
            {"myanmar", "Yangon"},
            {"nepal", "Kathmandu"},
            {"japan", "Tokyo"},
            {"Cyprus", "Nicosia"},
            {"saudi-arabia", "Riyadh"},
            {"srilanka", "Colombo"},
            {"tajikistan", "Dushanbe"},
            {"thailand", "Bangkok"},
            {"turkey", "Ankara"},
            {"turkmenistan", "Ashgabat"},
            {"brunei", "Bandar Seri Begawan"},
            {"uzbekistan", "Tashkent"},
            {"Singapore", "Singapore"},
            {"syria", "Damascus"},
            {"armenia", "Yerevan"},
            {"yemen", "Sanaa"},
            {"iran", "Tehran"},
            {"iraq", "Baghdad"},
            {"israel", "Jerusalem"},
            {"india", "New Delhi"},
            {"indonesia", "Jakarta"},
            {"jordan", "Amman"},
            {"vietnam", "Hanoi"},
            {"china", "Beijing"},
            {"argentina", "Buenos Aires"},
            {"antigua-barbuda", "Saint John's"},
            {"barbados", "Bridgetown"},
            {"bolivia", "Sucre"},
            {"brazil", "Santiago"},
            {"dominica", "Roseau"},
            {"ecuador", "Quito"},
            {"cuba", "Havana"},
            {"Colombia", "Bogota"},
            {"grenada", "Saint George's"},
            {"guyana", "Georgetown"},
            {"Canada", "Ottawa"},
            {"peru", "Lima"},
            {"america", "Washington"},
            {"mexico", "Mexico City"},
            {"Surinam", "Paramaribo"},
            {"sain tT ucia", "Castries"},
            {"trinidad-and-tobago", "Port-of-Spain"},
            {"Uruguay", "Montevide"},
            {"Venezuela", "Caracas"},
            {"Jamaica", "Kingston"},
            {"chile", "Santiago"},
            {"bahamas", "Nassau"},
            {"Panama", "Panama"},
            {"algeria", "Algiers"},
            {"egypt", "Cairo"},
            {"ethiopia", "Addis Ababa"},
            {"angola", "Luanda"},
            {"benin", "Porto—Novo"},
            {"botswana", "Gaborone"},
            {"burkina-faso", "Ouagadougou"},
            {"burundi", "Bujumbura"},
            {"equatorial-guinea", "Malabo"},
            {"equatorial-guinea", "Malabo"}
    };

    /**
     * 把String[][] 封装到对象里
     */
    private static class FlyweightMap extends AbstractMap<String, String> {
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return ENTRIES;
        }

        /**
         * 设置元素对象为普通类型
         */
        private static class Entry implements Map.Entry<String, String> {
            int index;

            Entry(int index) {
                this.index = index;
            }

            public boolean equals(String o) {
                return DATA[index][0].equals(o);
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

        /**
         * 设置元素对象为set类型
         */
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            /**
             * 设置对象的子元素长度
             */
            private int size;

            public EntrySet(int size) {
                this.size = Math.min(size, DATA.length);
                this.size = Math.max(size, 0);
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }

            /**
             * 迭代，循环获取Entry元素
             */
            private class Iter implements Iterator<Map.Entry<String, String>> {
                /**
                 * 默认从-1，开始，自增后变为0。就可以取到list里的第一个元素。
                 */
                private final Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
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
        }

        private static final Set<Map.Entry<String, String>> ENTRIES = new EntrySet(DATA.length);
    }

    /**
     * 获取从0开始，到size-1为止的元素。
     *
     * @param size
     * @return
     */
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();


    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }


    public static void main(String[] args) {
        System.out.println(capitals(10));
        System.out.println(new HashMap<>(capitals(3)));
        System.out.println(new LinkedHashMap<>(capitals(3)));
        System.out.println(new TreeMap<>(capitals(3)));
        System.out.println(new Hashtable<>(capitals(3)));


        System.out.println(names(10));
        System.out.println(new HashSet<>(names(6)));
        System.out.println(new LinkedHashSet<>(names(6)));
        System.out.println(new TreeSet<>(names(6)));
        System.out.println(new ArrayList<>(names(6)));
        System.out.println(new LinkedList<>(names(6)));

        System.out.println(capitals().get("monaco"));
        System.out.println(names());


    }
}
