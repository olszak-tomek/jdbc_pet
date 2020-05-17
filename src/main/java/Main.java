import model.Pet;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        PetDao dao = new PetDao();
        Scanner scanner = new Scanner(System.in);

        String komenda;

        do{
            // https://pl.spoj.com/
            System.out.println("Podaj komendę [add/list/delete/update/quit]");
            komenda = scanner.nextLine();

            if(komenda.equalsIgnoreCase("add")){
                addPets(dao, scanner);
            }else if(komenda.equalsIgnoreCase("list")){
                listPets(dao);
            }else if(komenda.equalsIgnoreCase("delete")){
                deletePets(dao, scanner);
            }else if(komenda.equalsIgnoreCase("update")){
                updatePets(dao, scanner);
            }

        } while (!komenda.equalsIgnoreCase("quit"));

    }

    private static void addPets(PetDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: IMIE PSA, WIEK PSA, NAZWISKO OWNERA, WAGA PSA, RASOWY?");
        String linia = scanner.nextLine();
        String[] slowa = linia.split(" ");

        Pet pet = Pet.builder()
                .name(slowa[0])
                .age(Integer.parseInt(slowa[1]))
                .ownerName(slowa[2])
                .weight(Double.parseDouble(slowa[3]))
                .pureRace(Boolean.parseBoolean(slowa[4]))
                .build();

        dao.addToDatabase(pet);
    }

    private static void listPets(PetDao dao) {
        System.out.println("Lista: ");

        dao.getAllPets().forEach(System.out::println);
    }

    private static void deletePets(PetDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        dao.deletePet(id);
    }

    private static void updatePets(PetDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: IMIE NAZWISKO WZROST WIEK ŻYWY");
        String linia = scanner.nextLine();
        String[] slowa = linia.split(" ");

        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        Pet pet = Pet.builder()
                .name(slowa[0])
                .age(Integer.parseInt(slowa[1]))
                .ownerName(slowa[2])
                .weight(Double.parseDouble(slowa[3]))
                .pureRace(Boolean.parseBoolean(slowa[4]))
                .id(id)
                .build();

        dao.updatePet(pet);


    }



}

