public class DataGeneratorInsurance {

    public static void main(String []args){
        
        String [] category = {"UnitedHealth","AetnaHealth", "Kaiser-Foundation"};

        String [] emailext = {"@unitedhealth.com", "@aetnahealth.com", "@kaiserfo.com" };

        String [] subcategory = {"Dental", "Vision", "Health", "Mental-Health", "Crtical-Illness"};

        for(int i = 0; i <= 2; i++){
            for (int j = 0 ; j <= 4; j++){
                int year = (int)(Math.random() * (5 - 1 + 1) + 1);
                int price = (int)(Math.random() * (1200 - 800 + 1) + 800) * year;
                int deductables = 200 + (int)(Math.random() * (700 - 400 + 1) + 400);
                int totalcover = price * 15;
                System.out.println("<Insurance id = \"I"+i+j+"\">");
                System.out.println("\t<category>"+category[i]+"</category>");
                System.out.println("\t<subcategory>"+subcategory[j]+"</subcategory>");
                System.out.println("\t<name>"+category[i]+subcategory[j]+j+"Insurance"+"</name>");
                System.out.println("\t<duration>"+year+"year"+"</duration>");
                System.out.println("\t<price>"+price+"</price>");
                System.out.println("\t<image>000"+i+j+".png</image>");
                System.out.println("\t<description>This is a dummy description for "+subcategory[j]+" "+"Insurance provided by"+" "+category[i]+"</description>");
                System.out.println("\t<emailId>support"+i+emailext[i]+"</emailId>");
                System.out.println("\t<deductables>"+deductables+"</deductables>");
                System.out.println("\t<totalcover>"+totalcover+"</totalcover>");
                System.out.println("</Insurance>");

            }
        }
    }
}
