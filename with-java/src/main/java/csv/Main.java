package csv;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        var users = new UserCsvReader().readUserCsv("users.csv");
        // TODO Q2.1

        //1
        List<User> list = users.stream()
                            .filter(code -> {
                                if(code.getCode().startsWith("m")){
                                    return true;
                                }
                                return false;
                            })
                            .collect(Collectors.toList());

        List<String> list2 = list.stream()
                            .map(name -> name.getName().toLowerCase())
                            .collect(Collectors.toList());

        list2.stream()
                .forEach((name) -> System.out.println(name));


    }
}
