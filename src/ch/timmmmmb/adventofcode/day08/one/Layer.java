package ch.timmmmmb.adventofcode.day08.one;

public class Layer {
    int[][] pixels;
    int height;
    int width;
    int currentX = 0;
    int currentY = 0;
    boolean full = false;

    public Layer(int height, int width) {
        pixels = new int[height][width];
        this.height = height;
        this.width = width;
    }

    public void addPixel(int pixel){
        if(full) return;
        pixels[currentY][currentX] = pixel;
        if(currentX==width-1){
            currentX = 0;
            if(currentY==height-1){
                full = true;
            }else{
                currentY++;
            }
        }else{
            currentX++;
        }
    }

    public int getAmount(int searchValue){
        int total = 0;
        for(int[] pixel:pixels){
            for(int p:pixel){
                if(p == searchValue){
                    total++;
                }
            }
        }
        return total;
    }
}
