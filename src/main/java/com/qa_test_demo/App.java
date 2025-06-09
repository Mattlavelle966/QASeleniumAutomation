package com.qa_test_demo;

import java.io.IOException;


public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Java here" );
        try {
            ConvertCsvXlsx.convert("logs/tests.csv", "logs/testconversion.xlsx");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
