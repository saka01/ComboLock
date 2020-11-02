public class ComboLock {
   private int secret1;
   private int secret2;
   private int secret3;
   private boolean pos0 = true;
   private boolean pos1 = false;
   private boolean pos2 = false;
   private boolean pos3 = false;
   private int dial = 0;
   private boolean unlock = false;

   public ComboLock(int secret1, int secret2, int secret3){
       this.secret1 = secret1;
       this.secret2 = secret2;
       this.secret3 = secret3;
   }

   public void reset(){
    pos0 = true;
    pos1 = false;
    pos2 = false;
    pos3 = false;
   }

    public void turnLeft(int ticks) {
        if (pos1 == true) {
            dial = (dial + ticks) % 40;
            if (dial == secret2) {
                pos2 = true;
            } else {
                pos2 = false;

            }
        }
    }
    /**
     * Turns the dial towards right
     * @param ticks
     **/
    public void turnRight(int ticks) {
        if(pos0){
            dial = (40 - ticks);

            if (dial == secret1){
                pos1 = true;
                pos0 = false;
            }
        }else{
            if(dial - ticks > 0){
                pos3 = true;
            }else{

                dial = (40 - (ticks - dial));
                pos3 = false;

                if(dial == secret3){
                    pos3 = true;
                }
            }
        }
    }
   public boolean open(){
       if(pos1 && pos2 && pos3)
       {
           unlock = true;
       }
       else
       {
           unlock = false;
       }
       return unlock;
   }
   }



