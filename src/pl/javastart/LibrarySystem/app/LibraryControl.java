package pl.javastart.LibrarySystem.app;

import pl.javastart.LibrarySystem.model.Book;
import pl.javastart.LibrarySystem.model.Library;
import pl.javastart.LibrarySystem.io.DataReader;
import pl.javastart.LibrarySystem.model.Magazine;

public class LibraryControl {


    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        Option userOption;

        do {
            printOptions();
            userOption = Option.createFromInt(dataReader.getInt());
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
        } while (userOption != Option.EXIT);
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
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }
}
