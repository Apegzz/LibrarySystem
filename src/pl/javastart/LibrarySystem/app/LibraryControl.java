package pl.javastart.LibrarySystem.app;

import pl.javastart.LibrarySystem.model.Book;
import pl.javastart.LibrarySystem.model.Library;
import pl.javastart.LibrarySystem.io.DataReader;
import pl.javastart.LibrarySystem.model.Magazine;

public class LibraryControl {

    private final int ADD_BOOK = 1;
    private final int ADD_MAGAZINE = 2;
    private final int PRINT_BOOKS = 3;
    private final int PRINT_MAGAZINES = 4;
    private final int EXIT = 0;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int userOption;

        do {
            printOptions();
            userOption = dataReader.getInt();
            switch (userOption) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Brak opcji, wprowadź ponownie");
            }
        } while (userOption != EXIT);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {

        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(ADD_MAGAZINE + " - dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS + " - wyświetl dostępne książki");
        System.out.println(PRINT_MAGAZINES + " - wyświetl dostępne magazyny");
        System.out.println(EXIT + " - wyjście z programu");
    }
}
