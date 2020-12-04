public class DataGeneratorInsurance {

    public static void main(String []args){
        
        String [] category = {"UnitedHealth","AetnaHealth", "KaiserFoundation"};

        String [] emailext = {"@unitedhealth.com", "@aetnahealth.com", "@kaiserfo.com" };

        String [] subcategory = {"", ""};


        
        String [] names = {"Raye Marietta","Princess Dance","Tamar Biles","Tyisha Yerby","Valentine Clevenger","Patti Shoultz","Stephanie Ahumada","Hong Dudas","Bryanna Wheat","Lynsey Melito","Stephane Capshaw","Zetta Glascock","Hunter Moctezuma","Eliza Federico","Pasquale Spilman","Krystle Wyche","Leonora Choiniere","Reginald Kneip","Sudie Steffy","Samatha Gardner","Barb Wold","Monet Tietjen","Hilaria Mcquade","Reggie Jhonson","Fonda Sharon","Kali Morado","Celeste Woolverton","Tonette Gowin","Connie Lisi","Dorine Bloomquist","Garrett Rolen","Tanika Wickman","Modesta Anspach","Audra Niver","Rubi Dallas","Georgie Rippel","Wava Dade","Preston Schlenker","Weston Agena","Nolan Okeefe","Kylie Gafford","Rosia Rinker","Lucien Merry","Gaynell Bayless","Sue Jamerson","Salina Glueck","Roselia Denny","Mi Kulesza","Phebe Galyean","America Karns"};
        
        String [] cities = {"Eudora","Savanna","Beckville","Rancho Santa Fe","San Diego","San Diego","Huntington Beach","Crown King","Las Vegas","Middletown Springs","Killingworth","Daytona Beach","North Evans","Pricedale","Coolspring","Prospect","Weber City","Sharon","Parsons","Dover AFB","Georgetown","Rehobeth","Philadelphia","Philadelphia","New Kensington","Durham","Sherman Oaks","Palomar Mountain","Lake Forest","Marked Tree","Oklahoma City","Denton","Omaha","Omaha","Kansas City","Idaho Falls","Yellow Pine","Boise","Bountiful","Yuma"};
        
        String [] zips = {"66025","74565","75631","92067","92119","92187","92647","86343","89185","5757","6419","32116","14112","15072","15730","23960","24290","25182","26287","19902","19947","21857","19132","19148","15068","3824","91413","92060","92630","72345","73152","66017","68114","68164","64944","83402","83677","83744","84011","85367"};
        
        String [] lats = {"38.917032","34.831398","32.237924","33.016492","32.80225","33.016928","33.725167","34.201191","35.927901","43.477827","41.380594","29.10909","42.691742","40.13848","41.040903","37.310203","36.617348","38.296818","39.141165","39.131958","38.676552","38.092718","39.995412","39.919812","40.571108","43.128085","33.786594","33.308217","33.640223","35.531429","35.551409","39.720911","41.264531","41.296198","39.035038","43.497685","45.01781","43.459855","40.963547","32.654701"};
        String [] longs = {"-95.06455","-95.83967","-94.46427","-117.20264","-117.02431","-116.846046","-118.00509","-112.3501","-114.972061","-73.12311","-72.57637","-80.984344","-78.992658","-79.85575","-79.08486","-78.55359","-82.5666","-81.554655","-79.67466","-75.46953","-75.39269","-75.888207","-75.16977","-75.15803","-79.74226","-70.96035","-118.298662","-116.8471","-117.69108","-90.414113","-97.407537","-95.27417","-96.04798","-96.11027","-94.356728","-112.07391","-115.55397","-116.243984","-112.115984","-114.40884"};
        
        for(int i = 0; i <= 2; i++){

            for (int j = 0 ; j <= 4; j++){
                int year = (int)(Math.random() * (5 - 1 + 1) + 5);
                int price = (int)(Math.random() * (1200 - 800 + 1) + 800) * year;
                int deductables = 200 + (int)(Math.random() * (700 - 400 + 1) + 400);
                int totalcover = price * 15;
                System.out.println("<Insurance id = \"I"+i+j+"\">");
                System.out.println("\t<category>"+category[i]+"</category>");
                System.out.println("\t<category>"+category[i]+"</category>");
                System.out.println("\t<name>"+names[i]+"</name>");
                System.out.println("\t<price>"+price+"</price>");
                System.out.println("\t<image>000"+i+".png</image>");
                System.out.println("\t<description> This is a dummy description for Health Insurance "+i+"</description>");
                System.out.println("\t<category>"+category[count]+"</category>");
                System.out.println("\t<emailId>support"+i+emailext[count]+"</emailId>");
                System.out.println("\t<city>"+cities[location]+"</city>");
                System.out.println("\t<zip>"+zips[location]+"</zip>");
                System.out.println("\t<latitude>"+lats[location]+"</latitude>");
                System.out.println("\t<longitude>"+longs[location]+"</longitude>");
                System.out.println("</Doctor>");

            }
        }


        for(int i = 1; i <= 40; i++)
        {
            int year = (int)(Math.random() * (5 - 1 + 1) + 5);
            int price = (int)(Math.random() * (1200 - 800 + 1) + 800) * year;
            int deductables = 200 + (int)(Math.random() * (700 - 400 + 1) + 400);
            int totalcover = price * 15;
            int count = i/5;
            int location = (int)(Math.random() * (39 - 0 + 1) + 0);
            System.out.println("<Doctor id = \"d"+i+"\">");
            System.out.println("\t<name>"+names[i]+"</name>");
            System.out.println("\t<price>"+price+"</price>");
            System.out.println("\t<image>000"+i+".png</image>");
            System.out.println("\t<description> This is a dummy description for Health Insurance "+i+"</description>");
            System.out.println("\t<category>"+category[count]+"</category>");
            System.out.println("\t<emailId>support"+i+emailext[count]+"</emailId>");
            System.out.println("\t<city>"+cities[location]+"</city>");
            System.out.println("\t<zip>"+zips[location]+"</zip>");
            System.out.println("\t<latitude>"+lats[location]+"</latitude>");
            System.out.println("\t<longitude>"+longs[location]+"</longitude>");
            System.out.println("</Doctor>");
        }
       
    }
    
}
