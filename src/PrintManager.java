import java.util.*;


//    Employee,Manager,ItemsSold
//    Alice,,5
//    Bob,Alice,3
//    Carol,Bob,2
//    David,Bob,3
//    Eve,Alice,2
//    Ferris,Eve,1
//    要求打印出这个样子
//    Alice 16
//    Bob 8
//    Carol 2
//    David 3
//    Eve 3
//    Ferris 1
//    楼主先自己设计数据结构，和第一面那个基本一样，只是多了一个int num来记录数量，根据输入构建树，注意这里每条记录给定的顺序是随机的，所以可能先出来David,Bob,3然后才是Bob,Alice,3。不注意的话可能会有小bug报错。然后postorder算出所有node的child的数量和，然后update自己的，之后preorder打印。写的时候有个小bug，改正之后通过。follow up要求打印成这个样子
//
//    Alice 16
//            |-Bob 8
//            | |-Carol 2
//            | \_David 3
//            \_Eve 3
//            \_Ferris 1
public class PrintManager {
    static class Employee {
        String name;
        String manager;
        int sales;
        Employee(String name, String manager, int sales) {
            this.name = name;
            this.manager = manager;
            this.sales = sales;
        }
    }

    public static void addRecord(List<Employee> list) {
        Map<String, Integer> sales = new TreeMap<>();
        Map<String, String> manager = new HashMap<>();
        for (Employee employee : list) {
            sales.put(employee.name, sales.getOrDefault(employee.name, 0) + employee.sales);
            String name = employee.name;
            String boss = employee.manager;
            manager.put(name, boss);
            while (sales.containsKey(boss)) {
                sales.put(boss, sales.getOrDefault(boss, 0) + employee.sales);
                boss = manager.get(boss);
            }
        }

        for (String name : sales.keySet()) {
            if (manager.get(name).equals("")) {
                System.out.println(name + " " + sales.get(name));
            } else {
                System.out.println("|" + name +" " + sales.get(name));
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee a = new Employee("Alice", "", 5);
        Employee b = new Employee("Bob", "Alice", 6);
        Employee c = new Employee("Carol","Bob",2);
        Employee d = new Employee("David","Bob",3);
        Employee e = new Employee("Evis","Alice",3);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        addRecord(list);

        }
    }
