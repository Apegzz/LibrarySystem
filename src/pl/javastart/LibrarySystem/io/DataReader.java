package pl.javastart.LibrarySystem.io;

import pl.javastart.LibrarySystem.model.Book;
import pl.javastart.LibrarySystem.model.Magazine;

import java.util.Scanner;

public class DataReader {

    private Scanner sc = new Scanner(System.in);

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public void close() {
        sc.close();
    }


    public Book readAndCreateBook() {
        System.out.println("Tytuł");
        String title = sc.nextLine();
        System.out.println("Autor");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo");
        String publisher = sc.nextLine();
        System.out.println("ISBN");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania:");
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Ilość stron");
        int pages = sc.nextInt();
        sc.nextLine();
        return new Book(title, author, releaseDate, pages, publisher, isbn);

    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = getInt();
        System.out.println("Miesiąc: ");
        int month = getInt();
        System.out.println("Dzień: ");
        int day = getInt();

        return new Magazine(title, publisher, day, month, year, language );

    }


}
