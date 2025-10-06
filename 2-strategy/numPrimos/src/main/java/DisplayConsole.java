public class DisplayConsole implements interfazDisplay{
    public DisplayConsole(){

    }

    public void display(List<Integer> lista){
        for(int n : lista){
            System.out.println(n);
        }
    }
}
