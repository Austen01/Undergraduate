public class NQueen{

    /**
     * Solve the NQueen board
     * @param N the size of the board
     */
    public static void solve(int N) {
        ArraylistStack<Integer> s = new ArraylistStack<>();
        int  current = 0;
        while(!(current > N)){
            if(s.size() == N){
                break;
            }
            if(current == N){
                if((s.top() == N) && (s.size() == 1)){
                    break;
                }
                if(s.top() == N){
                    s.pop();
                    current = s.pop()+1;
                }
                else{
                    current = s.pop()+1;
                }
            }
            else if(!checkConflict(s, current)){
                s.push(current);
                current = 0;
            }
            else{
                current++;
            }
        }
        if(s.size() == N){
            printSolution(s);
        }

    }

    /**
     * Check if there is a conflict
     * @param s the stack with queen position
     * @param currentPosition 
     * @return if there is a conflict or not
     */
    public static boolean checkConflict(ArraylistStack<Integer> s, int currentPosition) {
        for (int i = 0; i < s.size(); i++) {
            if (s.top(i) == currentPosition){
                return true;
            }
            if ((s.top(i) - currentPosition) == (s.size() - i)){
                return true;   
            }
            if ((currentPosition - s.top(i)) == (s.size() - i)){
                return true;   
            }
        }
        return false;
    }
  

    /**
     * Print the solved board
     * @param s the arraylist stack
     */
    private static void printSolution(ArraylistStack<Integer> s) {
        for (int i = 0; i < s.size(); i ++) {
        for (int j = 0; j < s.size(); j ++) {
            if (j == s.top(i))
            System.out.print("Q ");
            else
            System.out.print("- ");
        }
        System.out.println();
        }
        System.out.println();  
    }


    public static void main(String[] args) {
        int N = 20;
        solve(N);
    }

}