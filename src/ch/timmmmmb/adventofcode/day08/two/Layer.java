package ch.timmmmmb.adventofcode.day08.two;

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

    public void initializeEmpty(){
        for(int[] pixel:pixels){
            for(int i = 0; i<width; i++){
                pixel[i] = 2;
            }
        }
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

    public void addPixel(int pixel, int x, int y){
        if(pixels[y][x] == 2){
            pixels[y][x] = pixel;
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

    public void addLayer(Layer layer){
        for(int y = 0; y<layer.height; y++){
            for(int x = 0; x<layer.width; x++){
                this.addPixel(layer.pixels[y][x],x,y);
            }
        }

    }

    public void print(){
        for(int[] pixel:pixels){
            for(int p:pixel){
                if(p == 2 ){
                    System.out.print(" ");
                }if(p == 1){
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
