package Project_LifeSimulator;


import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        Personaggio personaggio1 = new Personaggio();

        Scanner scanner = new Scanner(System.in);
        int eta;
        String risposta;











        System.out.println("Ciao!\n\nBenvenuto nel simulatore di vita.\nInserisci il nome del tuo personaggio: ");
        risposta = scanner.nextLine();
        personaggio1.setNome(risposta);
        System.out.println("Inserisci il cognome: ");
        risposta = scanner.nextLine();
        personaggio1.setCognome(risposta);
        System.out.println("Inserisci l'eta: ");
        eta = scanner.nextInt();
        personaggio1.setEta(eta);




    }

}

