package miniproject.javafiles;

public class BlockMap {
    private final int M=5,N=5;
    final String []streets={"Cama Road","Patel Road","Gilbert Hill Road","Juhu Lane","CHS Lane","Kripa Lane","Irla Road","Dhobi Ghat Road","Dadabhai Road","Lajpatrai Road","Sarojini Road","Church Road","VP Road","St. Braz Road","Kutir Road","Janki Lane","Birla Road","Tukaram Road","Saibaba Road","Dattataray Road","Bhargav Road","Patil Road","Talmaki Road","Tilak Road","Chapel Lane"};
    BlockInfo[][] b = new BlockInfo[M][N];

    void createMap(){
        int a=0;
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                b[i][j]= new BlockInfo(i,j,streets[a++]);
            }
        }
        /*for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                System.out.print(b[i][j].x+" "+b[i][j].y+b[i][j].name+"\t\t\t");
            }
            System.out.println();
        }*/
    }
    int getX(String street){
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if ((b[i][j].name).equals(street))
                    return i;

            }
        }return 0;
    }
    int getY(String street){
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (b[i][j].name.equals(street))
                    return j;
            }
        }return 0;
    }

}
