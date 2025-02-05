package codewithfreddy;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {
        JsonPath js=new JsonPath(payload.CoursePrice());

        //Print No of courses returned by API
        int courseCount = js.getInt("courses.size()");
        System.out.println("Total courses:" + courseCount);

        //Print Purchase Amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total Amount:" + totalAmount);

        //Print Title of the first course
        String titleFirstCourse=js.get("courses[2].title");
        System.out.println(titleFirstCourse);

        //Print All course titles and their respective Prices
        for(int i=0;i<courseCount;i++)
        {
            String courseTitles=js.get("courses["+i+"].title");
            System.out.println(courseTitles);
            System.out.println(js.get("courses["+i+"].price").toString());


        }

        //Print no of copies sold by RPA Course

        System.out.println("Print no of copies sold by RPA Course");

        for(int i=0;i<courseCount;i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }
    }
}
