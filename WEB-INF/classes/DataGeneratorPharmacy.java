public class DataGeneratorPharmacy {

    public static void main(String []args){
        
        String [] category = {"CVS-Health","Walgreens","Costco-Wholesale-Corp"};

        String [] emailext = {"@cvshealth.com", "@walgreens.com", "@costcopharma.com" };
        
        String [] names = {"CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy","CVS pharmacy","Walgreens pharmacy","Costco pharmacy"};

        String [] cities = {"Bruno","Winnebago","Whitefield","Richardson","Bedias","Elkhart","Bellflower","Jonesburg","Big Sioux","Wyndmere","Little Rock","Graham","Red Bluff","Hawaii National Park","Lawai","Portland","Crawfordsville","Georgetown","Athens","Burrows","Taylorsville","Savannah","Lake Harbor","Sidney Center","Cowlesville","Atlanta","Jacksonville","Casselberry","Lakeland","Chesapeake Beach","Charleston","Cashiers","Bethlehem","Crystal River","Stedman","East Berlin","New Haven","Bronx","Great Neck","Caguas","Farmington","North Georgetown","Benoit","Iuka","Iron River","Alva","Hardinsburg","Santa Monica","San Marino","Van Nuys","Anaheim"};
        
        String [] zips = {"68014","68071","74472","75082","77831","62634","63333","63351","57949","58081","72221","73437","96080","96718","96765","97217","97336","83239","30606","46916","47280","31401","33459","13839","14037","30378","32255","32730","33804","20732","25317","28717","18017","34429","28391","06023","06537","10453","11025","00626","48336","44665","38725","38852","49935","33920","40143","90410","91118","91470","92814"};
        
        String [] lats = {"41.28216","42.232805","35.259201","32.993405","30.74577","40.02489","39.03288","38.862422","42.505818","46.282064","34.751918","34.363418","40.183837","19.435739","21.930922","45.574439","44.359301","42.483479","33.945619","40.584272","39.296605","32.068658","26.645895","42.236762","42.814667","33.844371","30.287041","28.653875","28.002553","38.670858","38.335647","35.103251","40.645665","28.872108","35.016373","41.612748","41.365709","40.853017","40.754757","18.235003","42.458502","40.843563","33.628285","34.803864","46.108022","26.711362","37.777083","33.786594","33.786594","33.786594","33.640302"};
        String [] longs ={"-96.9594","-96.48868","-95.24701","-96.65901","-95.91892","-89.46592","-91.32983","-91.31284","-96.499259","-97.13477","-92.392487","-97.43017","-122.24074","-155.26648","-159.499342","-122.68665","-122.850752","-111.35333","-83.41732","-86.573952","-85.95025","-81.09258","-80.430269","-75.25901","-78.46076","-84.47405","-81.389305","-81.34387","-81.61864","-76.53652","-81.613794","-83.09538","-75.36926","-82.5961","-78.6941","-72.72017","-72.927507","-73.91214","-73.601772","-66.037318","-83.3464","-80.979435","-91.0273","-88.10205","-88.70073","-81.61684","-86.48345","-118.298662","-118.298662","-118.298662","-117.769442"};
        for(int i = 1; i <= 50; i++)
        {
            int price = 500 + (int)(Math.random() * (200 - 100 + 1) + 100);
            int price2 = 200 + (int)(Math.random() * (200 - 100 + 1) + 100);
            int phone = (int)(Math.random() * (9999 - 1000 + 1) + 1000);
            int count = i%3;
            int location = (int)(Math.random() * (39 - 0 + 1) + 0);
            System.out.println("<Pharmacy id = \"p"+i+"\">");
            System.out.println("\t<name>"+names[i]+"</name>");
            System.out.println("\t<image>000"+i+".png</image>");
            System.out.println("\t<description>This is a dummy description for Pharmacy "+category[count]+"</description>");
            System.out.println("\t<category>"+category[count]+"</category>");
            System.out.println("\t<phoneNumber>"+price2+price+phone+"</phoneNumber>");
            System.out.println("\t<emailId>info"+i+emailext[count]+"</emailId>");
            System.out.println("\t<city>"+cities[location]+"</city>");
            System.out.println("\t<zip>"+zips[location]+"</zip>");
            System.out.println("\t<latitude>"+lats[location]+"</latitude>");
            System.out.println("\t<longitude>"+longs[location]+"</longitude>");
            System.out.println("</Pharmacy>");
        }
       
    }
}

