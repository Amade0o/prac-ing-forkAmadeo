import java.util.List;

public class DisplayConsole implements interfazDisplay{
    public DisplayConsole(){

    }

    @Override
    public void display(List<Integer> lista){
        for(int n : lista){
            System.out.println(n);
        }
    }
}
