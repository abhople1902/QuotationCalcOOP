import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File filecheck;
        File f = new File("tier2.txt");
        File f1 = new File("Tier3.txt");
        File f2 = new File("database_tier1.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        BufferedReader in1 = new BufferedReader(new FileReader(f1));
        BufferedReader in2 = new BufferedReader(new FileReader(f2));
        String str;
        String cityName;
        String type;
        int tier;
        boolean check = false;
        boolean typecheck = false;
        boolean tier1 = false,tier2 = false,tier3 = false;
        double plotsize;
        int choice = 1;
        while(choice){
            System.out.println("Enter the city name");
            cityName = sc.next();
            System.out.println("Enter the plot size");
            plotsize = sc.nextDouble();
            System.out.println("Enter the type of house you want to build");
            type = sc.next();
            String str1[];
            String str2[];
            String str3[];
            String strfinal1[];
            String strfinal2[];
            String strfinal3[];
            while((str = in.readLine())!=null){
                str1 = str.split("    ");
                if(cityName.equals(str1[0])) {
                    check = true;
                    Strfinal1 = str.split("    ");
                    tier2 = true;
                    filecheck = f;
                }

            }
            while((str = in1.readLine())!= null){
                str2 = str.split("    ");
                if(cityName.equals(str2[0])) {
                    check = true;
                    Strfinal2 = str.split("    ");
                    tier3 = true;
                    filecheck = f1;
                }
                else{
                    check = false;
                }
            }

            while((str = in2.readLine())!=null){
                str3 = str.split("    ");
                if(cityName.equals(str3[0])) {
                    check = true;
                    Strfinal3 = str.split("    ");
                    tier1 = true;
                    filecheck = f2;

                }
                else{
                    check = false;
                }
            }
        }
        if(check == false){
            throw new CityNotFoundException(cityName);
        }

        if(type.equal("Duplex") || type.equals("Flat") || type.equals("Bunglow")){
            typecheck = true;
        }
        else{
            throw new HouseException(type);
        }

        if(tier1){
            tier = 1;
        } else if (tier2) {
            tier = 2;
        } else if (tier3) {
            tier = 3;
        }

        if(typecheck){
            if(type.equals("Duplex")){
                Duplex d = new Duplex(cityName,tier,plotsize,filecheck);
                d.getInfo();
                d.calculatecosts();
            } else if (type.equals("Flat")) {
                Flat fl = new Flat(tier,cityName,plotsize);
            } else if (type.equals("Bunglow")) {
                bunglow b = new bunglow(type,cityName,plotsize)
            } else if (type.equals("FarmHouse")) {
                FarmHouse fm = new FarmHouse(1,plotsize,cityName);
            }
        }



    }
}