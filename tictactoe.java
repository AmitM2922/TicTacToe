import java.util.*;

public class tictactoe {
    static ArrayList<Integer> playerposition=new ArrayList<>();
    static ArrayList<Integer> cpuposition=new ArrayList<>();

    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name=sc.nextLine().toUpperCase();
        System.out.println(" *** Hello! "+name.toUpperCase()+" your game is started ***\n");
     // creating game board

     char game_board[][]={{' ','|',' ','|',' '},
                         {'-','+','-','+','-'},
                         {' ','|',' ','|',' '}
                        ,{'-','+','-','+','-'}
                        ,{' ','|',' ','|',' '}};

     //printing game board
        print_Game_Board(game_board);

    while(true)
    {
        // taking  position from user
        System.out.println("Enter your placement (1-9)\n");
        int position=sc.nextInt();
        while (playerposition.contains(position) ||cpuposition.contains(position))
        {
            System.out.println("Position taken ! Enter correct position : ");
            position=sc.nextInt();
        }
        // implements position
        switch_operation(position,game_board,name);
        print_Game_Board(game_board);

        // computer operation / Random
        Random rand=new Random();
        int cpu_position= rand.nextInt(9)+1;
        while (cpuposition.contains(cpu_position) ||playerposition.contains(cpu_position))
        {
            cpu_position= rand.nextInt(9)+1;
        }
        switch_operation(cpu_position,game_board,"Cpu");
        print_Game_Board(game_board);
        String result=check_winner(name);
        System.out.println(result);
    }
    }

    public static void print_Game_Board(char game_board[][])
    {
        for (int i=0;i<game_board.length;i++)
        {
            for(int j=0;j<game_board.length;j++)
            {
                System.out.print(game_board[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public static void switch_operation(int position,char[][] game_board,String name)
    {
        char symbol=' ';
        if (name.equals("Cpu"))
        {
            symbol='O';
            cpuposition.add(position);
        }
        else
        {
            symbol='X';
            playerposition.add(position);
        }
        switch (position)
        {
            case 1:
                game_board[0][0]=symbol;
                break;
            case 2:
                game_board[0][2]=symbol;;
                break;
            case 3:
                game_board[0][4]=symbol;;
                break;
            case 4:
                game_board[2][0]=symbol;;
                break;
            case 5:
                game_board[2][2]=symbol;;
                break;
            case 6:
                game_board[2][4]=symbol;;
                break;
            case 7:
                game_board[4][0]=symbol;;
                break;
            case 8:
                game_board[4][2]=symbol;;
                break;
            case 9:
                game_board[4][4]=symbol;;
                break;
            default:
                break;

        }
    }
    public static String check_winner(String name)
    {
        // winning condition
        List top_row= Arrays.asList(1,2,3);
        List middle_row=Arrays.asList(4,5,6);
        List bottom_row=Arrays.asList(7,8,9);
        List column1=Arrays.asList(1,4,7);
        List column2=Arrays.asList(2,5,8);
        List column3=Arrays.asList(3,6,9);
        List cross1=Arrays.asList(1,5,9);
        List cross2=Arrays.asList(7,5,3);

        List<List> winning=new ArrayList<List>();
        winning.add(top_row);
        winning.add(middle_row);
        winning.add(bottom_row);
        winning.add(column1);
        winning.add(column2);
        winning.add(column3);
        winning.add(cross1);
        winning.add(cross2);

        for (List l :winning)
        {
            if (playerposition.containsAll(l))
            {
                return "Congratulations !!! "+name+" YOU WON ";
            }
            else if (cpuposition.containsAll(l))
            {
                return "OOPS !!! YOU LOSS ";
            }
            else if (cpuposition.size()+playerposition.size()==9)
            {
                return " Game Tie ";
            }
        }
        return "";
    }
}
