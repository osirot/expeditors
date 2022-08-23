import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Application {

    static Map<String, List<Person>> houseMap = new HashMap<>();

    public static void main(String[] args){
        File inFile = null;
            try{
                if (0 < args.length) {
                inFile = new File(args[0]);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
                    String line = bufferedReader.readLine();
                while(line != null) {

                    String[] lineVals = line.split("\",\"");
                    //System.out.println(Arrays.toString(lineVals));

                    //set address values -- all lowercase
                    String street = lineVals[2].toLowerCase();
                    street= removeSpecialChars(street);
                    String city = lineVals[3].toLowerCase();
                    String state = lineVals[4].toLowerCase();

                    String address = street + " " + city + " "+ state;

                    //set person values
                    Person p = new Person(lineVals[0].substring(1));//remove quotes
                    p.setLastName(lineVals[1]);
                    String age = lineVals[lineVals.length - 1].substring(0, lineVals[lineVals.length - 1].length()-1);
                    p.setAge(Integer.parseInt(age));

                    //add list of people along with household to map
                    List<Person> peopleInHouse;

                    if (houseMap.containsKey(address)) {
                        peopleInHouse = houseMap.get(address);
                    } else {
                        peopleInHouse = new ArrayList<>();
                    }
                    peopleInHouse.add(p);
                    houseMap.put(address, peopleInHouse);

                    line = bufferedReader.readLine();
                }

                //System.out.println(houseMap.toString());
                printHouseholdValues();

                //close reader
                bufferedReader.close();

                }else {
                    System.err.println("Text file path needed. Provided:" + args.length);
                    System.exit(1);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }


    }

    public static String removeSpecialChars(String s ){
        return s.replaceAll("[^a-zA-Z0-9\s]","").trim();
    }

    public static void sortByLastFirst(List<Person> list){
        list.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
    }

    public static void printPeopleOver18(List<Person> list, String address){
        for (Person person: list) {
            if(person.getAge() > 18){
                System.out.println(" - "+person.getFirstName()+" "+person.getLastName()+" "+ address+ " age "+ person.getAge());
            }
        }
    }

    public static void printHouseholdValues(){
        for(Map.Entry<String, List<Person>> entry: houseMap.entrySet()){
            System.out.println("____________________");
            System.out.println("Household: "+ entry.getKey() + " has "+ entry.getValue().size() + " occupants.");
            //sort by multiple cascading comparator.
            List<Person> list = entry.getValue();
            sortByLastFirst(list);
            printPeopleOver18(list, entry.getKey());
        }
    }

}
