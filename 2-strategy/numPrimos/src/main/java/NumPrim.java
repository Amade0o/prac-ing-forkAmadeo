import java.util.ArrayList;

public class NumPrim implements interfazComportamiento{
    public NumPrim(){
        
    }

    @Override
    public ArrayList<Integer> generarListaPrimos(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(n == 0){
            return res;
        }else{
            int count = 0;
            int index = 2;
            while(count < n){
                if(esPrimo(index)){
                    count++;
                    res.add(index);
                }
                index++;
            }

            return res;
        }
    }


    private Boolean esPrimo(int n){
        for(int i = 2; i <= Math.sqrt(n);i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //
    }
}
