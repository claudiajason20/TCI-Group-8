import java.util.Scanner;

public class CLI {
public static void main(String args[]){
    System.out.println("Your choice:");
    System.out.println("1.getall");
    System.out.println("2.getspec");
    System.out.println("3.getcrawldepth");
    System.out.println("4.exit");
    Scanner scanner=new Scanner(System.in);
    int i =scanner.nextInt();
    WCAController wcaController=new WCAController();
    WCAREST wcarest=new WCAREST(wcaController);
    do{
        String base=scanner.nextLine();
        String param=scanner.nextLine();
        wcarest.receive(i,base,param);

    }while(i!=4);

}
}
